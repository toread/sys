package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_resource")
public class RoleResource {
    /**
     * 主键
     */
    @Id
    @IDSequence
    private Long id;

    /**
     * 角色uuid
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 资源uuid
     */
    @Column(name = "res_id")
    private Long resId;

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
     * 获取资源uuid
     *
     * @return res_id - 资源uuid
     */
    public Long getResId() {
        return resId;
    }

    /**
     * 设置资源uuid
     *
     * @param resId 资源uuid
     */
    public void setResId(Long resId) {
        this.resId = resId;
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