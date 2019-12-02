package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Notice;

public interface NoticeService {

	// 查询所有公告
	List<Notice> selectAll(int page, int number);

	// 增加
	void addNotice(Notice notice);

	// 根据id进行删除
	void deleteById(Integer notice_id);

	// 修改
	void updateNotice(Notice notice);

	// 根据id查询公告
	Notice selectById(Integer notice_id);

	// 查询总条数
	int selectCount();
}