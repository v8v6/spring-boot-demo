package com.example.springboot.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
public class EarlyWarningRecordCommon {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
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
     * 事件类型
     */
    private String eventType;

    /**
     * 概览内容
     */
    private String shortContent;
    /**
     * 内容明细
     */
    private String content;

    /**
     * 定时消息：SCHEDULE、实时消息：REALTIME
     */
    private String messageType;


    /**
     * 发送MQ的时间
     */
    private Date sendTime;

    /**
     * 监控的时间点 ，如果是一周,则是一周的第一天
     */
    private Date monitorTime;

    /**
     * 监控时间段
     */
    private String monitorTimeRange;

    /**
     * 预警时的日龄
     */
    private Integer dayAge;
    /**
     * 预警时的周龄
     */
    private Integer weekAge;
    /**
     * 当前预警的连续预警次数
     */
    private Integer consecutiveNum;

    /**
     * 不足天数
     */
    private Integer deviationDay;

    /**
     * 存栏量
     */
    private Integer pigNum;

    /**
     * 百分比偏差1.偏高2.偏低
     */
    private Integer deviation;

    /**
     * 饲喂记录主键id
     */
    private Long feedingRecordId;

    /**
     * 外部主键id
     */
    private Long relationId;

    /**
     * 恢复状态
     */
    private String recoveryStatus;

    /**
     * 恢复时间
     */
    private Date recoveryTime;

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
     * 偏差百分比
     */
    @TableField("deviation_percent")
    private BigDecimal deviationPercent;

    /**
     * 业务转换过程中使用的唯一id，无业务含义
     */
    @TableField(exist = false)
    private String convertUuid;

    /**
     * 反馈状态
     */
    private Integer feedback;
}
