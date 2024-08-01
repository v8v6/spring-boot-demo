package com.example.springbootdemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @SentinelResource("HelloWorld")
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }
}
