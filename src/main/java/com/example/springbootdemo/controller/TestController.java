package com.example.springbootdemo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = {"/test"})
public class TestController {

    @GetMapping(value = "/demo")
    public String demo() {
        return "hello world!demo...";
    }
}
