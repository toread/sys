package com.toread.sys.entity;

import com.toread.sys.common.mybatis.annotation.IDSequence;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.common.tree.annotation.TreeText;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "sys_department")
public class Department {
	public Department(Long dptId) {
		this.dptId = dptId;
	}

	public Department() {
	}

	/**
     * 部门主键
     */
    @Id
    @Column(name = "dpt_id")
	@TreeId
    @IDSequence
    private Long dptId;

    /**
     * 父部门id
     */
    @Column(name = "dpt_pid")
	@TreePid
    @NotNull(message = "{department.dpt_pid.notnull.message}")
    private Long dptPid;

    /**
     * 部门名称
     */
    @Column(name = "dpt_name")
	@TreeText
    @Size(min = 1,max = 32,message = "{department.dptname.size.message}")
    private String dptName;

    /**
     * 部门类型
     */
    @Column(name = "dpt_type")
    @NotBlank(message = "{department.dptType.notblank.message}")
    private String dptType;

    /**
     * 部门状态
     */
    @Column(name = "dpt_state")
    @NotNull(message = "{department.dptState.notnull.message}")
    private Integer dptState;

    public Integer getDptState() {
        return dptState;
    }

    public void setDptState(Integer dptState) {
        this.dptState = dptState;
    }

    /**
     * 获取部门主键
     *
     * @return dpt_id - 部门主键
     */
    public Long getDptId() {
        return dptId;
    }

    /**
     * 设置部门主键
     *
     * @param dptId 部门主键
     */
    public void setDptId(Long dptId) {
        this.dptId = dptId;
    }

    /**
     * 获取父部门id
     *
     * @return dpt_pid - 父部门id
     */
    public Long getDptPid() {
        return dptPid;
    }

    /**
     * 设置父部门id
     *
     * @param dptPid 父部门id
     */
    public void setDptPid(Long dptPid) {
        this.dptPid = dptPid;
    }

    /**
     * 获取部门名称
     *
     * @return dpt_name - 部门名称
     */
    public String getDptName() {
        return dptName;
    }

    /**
     * 设置部门名称
     *
     * @param dptName 部门名称
     */
    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    /**
     * 获取部门类型
     *
     * @return dpt_type - 部门类型
     */
    public String getDptType() {
        return dptType;
    }

    /**
     * 设置部门类型
     *
     * @param dptType 部门类型
     */
    public void setDptType(String dptType) {
        this.dptType = dptType;
    }
}