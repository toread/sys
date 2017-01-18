package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_resource")
public class Resource {
    /**
     * 资源uuid
     */
    @Id
    @Column(name = "res_id")
    @IDSequence
    private Long resId;

    /**
     * 资源类型
     */
    @Column(name = "res_type")
    private String resType;

    /**
     * 资源名称
     */
    @Column(name = "res_name")
    private String resName;

    /**
     * 资源值
     */
    @Column(name = "res_val")
    private String resVal;

    /**
     * 资源状态
     */
    @Column(name = "res_state")
    private Integer resState;

    /**
     * 创建时间
     */
    @Column(name = "res_c_time")
    private Date resCTime;

    /**
     * 更新时间
     */
    @Column(name = "res_u_time")
    private Date resUTime;

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
     * 获取资源类型
     *
     * @return res_type - 资源类型
     */
    public String getResType() {
        return resType;
    }

    /**
     * 设置资源类型
     *
     * @param resType 资源类型
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * 获取资源名称
     *
     * @return res_name - 资源名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置资源名称
     *
     * @param resName 资源名称
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 获取资源值
     *
     * @return res_val - 资源值
     */
    public String getResVal() {
        return resVal;
    }

    /**
     * 设置资源值
     *
     * @param resVal 资源值
     */
    public void setResVal(String resVal) {
        this.resVal = resVal;
    }

    /**
     * 获取资源状态
     *
     * @return res_state - 资源状态
     */
    public Integer getResState() {
        return resState;
    }

    /**
     * 设置资源状态
     *
     * @param resState 资源状态
     */
    public void setResState(Integer resState) {
        this.resState = resState;
    }

    /**
     * 获取创建时间
     *
     * @return res_c_time - 创建时间
     */
    public Date getResCTime() {
        return resCTime;
    }

    /**
     * 设置创建时间
     *
     * @param resCTime 创建时间
     */
    public void setResCTime(Date resCTime) {
        this.resCTime = resCTime;
    }

    /**
     * 获取更新时间
     *
     * @return res_u_time - 更新时间
     */
    public Date getResUTime() {
        return resUTime;
    }

    /**
     * 设置更新时间
     *
     * @param resUTime 更新时间
     */
    public void setResUTime(Date resUTime) {
        this.resUTime = resUTime;
    }
}