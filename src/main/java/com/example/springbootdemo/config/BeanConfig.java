package com.example.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class BeanConfig {

    /**
     * @return
     * @Async 使用的线程池参看下面链接。
     * 1、默认的TaskExecutor实例是直接队列无限制；
     * 2、创建SimpleAsyncTaskExecutor实例,默认是创建线程;
     * 建议是自定义线程池最好
     * @see org.springframework.aop.interceptor.AsyncExecutionInterceptor#getDefaultExecutor(org.springframework.beans.factory.BeanFactory)
     */
    @Bean
    public TaskExecutor threadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(20);
        executor.setKeepAliveSeconds(1);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("task-thread-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();
        return executor;
    }
}
