package com.example.springbootdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginEventPrintLogListener {


    @EventListener
    public void handleUserLoginEvent(LogonEvent event) {
        Object obj = event.getSource();
        String username = event.getUserName();
        // 在这里执行处理用户登录事件的逻辑，例如记录日志或触发其他操作
        log.info("User logged in: {}obj:{}", username, obj);
        log.info("这里是LoginEventPrintLogListener同步的执行?{}", Thread.currentThread().getName());
    }
}