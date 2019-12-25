package com.example.springbootdemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DataArea {

  @TableId(type = IdType.AUTO)
  private Long id;
  private String name;
  private String areaCode;
  private String cityCode;
}
