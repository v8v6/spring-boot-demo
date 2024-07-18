package com.example.springboot.demo.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class EarlyWarningRecordPushListResDTO {

    private Long earlyWarningRecordPushId;

    private Long earlyWarningRecordId;

    private String userId;

    private String userName;

    private String phone;

    /**
     * 反馈状态 0为反馈 1已反馈
     */
    private Integer feedback;

    /**
     * 反馈时间
     */
    private Date feedbackTime;

    /**
     * 预警说明
     */
    private String explain;

    /**
     * 解决方案
     */
    private String solution;

    /**
     * 异常原因
     */
    private String reason;

    /**
     * 图片
     */
    private String imageUrls;

    /**
     * 飞书用户id
     */
    private String feishuId;
    /**
     * 事件类型
     */
    private String eventType;
    /**
     *公司ouId编码
     */
    private String companyCode;
    /**
     *公司ebs编码
     */
    private String companyEbsCode;
    /**
     *场线编码
     */
    private String lineCode;
    /**
     *批次号
     */
    private String batchCode;
    /**
     *批次类型
     */
    private String batchType;
    /**
     *推送状态 0失败/1成功
     */
    private Integer sendStatus;
    /**
     * 推送日期
     */
    private String sendDate;

}
