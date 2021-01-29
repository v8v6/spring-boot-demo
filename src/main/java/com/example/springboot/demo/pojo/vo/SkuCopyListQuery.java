package com.example.springboot.demo.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

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
