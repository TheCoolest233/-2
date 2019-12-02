package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.dao.UserDao;
import com.zhiyou.dao.impl.UserDaoImpl;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserDao dao = new UserDaoImpl();

	public User selectByUserName(HttpServletRequest req, String username, String password) {
		User user = dao.selectByUserName(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
			} else {
				req.setAttribute("msg", "密码错误，请重新输入");
				return null;
			}
		} else {
			req.setAttribute("msg", "用户不存在");
		}
		return user;
	}

	public List<User> selectAll(int page, int number) {
		return dao.selectAll(page, number);
	}

	public void add(User user) {
		dao.add(user);

	}

	public void deleteById(Integer user_id) {
		dao.deleteById(user_id);

	}

	public void update(User user) {
		dao.update(user);
	}

	public User selectById(Integer user_id) {

		return dao.selectById(user_id);
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	public List<User> selectLike(String name, String value) {
		// TODO Auto-generated method stub
		return dao.selectLike(name, value);
	}

}
