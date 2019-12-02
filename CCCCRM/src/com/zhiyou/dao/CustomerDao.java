package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Customer;

public interface CustomerDao {

	// 查询所有客户
	List<Customer> selectAll(int page, int number);

	// 增加
	void addCustomer(Customer customer);

	// 根据id进行删除
	void deleteById(Integer customer_id);

	// 修改
	void updateCustomer(Customer customer);

	// 根据id查询客户
	Customer selectById(Integer customer_id);

	// 查询总条数
	int selectCount();
}
