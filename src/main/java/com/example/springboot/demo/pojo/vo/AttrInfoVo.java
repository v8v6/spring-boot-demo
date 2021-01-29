package com.example.springboot.demo.pojo.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SKU品类属性信息
 *
 * @Author chenjunxi02
 * @Date 2020/12/29
 * @Version 1.0
 */
@Data
public class AttrInfoVo implements Serializable {
    /**
     * 核心属性
     */
    private List<AttrBean> coreAttrList;
    /**
     * 销售属性
     */
    private List<AttrBean> managementAttrList;
    /**
     * 质量属性
     */
    private List<AttrBean> qualityAttrList;
    /**
     * 一般属性
     */
    private List<AttrBean> displayAttrList;

    @Data
    public static class AttrBean implements Serializable {
        private static final long serialVersionUID = -6610138130146415533L;
        /**
         * 属性项id
         */
        private Integer attrId;
        /**
         * 属性项名称
         */
        private String attrName;
        /**
         * 属性值名称
         */
        @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
        private String attrValue;
        /**
         * 属性值id
         */
        @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
        private Integer attrValueId;
        /**
         * 属性组ID
         */
        private Integer attrGroupId;
        /**
         * 输入框类型
         */
        private String inputType = "SINGLE_SELECT";
        /**
         * 是否必填 默认必填
         */
        private Boolean isMust = true;
    }

    public static void main(String[] args) {
        AttrInfoVo attrInfoVo = new AttrInfoVo();
        List<AttrBean> coreAttrList = new ArrayList() {{
        }};
        coreAttrList.add(new AttrBean());
        AttrBean attrBean = new AttrBean();
        attrBean.setAttrValueId(123);
        attrBean.setAttrValue("xxx");
        coreAttrList.add(attrBean);
        attrInfoVo.setCoreAttrList(coreAttrList);
        System.out.println(JSON.toJSONString(attrInfoVo,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.SkipTransientField));
    }
}
