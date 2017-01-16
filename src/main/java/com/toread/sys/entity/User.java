package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.CTime;
import com.toread.sys.common.mybatis.annotation.IDSequence;
import com.toread.sys.common.mybatis.annotation.UTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class User {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "user_id")
    @IDSequence
    private Long userId;

    /**
     * 用户登陆代码
     */
    @Column(name = "user_code")
    private String userCode;

    /**
     * 用户密码
     */
    @Column(name = "user_pwd")
    private String userPwd;

    /**
     * 用户状态
     */
    @Column(name = "user_state")
    private Integer userState;

    /**
     * 创建时间
     */
    @Column(name = "user_c_time")
    @CTime
    private Date userCTime;

    /**
     * 修改时间
     */
    @Column(name = "user_u_time")
    @UTime
    private Date userUTime;

    /**
     * 获取用户主键
     *
     * @return user_id - 用户主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户主键
     *
     * @param userId 用户主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户登陆代码
     *
     * @return user_code - 用户登陆代码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置用户登陆代码
     *
     * @param userCode 用户登陆代码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 获取用户密码
     *
     * @return user_pwd - 用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置用户密码
     *
     * @param userPwd 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取用户状态
     *
     * @return user_state - 用户状态
     */
    public Integer getUserState() {
        return userState;
    }

    /**
     * 设置用户状态
     *
     * @param userState 用户状态
     */
    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    /**
     * 获取创建时间
     *
     * @return user_c_time - 创建时间
     */
    public Date getUserCTime() {
        return userCTime;
    }

    /**
     * 设置创建时间
     *
     * @param userCTime 创建时间
     */
    public void setUserCTime(Date userCTime) {
        this.userCTime = userCTime;
    }

    /**
     * 获取修改时间
     *
     * @return user_u_time - 修改时间
     */
    public Date getUserUTime() {
        return userUTime;
    }

    /**
     * 设置修改时间
     *
     * @param userUTime 修改时间
     */
    public void setUserUTime(Date userUTime) {
        this.userUTime = userUTime;
    }
}