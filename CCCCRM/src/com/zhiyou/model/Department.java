package com.zhiyou.model;

import java.util.Date;

public class Department {

	private Integer department_id;
	private String department_name;
	private String department_desc;
	private Integer status;
	private String remark;
	private Date create_time;
	private Integer creater;
	private Date update_time;
	private Integer updater;

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_desc() {
		return department_desc;
	}

	public void setDepartment_desc(String department_desc) {
		this.department_desc = department_desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getUpdater() {
		return updater;
	}

	public void setUpdater(Integer updater) {
		this.updater = updater;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_desc=" + department_desc + ", status=" + status + ", remark=" + remark
				+ ", create_time=" + create_time + ", creater=" + creater + ", update_time=" + update_time
				+ ", updater=" + updater + "]";
	}

	public Department(Integer department_id, String department_name, String department_desc) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_desc = department_desc;
	}

	public Department() {

	}

	public Department(String department_name, String department_desc) {
		super();
		this.department_name = department_name;
		this.department_desc = department_desc;
	}

}
