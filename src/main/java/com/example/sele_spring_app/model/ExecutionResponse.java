package com.example.sele_spring_app.model;

public class ExecutionResponse {
    private String output;

    // Constructor
    public ExecutionResponse(String output) {
        this.output = output;
    }

    // Getter
    public String getOutput() {
        return output;
    }

    // Setter
    public void setOutput(String output) {
        this.output = output;
    }
}