package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.User;

public interface UserService {
	// 根据账号查询用户
	User selectByUserName(HttpServletRequest req, String username, String password);

	// 查询所有用户
	List<User> selectAll(int page, int number);

	// 增加
	void add(User user);

	// 根据id进行删除
	void deleteById(Integer user_id);

	// 修改
	void update(User user);

	// 根据id查询用户
	User selectById(Integer user_id);

	// 查询总条数
	int selectCount();

	// 模糊查询
	List<User> selectLike(String name, String value);
}
