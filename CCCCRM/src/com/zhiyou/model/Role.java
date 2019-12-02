package com.zhiyou.model;

import java.util.Date;

public class Role {

	private Integer role_id;
	private String role_name;
	private Integer role_permission;
	private Integer status;
	private String remark;
	private Date create_time;
	private Integer creater;
	private Date update_time;
	private Integer updater;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Integer getRole_permission() {
		return role_permission;
	}

	public void setRole_permission(Integer role_permission) {
		this.role_permission = role_permission;
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
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_permission=" + role_permission
				+ ", status=" + status + ", remark=" + remark + ", create_time=" + create_time + ", creater=" + creater
				+ ", update_time=" + update_time + ", updater=" + updater + "]";
	}

	public Role(Integer role_id, String role_name, String remark) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.remark = remark;
	}

	public Role(String role_name, String remark) {
		super();
		this.role_name = role_name;
		this.remark = remark;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
