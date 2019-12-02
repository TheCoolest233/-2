package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.CustomerDao;
import com.zhiyou.model.Customer;
import com.zhiyou.util.JDBCUtil;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> selectAll(int page, int number) {
		String sql = "select * from customer limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, Customer.class);
	}

	public void addCustomer(Customer customer) {
		String sql = "insert into customer(customer_id,user_id,customer_category_id, customer_name,customer_is_male,customer_mobile,customer_qq,customer_address, customer_email,customer_remark,customer_position,customer_blog,customer_tel,customer_birth,customer_company) values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, customer.getUser_id(), customer.getCustomer_category_id(), customer.getCustomer_name(),
				customer.isCustomer_is_male(), customer.getCustomer_mobile(), customer.getCustomer_qq(),
				customer.getCustomer_address(), customer.getCustomer_email(), customer.getCustomer_remark(),
				customer.getCustomer_position(), customer.getCustomer_blog(), customer.getCustomer_tel(),
				customer.getCustomer_birth(), customer.getCustomer_company());

	}

	public void deleteById(Integer customer_id) {
		String sql = "delete from customer where customer_id=?";
		JDBCUtil.dbDML(sql, customer_id);

	}

	public void updateCustomer(Customer customer) {
		String sql = "update customer set user_id=?,customer_category_id=?, customer_name=?,customer_is_male=?,customer_mobile=?,customer_qq=?,customer_address=?, customer_email=?,customer_remark=?,customer_position=?,customer_blog=?,customer_tel=?,customer_birth=?,customer_company=? where customer_id=? ";
		JDBCUtil.dbDML(sql, customer.getUser_id(), customer.getCustomer_category_id(), customer.getCustomer_name(),
				customer.isCustomer_is_male(), customer.getCustomer_mobile(), customer.getCustomer_qq(),
				customer.getCustomer_address(), customer.getCustomer_email(), customer.getCustomer_remark(),
				customer.getCustomer_position(), customer.getCustomer_blog(), customer.getCustomer_tel(),
				customer.getCustomer_birth(), customer.getCustomer_company(), customer.getCustomer_id());

	}

	public Customer selectById(Integer customer_id) {
		String sql = "select * from customer where customer_id=? ";
		return JDBCUtil.dbDQL(sql, Customer.class, customer_id).get(0);
	}

	public int selectCount() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from customer";
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