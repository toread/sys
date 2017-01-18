package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_menu")
public class Menu {
    /**
     * 菜单主键
     */
    @Id
    @Column(name = "menu_id")
    @IDSequence
    @TreeId
    private Long menuId;

    /**
     * 菜单名字
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 菜单主键
     */
    @Column(name = "menu_pid")
    @TreePid
    private Long menuPid;

    /**
     * 状态
     */
    @Column(name = "menu_state")
    private String menuState;

    /**
     * 排序
     */
    @Column(name = "menu_order")
    private Integer menuOrder;

    /**
     * 创建时间
     */
    @Column(name = "menu_c_time")
    private Date menuCTime;

    /**
     * 更新时间
     */
    @Column(name = "menu_u_time")
    private Date menuUTime;

    /**
     * 获取菜单主键
     *
     * @return menu_id - 菜单主键
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单主键
     *
     * @param menuId 菜单主键
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取菜单名字
     *
     * @return menu_name - 菜单名字
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名字
     *
     * @param menuName 菜单名字
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取图标
     *
     * @return menu_icon - 图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置图标
     *
     * @param menuIcon 图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取菜单主键
     *
     * @return menu_pid - 菜单主键
     */
    public Long getMenuPid() {
        return menuPid;
    }

    /**
     * 设置菜单主键
     *
     * @param menuPid 菜单主键
     */
    public void setMenuPid(Long menuPid) {
        this.menuPid = menuPid;
    }

    /**
     * 获取状态
     *
     * @return menu_state - 状态
     */
    public String getMenuState() {
        return menuState;
    }

    /**
     * 设置状态
     *
     * @param menuState 状态
     */
    public void setMenuState(String menuState) {
        this.menuState = menuState;
    }

    /**
     * 获取排序
     *
     * @return menu_order - 排序
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * 设置排序
     *
     * @param menuOrder 排序
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 获取创建时间
     *
     * @return menu_c_time - 创建时间
     */
    public Date getMenuCTime() {
        return menuCTime;
    }

    /**
     * 设置创建时间
     *
     * @param menuCTime 创建时间
     */
    public void setMenuCTime(Date menuCTime) {
        this.menuCTime = menuCTime;
    }

    /**
     * 获取更新时间
     *
     * @return menu_u_time - 更新时间
     */
    public Date getMenuUTime() {
        return menuUTime;
    }

    /**
     * 设置更新时间
     *
     * @param menuUTime 更新时间
     */
    public void setMenuUTime(Date menuUTime) {
        this.menuUTime = menuUTime;
    }
}