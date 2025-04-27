package com.example.sele_spring_app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.stereotype.Service;

@Service
public class CodeExecutionService {

    private static final String PREDEFINED_IMPORTS = """
            import org.openqa.selenium.By;
            import com.example.sele_spring_app.util.WebDriverUtil;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.WebElement;
            """;

    public String compileAndExecute(String userCode) throws Exception {
        // Append predefined imports to the user's code
        String fullCode = PREDEFINED_IMPORTS + "\n" + userCode;

        // Save the combined code to a temporary file
        Path tempDir = Files.createTempDirectory("user-code");
        Path javaFile = tempDir.resolve("Main.java");
        Files.write(javaFile, fullCode.getBytes());

        // Compile the code
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compileResult = compiler.run(null, null, null, javaFile.toString());
        if (compileResult != 0) {
            throw new Exception("Compilation failed.");
        }

        // Run the compiled code
        String classpath = String.join(File.pathSeparator,
            tempDir.toString(),                          // user's compiled code
            "target/classes",      // Include the compiled classes of your app
            "target/sele-spring-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar"  // app's fat JAR
        );
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", classpath, "Main");

        //ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", tempDir.toString(), "Main");
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