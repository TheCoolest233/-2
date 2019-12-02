package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.NoticeDao;
import com.zhiyou.dao.impl.NoticeDaoImpl;
import com.zhiyou.model.Notice;
import com.zhiyou.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	private static NoticeDao dao = new NoticeDaoImpl();

	public List<Notice> selectAll(int page, int number) {
		// TODO Auto-generated method stub
		return dao.selectAll(page, number);
	}

	public void addNotice(Notice notice) {
		dao.addNotice(notice);

	}

	public void deleteById(Integer notice_id) {
		dao.deleteById(notice_id);

	}

	public void updateNotice(Notice notice) {
		dao.updateNotice(notice);

	}

	public Notice selectById(Integer notice_id) {
		// TODO Auto-generated method stub
		return dao.selectById(notice_id);
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}