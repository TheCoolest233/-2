package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Department;
import com.zhiyou.service.DepartmentService;
import com.zhiyou.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class DepartmentServlet1
 */
@WebServlet("/DepartmentServlet1")
public class DepartmentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static DepartmentService service = new DepartmentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);
		if (string.equals("departmentShow")) {
			departmentShow(req, resp);
		}

		if (string.equals("addDepartment")) {
			addDepartment(req, resp);
		}

		if (string.equals("alterDepartment")) {
			alterDepartment(req, resp);
		}

		if (string.equals("updateDepartment")) {
			updateDepartment(req, resp);
		}
		if (string.equals("deleteDepartment")) {
			deleteDepartment(req, resp);
		}
		if (string.equals("departmentShowB")) {
			departmentShowB(req, resp);
		}

	}

	private static void departmentShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("WEB-INF/jsp/admin/department/departmentShow.jsp").forward(req, resp);
	}

	private static void addDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/admin/department/addDepartment.jsp").forward(req, resp);
	}

	private static void alterDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Integer department_id = req.getParameter("department_id") == "" || req.getParameter("department_id") == null
				? null
				: Integer.valueOf(req.getParameter("department_id"));
		String department_name = req.getParameter("department_name");
		String department_desc = req.getParameter("department_desc");
		if (department_id == null) {
			Department department = new Department(department_name, department_desc);
			service.addDepartment(department);
		} else {
			Department department = new Department(department_id, department_name, department_desc);
			service.updateDepartment(department);
		}

		resp.sendRedirect("DepartmentServlet1?service=departmentShow");
	}

	private static void updateDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("department", service.selectById(Integer.valueOf(req.getParameter("department_id"))));
		req.getRequestDispatcher("/WEB-INF/jsp/admin/department/updateDepartment.jsp").forward(req, resp);
	}

	private static void deleteDepartment(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String department_id = req.getParameter("department_id");
		service.deleteById(Integer.valueOf(department_id));
		req.getRequestDispatcher("DepartmentServlet1?service=departmentShow").forward(req, resp);
	}

	private static void departmentShowB(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("WEB-INF/jsp/inside/departmentList.jsp").forward(req, resp);
	}
}
