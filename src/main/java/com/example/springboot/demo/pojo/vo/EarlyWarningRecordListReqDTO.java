package com.example.springboot.demo.pojo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * @author chenjunxi
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EarlyWarningRecordListReqDTO extends PageQuery {

    private List<Long> earlyWarningRecordIds;

    private List<String> relationIds;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 预警类型
     */
    private String eventType;

    private List<String> eventTypes;

    /**
     * 监控开始日期
     */
    private String sendDate;

    private Date monitorTime;

    private Date startMonitorTime;

    private Date endMonitorTime;

    /**
     * 反馈状态 0为反馈 1已反馈
     */
    private Integer feedback;

    private String userId;

}
