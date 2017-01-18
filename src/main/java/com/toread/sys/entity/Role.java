package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_role")
public class Role {
    /**
     * 角色uuid
     */
    @Id
    @Column(name = "role_id")
    @IDSequence
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色状态
     */
    @Column(name = "role_state")
    private Integer roleState;

    /**
     * 创建时间
     */
    @Column(name = "role_c_time")
    private Date roleCTime;

    /**
     * 修改时间
     */
    @Column(name = "role_u_time")
    private Date roleUTime;

    /**
     * 获取角色uuid
     *
     * @return role_id - 角色uuid
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色uuid
     *
     * @param roleId 角色uuid
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色状态
     *
     * @return role_state - 角色状态
     */
    public Integer getRoleState() {
        return roleState;
    }

    /**
     * 设置角色状态
     *
     * @param roleState 角色状态
     */
    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }

    /**
     * 获取创建时间
     *
     * @return role_c_time - 创建时间
     */
    public Date getRoleCTime() {
        return roleCTime;
    }

    /**
     * 设置创建时间
     *
     * @param roleCTime 创建时间
     */
    public void setRoleCTime(Date roleCTime) {
        this.roleCTime = roleCTime;
    }

    /**
     * 获取修改时间
     *
     * @return role_u_time - 修改时间
     */
    public Date getRoleUTime() {
        return roleUTime;
    }

    /**
     * 设置修改时间
     *
     * @param roleUTime 修改时间
     */
    public void setRoleUTime(Date roleUTime) {
        this.roleUTime = roleUTime;
    }
}