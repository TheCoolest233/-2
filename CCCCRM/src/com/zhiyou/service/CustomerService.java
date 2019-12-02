package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Customer;

public interface CustomerService {
	// 查询所有用户
	List<Customer> selectAll(int page, int number);

	// 增加
	void addCustomer(Customer customer);

	// 根据id进行删除
	void deleteById(Integer customer_id);

	// 修改
	void updateCustomer(Customer customer);

	// 根据id查询用户
	Customer selectById(Integer customer_id);

	// 查询总条数
	int selectCount();
}
