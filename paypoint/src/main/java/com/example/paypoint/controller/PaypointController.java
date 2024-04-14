package com.example.paypoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paypoint")
public class PaypointController {
    @GetMapping("/welcome")
    public String welcome() {

        return "Welcome to the First service.";
    }
}