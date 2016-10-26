package com.toread.sys.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.toread.sys.mybatis.annotation.CTime;

/**
 *
 * 
 *
 */
@TableName("sys_user_department")
public class UserDepartment implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 用户部门id */
	@TableId
	private Long id;

	/** 用户id */
	@TableField(value = "user_id")
	private Long userId;

	/** 部门id */
	@TableField(value = "dpt_id")
	private Long dptId;

	/** 创建时间 */
	@TableField(value = "c_time")
	@CTime
	private Date cTime;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDptId() {
		return this.dptId;
	}

	public void setDptId(Long dptId) {
		this.dptId = dptId;
	}

	public Date getCTime() {
		return this.cTime;
	}

	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

}
