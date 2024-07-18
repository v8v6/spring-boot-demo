package com.example.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.demo.model.EarlyWarningRecordCommon;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListReqDTO;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListResDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EarlyWarningRecordCommonMapper extends BaseMapper<EarlyWarningRecordCommon> {

    IPage<EarlyWarningRecordListResDTO> selectPageContainPush(@Param("pg") Page pg, @Param("dto") EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);

    IPage<EarlyWarningRecordListResDTO> query(@Param("pg") Page pg, @Param("dto") EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO);

}
