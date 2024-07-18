CREATE TABLE `t_user_0` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别 0-男，1-女',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `t_user_1` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别 0-男，1-女',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


create table early_warning_record_common
(
    id                 bigint auto_increment comment 'id'
        primary key,
    company_code       varchar(64)                                   null comment '公司ouId编码',
    company_ebs_code   varchar(64)                                   null comment '公司ebs编码',
    line_code          varchar(64)                                   null comment '场线编码',
    batch_code         varchar(100)                                  null comment '批次号',
    batch_type         varchar(64)                                   null comment '批次类型',
    event_type         varchar(100)                                  null comment '事件类型',
    short_content      varchar(255)                                  null comment '概览内容',
    content            varchar(5000)                                 null comment '内容明细',
    message_type       varchar(255)                                  null comment '定时消息：SCHEDULE、实时消息：REALTIME',
    send_time          datetime                                      null comment '发送MQ的时间',
    monitor_time       datetime                                      null comment '监控开始时间',
    monitor_time_range varchar(64)                                   null comment '监控时间范围',
    day_age            int(4)                                        null comment '预警时的日龄',
    week_age           int(4)                                        null comment '预警时的周龄',
    consecutive_num    int(4)                                        null comment '当前预警的连续预警次数',
    deviation          tinyint                                       null comment '百分比偏差1.偏高2.偏低',
    pig_num            int(10)                                       null comment '存栏量',
    feeding_record_id  bigint(10)                                    null comment '饲喂记录主键id，预警类型为自动饲喂的才有',
    relation_id        bigint                                        null comment '关联外部主键id',
    recovery_status    varchar(32)         default ''                null comment '恢复状态',
    recovery_time      datetime                                      null comment '恢复时间',
    feedback           tinyint(2)          default 0                 null comment '反馈状态 0 未反馈 1 已反馈',
    is_deleted         tinyint(4) unsigned default 0                 not null comment '是否删除，0表示未删除；1表示已经删除',
    c_i                varchar(255)                                  null comment '创建人id',
    c_n                varchar(255) collate utf8_bin                 null comment '创建人名称',
    c_t                datetime            default CURRENT_TIMESTAMP null comment '创建时间',
    u_i                varchar(255)                                  null comment '修改人id',
    u_n                varchar(255) collate utf8_bin                 null comment '修改人名称',
    u_t                datetime            default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    deviation_percent  decimal(12, 4)                                null comment '偏差百分比，正数 不需要%',
    deviation_day      int(4)                                        null comment '不足天数'
)
    comment '预警消息信息表';

create table early_warning_record_push
(
    id                bigint auto_increment comment '主键'
        primary key,
    warning_record_id bigint                                        not null comment '告警记录id',
    user_id           varchar(32)                                   null comment '推送消息的用户id,慧养猪账户id',
    user_name         varchar(100)                                  null comment '用户名称',
    feishu_id         varchar(64)                                   null comment '飞书用户id',
    event_type        varchar(64)                                   not null comment '事件类型',
    company_code      varchar(64)                                   null comment '公司ouId编码',
    company_ebs_code  varchar(64)                                   null comment '公司ebs编码',
    line_code         varchar(64)                                   null comment '场线编码',
    batch_code        varchar(64)                                   null comment '批次号',
    batch_type        varchar(64)                                   null comment '批次类型',
    send_status       tinyint             default 0                 null comment '推送状态 0 未发送/1已发送',
    send_date         varchar(20)         default ''                null comment '推送日期',
    feedback          tinyint             default 0                 null comment '是否反馈 0为反馈 1.已反馈 默认0',
    feedback_time     datetime                                      null comment '反馈时间',
    reason            varchar(100)                                  null comment '预警原因',
    `explain`         varchar(200)                                  null comment '预警说明',
    solution          varchar(200)                                  null comment '解决方案',
    image_urls        varchar(2048)                                 null comment '图片',
    is_deleted        tinyint(4) unsigned default 0                 not null comment '是否删除，0表示未删除；1表示已经删除',
    c_i               varchar(255)                                  null comment '创建人id',
    c_n               varchar(255) collate utf8_bin                 null comment '创建人名称',
    c_t               datetime            default CURRENT_TIMESTAMP null comment '创建时间',
    u_i               varchar(255)                                  null comment '修改人id',
    u_n               varchar(255) collate utf8_bin                 null comment '修改人名称',
    u_t               datetime            default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    phone             varchar(20)                                   null comment '电话号码'
)
    comment '消息推送记录表';