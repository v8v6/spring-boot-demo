package com.example.springboot.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.demo.mapper.EarlyWarningRecordCommonMapper;
import com.example.springboot.demo.model.EarlyWarningRecordCommon;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListReqDTO;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListResDTO;
import com.example.springboot.demo.service.EarlyWarningRecordCommonDbService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EarlyWarningRecordCommonDbServiceImpl extends ServiceImpl<EarlyWarningRecordCommonMapper, EarlyWarningRecordCommon> implements EarlyWarningRecordCommonDbService {

    @Override
    public List<EarlyWarningRecordListResDTO> queryContainPushList(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO) {
        earlyWarningRecordListReqDTO.setPageSize(-1);
        return pageQueryContainPush(earlyWarningRecordListReqDTO).getRecords();
    }

    @Override
    public IPage<EarlyWarningRecordListResDTO> pageQueryContainPush(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO) {
        Page pg = new Page<>(earlyWarningRecordListReqDTO.getPageNum(), earlyWarningRecordListReqDTO.getPageSize());
        return baseMapper.selectPageContainPush(pg, earlyWarningRecordListReqDTO);
    }

    @Override
    public IPage<EarlyWarningRecordListResDTO> query(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO) {
        Page pg = new Page<>(earlyWarningRecordListReqDTO.getPageNum(), earlyWarningRecordListReqDTO.getPageSize());
        return baseMapper.query(pg, earlyWarningRecordListReqDTO);
    }

    @Override
    public List<EarlyWarningRecordListResDTO> queryList(EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO) {
        earlyWarningRecordListReqDTO.setPageSize(-1);
        return query(earlyWarningRecordListReqDTO).getRecords();
    }
}
