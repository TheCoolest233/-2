package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.model.Role;
import com.zhiyou.util.JDBCUtil;

public class RoleDaoImpl implements RoleDao {

	public Integer selectIdByName(String roleName) {
		String sql = "select * from role where role_name=?";
		return JDBCUtil.dbDQL(sql, Role.class, roleName).get(0).getRole_id();
	}

	public int roleNumber() {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from role";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, ps, rs);
		}
		return 0;
	}

	public List<Role> allRole(int page, int number) {
		return JDBCUtil.dbDQL("select * from role limit " + page + "," + number + ";", Role.class);
	}

	public boolean addRole(Role role) {
		String sql = "insert into role(role_id,role_name,remark) value(null,?,?)";
		return JDBCUtil.dbDML(sql, role.getRole_name(), role.getRemark());
	}

	public void deleteRole(Integer roleId) {
		String sql = "delete from role where role_id=?";
		JDBCUtil.dbDML(sql, roleId);

	}

	public Role selectRoleById(Integer id) {
		String sql = "select * from role where role_id=?";
		return JDBCUtil.dbDQL(sql, Role.class, id).get(0);
	}

	public boolean updateRole(Role role) {
		String sql = "update role set role_name=?,remark=? where role_id=?";
		return JDBCUtil.dbDML(sql, role.getRole_name(), role.getRemark(), role.getRole_id());
	}

}
