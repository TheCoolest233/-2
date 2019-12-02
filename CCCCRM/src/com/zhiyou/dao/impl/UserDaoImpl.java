package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	public User selectByUserName(String username) {
		List<User> list = JDBCUtil.dbDQL("select * from user where username=?", User.class, username);
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<User> selectAll(int page, int number) {
		String sql = "select * from user limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, User.class);
	}

	public void add(User user) {
		String sql = "insert into user(user_id,username,password,department_id,role_id,is_male,mobile,address,age,tel, id_num,email, hobby, education,card_num, nation,marry,remark) values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, user.getUsername(), user.getPassword(), user.getDepartment_id(), user.getRole_id(),
				user.isIs_male(), user.getMobile(), user.getAddress(), user.getAge(), user.getTel(), user.getId_num(),
				user.getEmail(), user.getHobby(), user.getEducation(), user.getCard_num(), user.getNation(),
				user.getMarry(), user.getRemark());
	}

	public void deleteById(Integer user_id) {
		String sql = "delete from user where user_id=?";
		JDBCUtil.dbDML(sql, user_id);
	}

	public void update(User user) {
		String sql = "update user set username=?,password=?,department_id=?,role_id=?,is_male=?, mobile=?,address=?,age=?, tel=?, id_num=?, email=?, hobby=?, education=?,card_num=?, nation=?,marry=?,remark=? where user_id=? ";
		JDBCUtil.dbDML(sql, user.getUsername(), user.getPassword(), user.getDepartment_id(), user.getRole_id(),
				user.isIs_male(), user.getMobile(), user.getAddress(), user.getAge(), user.getTel(), user.getId_num(),
				user.getEmail(), user.getHobby(), user.getEducation(), user.getCard_num(), user.getNation(),
				user.getMarry(), user.getRemark(), user.getUser_id());
	}

	public User selectById(Integer user_id) {
		String sql = "select * from user where user_id=?";
		return JDBCUtil.dbDQL(sql, User.class, user_id).get(0);
	}

	public int selectCount() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}

	public List<User> selectLike(String name, String value) {
		// 结论
		// 1、==用于比较两个引用是否指向同一个对象 equals用于比较两个对象是否相等
		// 2、由于字符串特殊 在字符串常量池中的字符串可以使用==也可以使用equals 推荐不管哪种方式 只要是比较字符串就用equals
		if (name == "username") {
			String sql = "select * from user where username like '%" + value + "%'";
			return JDBCUtil.dbDQL(sql, User.class);
		} else if (name == "user_id") {
			String sql = "select * from user where user_id like '%" + value + "%'";
			return JDBCUtil.dbDQL(sql, User.class);
		}
		return null;
	}

}