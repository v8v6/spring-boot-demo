package com.example.springbootdemo.controller;

/**
 * @Author chenjunxi02
 * @Date 2021/1/29
 */

import com.example.springbootdemo.SkuCopyListQuery;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenjunxi02
 * @Date 2021/1/2
 */
@RestController
public class DemoController {

    @PostMapping(value = "/skuCopyList")
    public String skuCopyList(@RequestBody SkuCopyListQuery skuCopyListQuery) {
        return "";
    }

}
