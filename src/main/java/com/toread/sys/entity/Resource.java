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
@TableName("sys_resource")
public class Resource implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 资源uuid */
	@TableId(value = "res_id")
	private Long resId;

	/** 资源类型 */
	@TableField(value = "res_type")
	private String resType;

	/** 资源名称 */
	@TableField(value = "res_name")
	private String resName;

	/** 资源值 */
	@TableField(value = "res_val")
	private String resVal;

	/** 资源状态 */
	@TableField(value = "res_state")
	private String resState;

	/** 创建时间 */
	@TableField(value = "res_c_time")
	@CTime
	private Date resCTime;

	/** 更新时间 */
	@TableField(value = "res_u_time")
	private Date resUTime;


	public Long getResId() {
		return this.resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public String getResType() {
		return this.resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResVal() {
		return this.resVal;
	}

	public void setResVal(String resVal) {
		this.resVal = resVal;
	}

	public String getResState() {
		return this.resState;
	}

	public void setResState(String resState) {
		this.resState = resState;
	}

	public Date getResCTime() {
		return this.resCTime;
	}

	public void setResCTime(Date resCTime) {
		this.resCTime = resCTime;
	}

	public Date getResUTime() {
		return this.resUTime;
	}

	public void setResUTime(Date resUTime) {
		this.resUTime = resUTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Resource resource = (Resource) o;

		return resId != null ? resId.equals(resource.resId) : resource.resId == null;

	}

	@Override
	public int hashCode() {
		return resId != null ? resId.hashCode() : 0;
	}
}
