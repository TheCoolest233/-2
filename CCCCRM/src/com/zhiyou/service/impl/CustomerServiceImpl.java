package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.CustomerDao;
import com.zhiyou.dao.impl.CustomerDaoImpl;
import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerDao customDao = new CustomerDaoImpl();

	public List<Customer> selectAll(int page, int number) {
		// TODO Auto-generated method stub
		return customDao.selectAll(page, number);
	}

	public void addCustomer(Customer customer) {
		customDao.addCustomer(customer);

	}

	public void deleteById(Integer customer_id) {
		customDao.deleteById(customer_id);

	}

	public void updateCustomer(Customer customer) {
		customDao.updateCustomer(customer);

	}

	public Customer selectById(Integer customer_id) {
		// TODO Auto-generated method stub
		return customDao.selectById(customer_id);
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		return customDao.selectCount();
	}

}
