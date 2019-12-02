package com.zhiyou.service.impl;

import java.util.List;

import com.zhiyou.dao.DepartmentDao;
import com.zhiyou.dao.impl.DepartmentDaoImpl;
import com.zhiyou.model.Department;
import com.zhiyou.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private static DepartmentDao dao = new DepartmentDaoImpl();

	public List<Department> selectAll(int page, int number) {
		// TODO Auto-generated method stub
		return dao.selectAll(page, number);
	}

	public void addDepartment(Department department) {
		dao.addDepartment(department);

	}

	public void deleteById(Integer department_id) {
		dao.deleteById(department_id);

	}

	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		dao.updateDepartment(department);
	}

	public Department selectById(Integer department_id) {
		// TODO Auto-generated method stub
		return dao.selectById(department_id);
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

}
