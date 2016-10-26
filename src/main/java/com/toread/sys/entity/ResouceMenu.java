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
@TableName("sys_resouce_menu")
public class ResouceMenu implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId
	private Long id;

	/** 菜单ID */
	@TableField(value = "menu_id")
	private Long menuId;

	/** 资源id */
	@TableField(value = "res_id")
	private Long resId;

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

	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getResId() {
		return this.resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Date getCTime() {
		return this.cTime;
	}

	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}

}
