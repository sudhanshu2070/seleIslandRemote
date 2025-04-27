package com.example.sele_spring_app.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Service;

@Service
public class CodeExecutionService {

    public String compileAndExecute(String code) throws Exception {
        // Save the user's code to a temporary file
        Path tempDir = Files.createTempDirectory("user-code");
        Path javaFile = tempDir.resolve("Main.java");
        Files.write(javaFile, code.getBytes());

        // Compile the code
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, null, null, javaFile.toString());
        if (compileResult != 0) {
            throw new Exception("Compilation failed.");
        }

        // Run the compiled code
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", tempDir.toString(), "Main");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Capture the output
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        return output.toString();
    }
}