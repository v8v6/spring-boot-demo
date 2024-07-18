package com.example.springboot.demo.pojo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenjunxi
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EarlyWarningRecordPushListReqDTO implements Serializable {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 预警类型
     */
    private String eventType;

    /**
     * 监控开始日期
     */
    private String sendDate;

    /**
     * 反馈状态 0为反馈 1已反馈
     */
    private Integer feedback;

    private List<Long> earlyWarningRecordIds;

    private List<Long> pushIds;

}
