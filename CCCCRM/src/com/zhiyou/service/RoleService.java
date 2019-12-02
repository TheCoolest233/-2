package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.model.Role;

public interface RoleService {

	List<Role> allRole(int page, int number);

	int roleNumber();

	boolean addRole(HttpServletRequest request);

	void deleteRole(HttpServletRequest request);

	Role selectRoleById(HttpServletRequest request);

	/*
	 * 更新用户
	 */
	boolean updateRole(HttpServletRequest request);
}