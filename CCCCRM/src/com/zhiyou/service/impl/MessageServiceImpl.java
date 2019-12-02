package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.MessageDao;
import com.zhiyou.dao.impl.MessageDaoImpl;
import com.zhiyou.model.Message;
import com.zhiyou.service.MessageService;

public class MessageServiceImpl implements MessageService {
	private static MessageDao messagedao = new MessageDaoImpl();

	public List<Message> selectAll(int page, int number, Integer receiver) {
		// TODO Auto-generated method stub
		return messagedao.selectAll(page, number, receiver);
	}

	public void addMessage(Message message) {
		messagedao.addMessage(message);

	}

	public void deleteById(Integer message_id) {
		messagedao.deleteById(message_id);

	}

	public void draftMessage(Message message) {
		messagedao.draftMessage(message);

	}

	public Message selectById(Integer message_id) {
		// TODO Auto-generated method stub
		return messagedao.selectById(message_id);
	}

	public int selectCountS(Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectCountS(user_id);
	}

	public List<Message> selectDAll(int page, int number, Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectDAll(page, number, user_id);
	}

	public List<Message> selectFAll(int page, int number, Integer sender) {
		// TODO Auto-generated method stub
		return messagedao.selectFAll(page, number, sender);
	}

	public void dustbinMessage(Message message) {
		messagedao.dustbinMessage(message);

	}

	public List<Message> selectLAll(int page, int number, Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectLAll(page, number, user_id);
	}

	public void dustbinFDMessage(Message message) {
		messagedao.dustbinFDMessage(message);

	}

	public int selectCountF(Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectCountF(user_id);
	}

	public int selectCountC(Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectCountC(user_id);
	}

	public int selectCountL(Integer user_id) {
		// TODO Auto-generated method stub
		return messagedao.selectCountL(user_id);
	}

	public void updateMessage(Message message1) {
		messagedao.updateMessage(message1);

	}

}