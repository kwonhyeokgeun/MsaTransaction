package com.example.paypoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class PaypointController {

    @GetMapping("/a")
    void test(){
        System.out.println("!!!!");
    }
}
