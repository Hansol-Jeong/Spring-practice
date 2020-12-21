package com.fastcampus.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// controller+responseBody
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
