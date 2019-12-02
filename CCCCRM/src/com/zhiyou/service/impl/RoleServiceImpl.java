package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.dao.RoleDao;
import com.zhiyou.dao.impl.RoleDaoImpl;
import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private static RoleDao roledao = new RoleDaoImpl();

	public List<Role> allRole(int page, int number) {
		// TODO Auto-generated method stub
		return roledao.allRole(page, number);
	}

	public int roleNumber() {
		// TODO Auto-generated method stub
		return roledao.roleNumber();
	}

	public boolean addRole(HttpServletRequest request) {

		Role role = new Role(request.getParameter("role_name"), request.getParameter("remark"));
		return roledao.addRole(role);
	}

	public void deleteRole(HttpServletRequest request) {
		String role_id = request.getParameter("role_id");
		roledao.deleteRole(Integer.valueOf(role_id));
	}

	public Role selectRoleById(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer roleid = Integer.valueOf(request.getParameter("role_id"));
		return roledao.selectRoleById(roleid);
	}

	public boolean updateRole(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String role_name = request.getParameter("role_name");
		String remark = request.getParameter("remark");
		Role role = new Role(Integer.valueOf(request.getParameter("role_id")), request.getParameter("role_name"),
				request.getParameter("remark"));
		return roledao.updateRole(role);

	}

}