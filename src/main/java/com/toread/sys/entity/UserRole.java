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
@TableName("sys_user_role")
public class UserRole implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId
	private Long id;

	/** 用户uuid */
	@TableField(value = "user_id")
	private Long userId;

	/** 角色uuid */
	@TableField(value = "role_id")
	private Long roleId;

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

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getCTime() {
		return this.cTime;
	}

	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

}
