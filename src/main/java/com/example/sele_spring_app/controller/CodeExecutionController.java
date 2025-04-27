package com.example.sele_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sele_spring_app.model.CodeRequest;
import com.example.sele_spring_app.service.CodeExecutionService;

@RestController
@RequestMapping("/execute")
public class CodeExecutionController {

    @Autowired
    private CodeExecutionService codeExecutionService;

    @PostMapping
    // public ExecutionResponse executeCode(@RequestBody CodeRequest request) {
    public String executeCode(@RequestBody CodeRequest request) {
        // try {
        //     String output = codeExecutionService.compileAndExecute(request.getCode());
        //     return new ExecutionResponse(output);
        // } catch (Exception e) {
        //     return new ExecutionResponse("Error: " + e.getMessage());
        // }

        try {
            return codeExecutionService.compileAndExecute(request.getCode());
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
