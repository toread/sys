package com.toread.sys.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.mybatis.annotation.CTime;

/**
 *
 * 
 *
 */
@TableName("sys_menu")
public class Menu implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 菜单主键 */
	@TableId(value = "menu_id")
	@TreeId
	private Long menuId;

	/** 菜单名字 */
	@TableField(value = "menu_name")
	private String menuName;

	/** 图标 */
	@TableField(value = "menu_icon")
	private String menuIcon;

	/** 菜单主键 */
	@TableField(value = "menu_pid")
	@TreePid
	private Long menuPid;

	/** 状态 */
	@TableField(value = "menu_state")
	private String menuState;

	/** 排序 */
	@TableField(value = "menu_order")
	private Integer menuOrder;

	/** 创建时间 */
	@TableField(value = "menu_c_time")
	@CTime
	private Date menuCTime;

	/** 更新时间 */
	@TableField(value = "menu_u_time")
	private Date menuUTime;


	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Long getMenuPid() {
		return this.menuPid;
	}

	public void setMenuPid(Long menuPid) {
		this.menuPid = menuPid;
	}

	public String getMenuState() {
		return this.menuState;
	}

	public void setMenuState(String menuState) {
		this.menuState = menuState;
	}

	public Integer getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public Date getMenuCTime() {
		return this.menuCTime;
	}

	public void setMenuCTime(Date menuCTime) {
		this.menuCTime = menuCTime;
	}

	public Date getMenuUTime() {
		return this.menuUTime;
	}

	public void setMenuUTime(Date menuUTime) {
		this.menuUTime = menuUTime;
	}

}
