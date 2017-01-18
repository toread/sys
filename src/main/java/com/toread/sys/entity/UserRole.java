package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user_role")
public class UserRole {
    /**
     * 主键
     */
    @Id
    @IDSequence
    private Long id;

    /**
     * 用户uuid
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色uuid
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 创建时间
     */
    @Column(name = "c_time")
    private Date cTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户uuid
     *
     * @return user_id - 用户uuid
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户uuid
     *
     * @param userId 用户uuid
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
     * 获取创建时间
     *
     * @return c_time - 创建时间
     */
    public Date getcTime() {
        return cTime;
    }

    /**
     * 设置创建时间
     *
     * @param cTime 创建时间
     */
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}