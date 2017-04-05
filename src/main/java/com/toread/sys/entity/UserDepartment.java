package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.CTime;
import com.toread.sys.common.mybatis.annotation.IDSequence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user_department")
public class UserDepartment {
    /**
     * 用户部门id
     */
    @Id
    @IDSequence
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 部门id
     */
    @Column(name = "dpt_id")
    private Long dptId;

    /**
     * 创建时间
     */
    @Column(name = "c_time")
    @CTime
    private Date cTime;

    /**
     * 获取用户部门id
     *
     * @return id - 用户部门id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户部门id
     *
     * @param id 用户部门id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取部门id
     *
     * @return dpt_id - 部门id
     */
    public Long getDptId() {
        return dptId;
    }

    /**
     * 设置部门id
     *
     * @param dptId 部门id
     */
    public void setDptId(Long dptId) {
        this.dptId = dptId;
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