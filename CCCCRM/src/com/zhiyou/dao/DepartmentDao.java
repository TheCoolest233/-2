package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Department;

public interface DepartmentDao {

	// 查询所有部门
	List<Department> selectAll(int page, int number);

	// 增加
	void addDepartment(Department department);

	// 根据id进行删除
	void deleteById(Integer department_id);

	// 修改
	void updateDepartment(Department department);

	// 根据id查询部门
	Department selectById(Integer department_id);

	// 查询总条数
	int selectCount();

}
