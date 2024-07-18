package com.example.springboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.demo.mapper.EarlyWarningRecordPushMapper;
import com.example.springboot.demo.model.EarlyWarningRecordPush;
import com.example.springboot.demo.service.EarlyWarningRecordPushDBService;
import org.springframework.stereotype.Service;

/**
 * 消息推送记录DB服务
 */
@Service
public class EarlyWarningRecordPushDBServiceImpl extends ServiceImpl<EarlyWarningRecordPushMapper,
        EarlyWarningRecordPush> implements EarlyWarningRecordPushDBService {


}
