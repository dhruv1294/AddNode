package com.example.fn;

public class AddNode {

    public String handleRequest(String input) {
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        System.out.println("Inside Java Hello World function"); 
        return "Hello, " + name + "!";
    }

}