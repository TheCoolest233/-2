package com.zhiyou.model;

import java.util.Date;

public class Notice {

	private Integer notice_id;
	private Integer receive_id;
	private String subject;
	private String text;
	private Date pub_time;
	private Date expire_time;
	private Integer status;
	private String remark;
	private Date create_time;
	private Integer creater;
	private Date update_time;
	private Integer updater;

	public Integer getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}

	public Integer getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(Integer receive_id) {
		this.receive_id = receive_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPub_time() {
		return pub_time;
	}

	public void setPub_time(Date pub_time) {
		this.pub_time = pub_time;
	}

	public Date getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
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
		return "Notice [notice_id=" + notice_id + ", receive_id=" + receive_id + ", subject=" + subject + ", text="
				+ text + ", pub_time=" + pub_time + ", expire_time=" + expire_time + ", status=" + status + ", remark="
				+ remark + ", create_time=" + create_time + ", creater=" + creater + ", update_time=" + update_time
				+ ", updater=" + updater + "]";
	}

	public Notice(Integer notice_id, Integer receive_id, String subject, String text, Date pub_time, Date expire_time,
			Integer creater) {
		super();
		this.notice_id = notice_id;
		this.receive_id = receive_id;
		this.subject = subject;
		this.text = text;
		this.pub_time = pub_time;
		this.expire_time = expire_time;
		this.creater = creater;
	}

	public Notice(Integer receive_id, String subject, String text, Date pub_time, Date expire_time, Integer creater) {
		super();
		this.receive_id = receive_id;
		this.subject = subject;
		this.text = text;
		this.pub_time = pub_time;
		this.expire_time = expire_time;
		this.creater = creater;
	}

	public Notice() {

	}

}