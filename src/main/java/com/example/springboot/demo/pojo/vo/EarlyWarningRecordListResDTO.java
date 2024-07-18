package com.example.springboot.demo.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class EarlyWarningRecordListResDTO {

    private Long id;

    private Long earlyWarningRecordId;

    /**
     * 公司ouid编码
     */
    private String companyCode;

    /**
     * 公司ebs编码
     */
    private String companyEbsCode;

    /**
     * 猪场id，填写场线编码
     */
    private String lineCode;

    /**
     * 批次号
     */
    private String batchCode;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 亮灯类型
     * 预警传：WARNING_RULE
     */
    private String lightType;

    /**
     * 亮灯结果
     * 预警传：WARNING_LIGHT
     */
    private String lightResult;

    /**
     * 概览内容
     * 发送概览内容
     */
    private String shortContent;

    /**
     * 内容明细
     * 发送详情内容
     */
    private String content;

    /**
     * 消息类型（小类）
     */
    private String ruleCode;

    /**
     * 定时消息：SCHEDULE、实时消息：REALTIME
     */
    private String messageType;

    /**
     * 关联id
     */
    private Long relationId;

    /**
     * 存栏量
     */
    private Integer pigNum;

    /**
     * 预警时的日龄
     */
    private Integer dayAge;

    /**
     * 当前预警的连续预警次数
     */
    private Integer consecutiveNum;

    private BigDecimal deviationPercent;

    private Integer deviation;

    /**
     * 监控日期,涉及到其他预警,可能各自显示的格式不同
     * 需要业务接口自己转化为自己的格式 (yyyy-MM-dd、yyyy-MM-dd HH:mm:ss)
     */
    private Date monitorTime;

    private Integer feedback;


    private List<EarlyWarningRecordPushListResDTO> earlyWarningRecordPushs;


    public Long getEarlyWarningRecordId() {
        return id;
    }
}
