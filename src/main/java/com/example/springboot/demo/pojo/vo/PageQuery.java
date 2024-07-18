package com.example.springboot.demo.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PageQuery implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页
	 */
	private Integer pageNum = 1;

	/**
	 * 每页的数量
	 */
	private Integer pageSize = 10;

	/**
	 * 正序的字段名，多个字段逗号隔开
	 */

	private String ascend;

	/**
	 * 倒序的字段名,多个字段逗号隔开
	 */
	private String descend;

}
