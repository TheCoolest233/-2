package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.DepartmentDao;
import com.zhiyou.model.Department;
import com.zhiyou.util.JDBCUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	public List<Department> selectAll(int page, int number) {
		String sql = "select * from department limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, Department.class);
	}

	public void addDepartment(Department department) {
		String sql = "insert into department(department_id,department_name,department_desc) values(null,?,?)";
		JDBCUtil.dbDML(sql, department.getDepartment_name(), department.getDepartment_desc());

	}

	public void deleteById(Integer department_id) {
		String sql = "delete from department where department_id=?";
		JDBCUtil.dbDML(sql, department_id);

	}

	public void updateDepartment(Department department) {
		String sql = "update department set department_name=?,department_desc=? where department_id=? ";
		JDBCUtil.dbDML(sql, department.getDepartment_name(), department.getDepartment_desc(),
				department.getDepartment_id());

	}

	public Department selectById(Integer department_id) {
		String sql = "select * from department where department_id=?";
		return JDBCUtil.dbDQL(sql, Department.class, department_id).get(0);
	}

	public int selectCount() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from department";
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

}
