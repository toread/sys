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
@TableName("sys_role")
public class Role implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 角色uuid */
	@TableId(value = "role_id")
	private Long roleId;

	/** 角色名称 */
	@TableField(value = "role_name")
	private String roleName;

	/** 角色状态 */
	@TableField(value = "role_state")
	private String roleState;

	/** 创建时间 */
	@TableField(value = "role_c_time")
	@CTime
	private Date roleCTime;

	/** 修改时间 */
	@TableField(value = "role_u_time")
	private Date roleUTime;


	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleState() {
		return this.roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}

	public Date getRoleCTime() {
		return this.roleCTime;
	}

	public void setRoleCTime(Date roleCTime) {
		this.roleCTime = roleCTime;
	}

	public Date getRoleUTime() {
		return this.roleUTime;
	}

	public void setRoleUTime(Date roleUTime) {
		this.roleUTime = roleUTime;
	}

}
