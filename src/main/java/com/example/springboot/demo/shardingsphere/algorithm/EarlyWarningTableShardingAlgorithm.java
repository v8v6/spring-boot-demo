package com.example.springboot.demo.shardingsphere.algorithm;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
public final class EarlyWarningTableShardingAlgorithm implements StandardShardingAlgorithm<Date> {

    private Properties properties;

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter formatter = builder.appendValue(ChronoField.YEAR_OF_ERA, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral("_q")
                .appendValue(IsoFields.QUARTER_OF_YEAR, 1)
                .toFormatter(Locale.CHINA);

        // 按照年&季度进行分表处理
        // 2024_Q1,2024_Q2,2024_Q3,2024_Q4

        Date monitorTime = preciseShardingValue.getValue();
        LocalDate monitorTimeLocalDate = DateUtil.toLocalDateTime(monitorTime).toLocalDate();

        // xxxxx_2024_Q1
        return preciseShardingValue.getLogicTableName() + "_" + monitorTimeLocalDate.format(formatter);
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> rangeShardingValue) {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter formatter = builder.appendValue(ChronoField.YEAR_OF_ERA, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral("_q")
                .appendValue(IsoFields.QUARTER_OF_YEAR, 1)
                .toFormatter(Locale.CHINA);

        String logicTableName = rangeShardingValue.getLogicTableName();
        Range<Date> valueRange = rangeShardingValue.getValueRange();
        Date lowerDate = valueRange.lowerEndpoint();
        Date upperDate = valueRange.upperEndpoint();

        log.info("lowerDate:{}, upperDate:{}", lowerDate, upperDate);

        // 范围查询只处理在年_季度内的,就算给了超过分表范围内的数据,默认查询最后一个年_季度时间范围的数据
        return DateUtil.rangeToList(lowerDate, upperDate, DateField.MONTH)
                .stream()
                .sorted(Comparator.comparing(Date::getTime).reversed())
                .map(o -> DateUtil.toLocalDateTime(o).toLocalDate())
                .map(o -> logicTableName + "_" + o.format(formatter))
                .distinct()
                .limit(1)
                .collect(Collectors.toList());
    }

    @Override
    public void init(Properties props) {
        log.info("begin to init EarlyWarningTableShardingAlgorithm ");
        this.properties = props;
    }

    @Override
    public Properties getProps() {
        return this.properties;
    }
}
