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
@TableName("sys_user")
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 用户主键 */
	@TableId(value = "user_id")
	private Long userId;

	/** 用户登陆代码 */
	@TableField(value = "user_code")
	private String userCode;

	/** 用户密码 */
	@TableField(value = "user_pwd")
	private String userPwd;

	/** 用户状态 */
	@TableField(value = "user_state")
	private String userState;

	/** 创建时间 */
	@TableField(value = "user_c_time")
	@CTime
	private Date userCTime;

	/** 修改时间 */
	@TableField(value = "user_u_time")
	private Date userUTime;


	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Date getUserCTime() {
		return this.userCTime;
	}

	public void setUserCTime(Date userCTime) {
		this.userCTime = userCTime;
	}

	public Date getUserUTime() {
		return this.userUTime;
	}

	public void setUserUTime(Date userUTime) {
		this.userUTime = userUTime;
	}

}
