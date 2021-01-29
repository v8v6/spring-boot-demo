package com.example.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.demo.pojo.vo.AttrInfoVo;
import com.example.springboot.demo.pojo.vo.SkuCopyListQuery;
import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author chenjunxi02
 * @Date 2021/1/2
 */
@RestController
public class DemoController {

    @GetMapping(value = "/product/sku/template/attr")
    public AttrInfoVo getDemo() {
        // 这里做下兼容,处理下不返回默认值的问题
        AttrInfoVo attrInfo = new AttrInfoVo();

        List list = Lists.newArrayList();
        AttrInfoVo.AttrBean attrBean = new AttrInfoVo.AttrBean();
        attrBean.setAttrId(0);
        attrBean.setAttrName("22");
        attrBean.setAttrGroupId(0);
        attrBean.setInputType("221");
        attrBean.setIsMust(false);
        list.add(attrBean);
        attrInfo.setCoreAttrList(list);
        return attrInfo;
    }

    @PostMapping(value = "/skuCopyList")
    public String skuCopyList(@RequestBody SkuCopyListQuery skuCopyListQuery) {
        return "";
    }

}
