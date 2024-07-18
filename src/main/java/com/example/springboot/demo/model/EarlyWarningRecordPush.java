package com.example.springboot.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("early_warning_record_push")
@EqualsAndHashCode(callSuper = false)
public class EarlyWarningRecordPush implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 告警记录id
     */
    private Long warningRecordId;
    /**
     * 推送消息的用户id,慧养猪账户id
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 飞书用户id
     */
    private String feishuId;
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 公司ouId编码
     */
    private String companyCode;
    /**
     * 公司ebs编码
     */
    private String companyEbsCode;
    /**
     * 场线编码
     */
    private String lineCode;
    /**
     * 批次号
     */
    private String batchCode;
    /**
     * 批次类型
     */
    private String batchType;
    /**
     * 推送状态 0失败/1成功
     */
    private Integer sendStatus;
    /**
     * 推送日期
     */
    private String sendDate;

    private Date monitorTime;
    /**
     * 是否反馈 0为反馈 1.已反馈 默认0
     */
    private Integer feedback;
    /**
     * 反馈时间
     */
    private Date feedbackTime;
    /**
     * 预警原因
     */
    private String reason;
    /**
     * 预警说明
     */
    @TableField(value = "`explain`")
    private String explain;
    /**
     * 解决方案
     */
    private String solution;
    /**
     * 创建人id
     */
    private String cI;

    /**
     * 创建人名称
     */
    private String cN;

    /**
     * 创建时间
     */
    private Date cT;

    /**
     * 修改人id
     */
    private String uI;


    /**
     * 修改人名称
     */
    private String uN;

    /**
     * 修改时间
     */

    private Date uT;
    /**
     *
     */
    private Integer isDeleted;
    /**
     * 用户手机号
     */
    private String phone;
}
