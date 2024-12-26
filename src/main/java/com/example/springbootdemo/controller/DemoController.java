package com.example.springbootdemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springbootdemo.service.UserDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/demo")
@RestController
public class DemoController {

    @Resource
    private UserDBService userDBService;

    @SentinelResource(value = "querySkusInfo", blockHandler = "blockHandlerMethod")
    @GetMapping("/querySkusInfo")
    public String helloWorld(@RequestParam(value = "skuId", required = false)String skuId) {
        // 模拟调用服务出现异常
        if ("0".equals(skuId)) {
            throw new RuntimeException();
        }
        return "querySkusInfo";
    }

    @GetMapping("/byHotKey")
    @SentinelResource(value = "byHotKey",
            blockHandler = "skuAccessError", fallback = "skuAccessFallback")
    public String test4(@RequestParam(value = "userId", required = false) String userId,
                        @RequestParam(value = "skuId", required = false) int skuId) {
        log.info(Thread.currentThread().getName() + "\t" + "...byHotKey");
        return "-----------by HotKey： skuId：" + skuId;
    }

    public String skuAccessFallback(String userId, int skuId) {
        return "------skuAccessFallback，i am blocked  byHotKey";
    }

    public String skuAccessError(String userId, int skuId, BlockException exception) {

        return "------skuAccessError，Error  byHotKey";
    }


    /**
     * 接口抛出限流或降级时的处理逻辑
     * <p>
     * 注意: 方法参数、返回值要与原函数保持一致
     *
     * @return
     */
    public String blockHandlerMethod(String skuId, BlockException e) {
        log.info("返回熔断结果", e.toString());
        return "异常次数太多，直接熔断了 , 返回 res: " + skuId;

    }
}
