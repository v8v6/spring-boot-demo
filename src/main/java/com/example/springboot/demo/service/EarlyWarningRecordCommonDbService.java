package com.example.springboot.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.demo.model.EarlyWarningRecordCommon;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListReqDTO;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListResDTO;

import java.util.List;


public interface EarlyWarningRecordCommonDbService extends IService<EarlyWarningRecordCommon> {

    List<EarlyWarningRecordListResDTO> queryContainPushList(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);

    IPage<EarlyWarningRecordListResDTO> pageQueryContainPush(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);

    IPage<EarlyWarningRecordListResDTO> query(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);

    List<EarlyWarningRecordListResDTO> queryList(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);
}
