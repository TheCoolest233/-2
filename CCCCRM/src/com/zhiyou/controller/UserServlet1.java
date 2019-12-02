package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet1
 */
@WebServlet("/UserServlet1")
public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserService service = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);
		if (string.equals("show")) {
			show(req, resp);
		}
		if (string.equals("add")) {
			add(req, resp);
		}
		if (string.equals("alter")) {
			alter(req, resp);
		}
		if (string.equals("update")) {
			update(req, resp);
		}
		if (string.equals("delete")) {
			delete(req, resp);
		}
		if (string.equals("like")) {
			like(req, resp);
		}
		if (string.equals("showY")) {
			showY(req, resp);
		}
	}

	private static void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		String like = req.getParameter("like");
		if (like == null)
			like = "";
		if (!like.equals("1")) {
			req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		}
		req.getRequestDispatcher("/WEB-INF/jsp/admin/userManage/userlist.jsp").forward(req, resp);
	}

	private static void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/jsp/admin/userManage/addUser.jsp").forward(req, resp);
	}

	private static void alter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer user_id = req.getParameter("user_id") == "" || req.getParameter("user_id") == null ? null
				: Integer.valueOf(req.getParameter("user_id"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Integer department_id = req.getParameter("department_id") == "" ? null
				: Integer.valueOf(req.getParameter("department_id"));
		Integer role_id = req.getParameter("role_id") == "" ? null : Integer.valueOf(req.getParameter("role_id"));
		Boolean is_male = req.getParameter("is_male") == "" ? null : Boolean.valueOf(req.getParameter("is_male"));
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		Integer age = req.getParameter("age") == "" ? null : Integer.valueOf(req.getParameter("age"));
		String tel = req.getParameter("tel");
		String id_num = req.getParameter("id_num");
		String email = req.getParameter("email");
		String hobby = req.getParameter("hobby");
		Integer education = req.getParameter("education") == "" ? null : Integer.valueOf(req.getParameter("education"));
		String card_num = req.getParameter("card_num");
		String nation = req.getParameter("nation");
		Integer marry = req.getParameter("marry") == "" ? null : Integer.valueOf(req.getParameter("marry"));
		String remark = req.getParameter("remark");
		if (user_id == null) {
			User user = new User(department_id, role_id, username, is_male, mobile, age, address, password, tel, id_num,
					email, hobby, education, card_num, nation, marry, remark);
			service.add(user);
		} else {
			User user = new User(user_id, department_id, role_id, username, is_male, mobile, age, address, password,
					tel, id_num, email, hobby, education, card_num, nation, marry, remark);
			service.update(user);
		}

		resp.sendRedirect("UserServlet1?service=alter");
	}

	private static void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", service.selectById(Integer.valueOf(req.getParameter("user_id"))));
		req.getRequestDispatcher("/WEB-INF/jsp/admin/userManage/updateUser.jsp").forward(req, resp);
	}

	private static void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		service.deleteById(Integer.valueOf(user_id));
		req.getRequestDispatcher("UserServlet1?service=show").forward(req, resp);
	}

	private static void like(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String value = req.getParameter("value");
		if (name.equals("用户名")) {
			name = "username";
		} else if (name.equals("员工ID")) {
			name = "user_id";
		}
		req.setAttribute("list", service.selectLike(name, value));
		req.getRequestDispatcher("UserServlet1?service=show&like=1").forward(req, resp);
	}

	private static void showY(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		String like = req.getParameter("like");
		if (like == null)
			like = "";
		if (!like.equals("1")) {
			req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		}
		req.getRequestDispatcher("WEB-INF/jsp/inside/userShow.jsp").forward(req, resp);
	}

}
