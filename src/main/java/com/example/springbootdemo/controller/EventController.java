package com.example.springbootdemo.controller;

import com.example.springbootdemo.event.LogonEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping(value = "/send/hello")
    public String sendHello(String name) {
        applicationEventPublisher.publishEvent(new LogonEvent(name, name));
        log.info("这里是 Controller同步的执行?{}", Thread.currentThread().getName());
        return name;
    }
}
