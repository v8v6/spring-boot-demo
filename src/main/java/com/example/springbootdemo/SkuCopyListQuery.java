package com.example.springbootdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author chenjunxi02
 * @Date 2021/1/29
 */
@Data
public class SkuCopyListQuery implements Serializable {
    private static final long serialVersionUID = 469681544213097735L;

    private Condition condition;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Condition implements Serializable {
        private static final long serialVersionUID = 469681544213097735L;
        private Integer skuId;
        private String skuName;
        private Set<Integer> pClass2Ids;
    }

}