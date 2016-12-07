package com.toread.sys.entity;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.common.tree.annotation.TreeText;

/**
 *
 * 
 *
 */
@TableName("sys_department")
public class Department implements Serializable  {
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 部门主键 */
	@TableId(value = "dpt_id")
	@TreeId
	private Long dptId;

	/** 父部门id */
	@TableField(value = "dpt_pid")
	@TreePid
	private Long dptPid;

	/** 部门名称 */
	@TableField(value = "dpt_name")
	@TreeText
	private String dptName;

	/** 部门类型 */
	@TableField(value = "dpt_type")
	private String dptType;

	public Department(Long dptId) {
		this.dptId = dptId;
	}

	public Department() {
	}

	public Long getDptId() {
		return this.dptId;
	}

	public void setDptId(Long dptId) {
		this.dptId = dptId;
	}

	public Long getDptPid() {
		return this.dptPid;
	}

	public void setDptPid(Long dptPid) {
		this.dptPid = dptPid;
	}

	public String getDptName() {
		return this.dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getDptType() {
		return this.dptType;
	}

	public void setDptType(String dptType) {
		this.dptType = dptType;
	}

}
