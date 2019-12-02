package com.zhiyou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;
import com.zhiyou.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class RoleShowServlet1
 */
@WebServlet("/RoleShowServlet1")
public class RoleShowServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static RoleService roleservice = new RoleServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);
		if (string == null) {
			System.out.println("service参数没有   usershowservlet");
			return;
		}
		// 参数有

		if (string.equals("roleShow")) {
			roleShow(req, resp);
		}

		if (string.equals("roleAdd")) {
			roleAdd(req, resp);
		}

		if (string.equals("roleAlter")) {
			roleAlter(req, resp);
		}
		if (string.equals("roleDelete")) {
			roleDelete(req, resp);
		}

		if (string.equals("roleUpdate")) {
			roleUpdate(req, resp);
		}
	}

	private static void roleShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 总用户数
		int count = roleservice.roleNumber();
		// 每页数据数
		int number = 5;
		// 当前页数
		int page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		List<Role> allRole = roleservice.allRole((page - 1) * number, number);

		req.setAttribute("rolelist", allRole);
		req.setAttribute("count", count);
		req.setAttribute("page", page);

		req.getRequestDispatcher("WEB-INF/jsp/admin/role/rolelist.jsp").forward(req, resp);
	}

	private static void roleAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/admin/role/roleadd.jsp").forward(req, resp);
	}

	private static void roleAlter(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 不空 有id 修改
		if (req.getParameter("role_id") != null) {

			boolean isUpdate = roleservice.updateRole(req);
			if (isUpdate == false) {
				req.setAttribute("msg", "更新失败");
			}
		} else {
			boolean isAdd = roleservice.addRole(req);
			if (isAdd == false) {
				req.setAttribute("error", "添加失败");
			}

		}
		resp.sendRedirect("RoleShowServlet1?service=roleShow");

	}

	private static void roleDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		roleservice.deleteRole(req);
		resp.sendRedirect("roleShow?service=roleShow");
	}

	private static void roleUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Role role = roleservice.selectRoleById(req);
		req.setAttribute("role", role);
		req.getRequestDispatcher("WEB-INF/jsp/admin/role/roleupdate.jsp").forward(req, resp);
	}
}
