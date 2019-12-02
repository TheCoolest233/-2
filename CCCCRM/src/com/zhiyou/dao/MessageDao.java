package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Message;

public interface MessageDao {

	// 查询所有邮件
	List<Message> selectAll(int page, int number, Integer receiver);

	// 发件箱
	List<Message> selectFAll(int page, int number, Integer sender);

	// 草稿箱
	List<Message> selectDAll(int page, int number, Integer user_id);

	List<Message> selectLAll(int page, int number, Integer user_id);

	// 增加
	void addMessage(Message message);

	// 根据id进行彻底删除
	void deleteById(Integer message_id);

	// 保存到草稿
	void draftMessage(Message message);

	// 删除到垃圾箱
	void dustbinMessage(Message message);

	void dustbinFDMessage(Message message);

	// 根据id查询邮件
	Message selectById(Integer message_id);

	// 查询收件箱总条数
	int selectCountS(Integer user_id);

	// 查询发件箱总条数
	int selectCountF(Integer user_id);

	// 查询草稿箱总条数
	int selectCountC(Integer user_id);

	// 查询垃圾箱总条数
	int selectCountL(Integer user_id);

	// 编辑邮件
	void updateMessage(Message message1);
}