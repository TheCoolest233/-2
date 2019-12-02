package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Role;

public interface RoleDao {
	/*
	 * 根据角色名称查出角色ID
	 */
	Integer selectIdByName(String roleName);

	List<Role> allRole(int page, int number);

	int roleNumber();

	boolean addRole(Role role);

	void deleteRole(Integer roleId);

	boolean updateRole(Role role);

	Role selectRoleById(Integer id);
}
