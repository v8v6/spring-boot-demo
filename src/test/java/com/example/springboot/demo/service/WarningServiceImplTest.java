package com.example.springboot.demo.service;

import com.alibaba.fastjson2.JSON;
import com.example.springboot.demo.SpringBootDemoApplication;
import com.example.springboot.demo.model.EarlyWarningRecordCommon;
import com.example.springboot.demo.model.EarlyWarningRecordPush;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListReqDTO;
import com.example.springboot.demo.pojo.vo.EarlyWarningRecordListResDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * @Author chenjunxi02
 * @Date 2021/1/4
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WarningServiceImplTest {

    @Autowired
    private EarlyWarningRecordCommonDbService earlyWarningRecordCommonDbService;

    @Autowired
    private EarlyWarningRecordPushDBService earlyWarningRecordPushDBService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void testSave() {
        LocalDate localDate = LocalDate.now();

        transactionTemplate.execute(status -> {
            EarlyWarningRecordCommon earlyWarningRecordCommon = new EarlyWarningRecordCommon();
            earlyWarningRecordCommon.setCompanyCode("1");
            earlyWarningRecordCommon.setCompanyEbsCode("1");
            earlyWarningRecordCommon.setLineCode("1");
            earlyWarningRecordCommon.setBatchCode("1");
            earlyWarningRecordCommon.setBatchType("1");
            earlyWarningRecordCommon.setEventType("1");
            earlyWarningRecordCommon.setShortContent("1");
            earlyWarningRecordCommon.setContent("1");
            earlyWarningRecordCommon.setMessageType("1");
            earlyWarningRecordCommon.setSendTime(new Date());
            earlyWarningRecordCommon.setMonitorTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            earlyWarningRecordCommon.setMonitorTimeRange("");
            earlyWarningRecordCommon.setDayAge(0);
            earlyWarningRecordCommon.setWeekAge(0);
            earlyWarningRecordCommon.setConsecutiveNum(0);
            earlyWarningRecordCommon.setDeviationDay(0);
            earlyWarningRecordCommon.setPigNum(0);
            earlyWarningRecordCommon.setDeviation(0);
            earlyWarningRecordCommon.setFeedingRecordId(0L);
            earlyWarningRecordCommon.setRelationId(0L);
            earlyWarningRecordCommon.setRecoveryStatus("");
            earlyWarningRecordCommon.setRecoveryTime(new Date());
            earlyWarningRecordCommon.setCI("");
            earlyWarningRecordCommon.setCN("");
            earlyWarningRecordCommon.setCT(new Date());
            earlyWarningRecordCommon.setUI("");
            earlyWarningRecordCommon.setUN("");
            earlyWarningRecordCommon.setUT(new Date());
            earlyWarningRecordCommon.setIsDeleted(0);
            earlyWarningRecordCommon.setDeviationPercent(new BigDecimal("0"));
            earlyWarningRecordCommon.setConvertUuid("");
            earlyWarningRecordCommon.setFeedback(0);

            earlyWarningRecordCommonDbService.save(earlyWarningRecordCommon);

            EarlyWarningRecordPush earlyWarningRecordPush = new EarlyWarningRecordPush();
            earlyWarningRecordPush.setWarningRecordId(earlyWarningRecordCommon.getId());
            earlyWarningRecordPush.setUserId("");
            earlyWarningRecordPush.setUserName("");
            earlyWarningRecordPush.setFeishuId("");
            earlyWarningRecordPush.setEventType("");
            earlyWarningRecordPush.setCompanyCode("");
            earlyWarningRecordPush.setCompanyEbsCode("");
            earlyWarningRecordPush.setLineCode("");
            earlyWarningRecordPush.setBatchCode("");
            earlyWarningRecordPush.setBatchType("");
            earlyWarningRecordPush.setSendStatus(0);
            earlyWarningRecordPush.setSendDate("");
            earlyWarningRecordPush.setMonitorTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

            earlyWarningRecordPush.setFeedback(0);
            earlyWarningRecordPush.setFeedbackTime(new Date());
            earlyWarningRecordPush.setReason("");
            earlyWarningRecordPush.setExplain("");
            earlyWarningRecordPush.setSolution("");
            earlyWarningRecordPush.setCI("");
            earlyWarningRecordPush.setCN("");
            earlyWarningRecordPush.setCT(new Date());
            earlyWarningRecordPush.setUI("");
            earlyWarningRecordPush.setUN("");
            earlyWarningRecordPush.setUT(new Date());
            earlyWarningRecordPush.setIsDeleted(0);
            earlyWarningRecordPush.setPhone("");

            earlyWarningRecordPushDBService.save(earlyWarningRecordPush);
            return true;
        });
    }

    @Test
    public void testWarningRecordTableQuery1() {
        LocalDate localDate = LocalDate.now();
        EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO = new EarlyWarningRecordListReqDTO();
        earlyWarningRecordListReqDTO.setMonitorTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        List<EarlyWarningRecordListResDTO> earlyWarningRecordListResDTOS
                =  earlyWarningRecordCommonDbService.queryList(earlyWarningRecordListReqDTO);
        log.info("testWarningRecordTableQuery1:{}", JSON.toJSONString(earlyWarningRecordListResDTOS));
    }

    @Test
    public void testWarningRecordTableQuery2() {
        LocalDate localDate = LocalDate.now();

        // 开始
        LocalDate localDate1 = localDate.plusMonths(-3);

        EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO = new EarlyWarningRecordListReqDTO();
        earlyWarningRecordListReqDTO.setStartMonitorTime(Date.from(localDate1.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        earlyWarningRecordListReqDTO.setEndMonitorTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        List<EarlyWarningRecordListResDTO> earlyWarningRecordListResDTOS
                =  earlyWarningRecordCommonDbService.queryList(earlyWarningRecordListReqDTO);
        log.info("testWarningRecordTableQuery2:{}", JSON.toJSONString(earlyWarningRecordListResDTOS));
    }


    @Test
    public void testConnectedTableQuery() {
        LocalDate localDate = LocalDate.now();

        EarlyWarningRecordListReqDTO earlyWarningRecordListReqDTO = new EarlyWarningRecordListReqDTO();
        earlyWarningRecordListReqDTO.setMonitorTime(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        List<EarlyWarningRecordListResDTO> earlyWarningRecordListResDTOS
                =  earlyWarningRecordCommonDbService.queryContainPushList(earlyWarningRecordListReqDTO);
        log.info("testConnectedTableQuery:{}", JSON.toJSONString(earlyWarningRecordListResDTOS));

    }
}
