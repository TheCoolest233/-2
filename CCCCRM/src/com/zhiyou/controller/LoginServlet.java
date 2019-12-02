package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.service.impl.UserServiceImpl;
import com.zhiyou.util.SessionKey;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username") != null ? req.getParameter("username") : " ";
		String password = req.getParameter("password") != null ? req.getParameter("password") : " ";
//		System.out.println(username);
//		if (req.getParameter(username).equals("username")) {
//			if (req.getParameter(password).equals("password")) {
//				System.out.println("登录成功");
//			} else {
//				System.out.println("密码错误");
//			}
//		} else {
//			System.out.println("用户不存在");
//		}
//	}
		UserServiceImpl service = new UserServiceImpl();
		User user = service.selectByUserName(req, username, password);
		if (user != null) {

			req.getSession().setAttribute(SessionKey.USER_LOGIN, user);
			resp.sendRedirect("admin.jsp");
		} else {

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
