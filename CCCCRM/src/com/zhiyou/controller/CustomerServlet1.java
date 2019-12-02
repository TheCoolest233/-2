package com.zhiyou.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;
import com.zhiyou.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet1
 */
@WebServlet("/CustomerServlet1")
public class CustomerServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static CustomerService service = new CustomerServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);
		if (string.equals("customerShow")) {
			customerShow(req, resp);
		}
		if (string.equals("addCustomer")) {
			addCustomer(req, resp);
		}
		if (string.equals("alterCustomer")) {
			try {
				alterCustomer(req, resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (string.equals("updateCustomer")) {
			updateCustomer(req, resp);
		}
		if (string.equals("deleteCustomer")) {
			deleteCustomer(req, resp);
		}
	}

	private static void customerShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("WEB-INF/jsp/customer/customerManage/customerShow.jsp").forward(req, resp);
	}

	private static void addCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/customer/customerManage/addCustomer.jsp").forward(req, resp);
	}

	private static void alterCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		Integer customer_id = req.getParameter("customer_id") == null || req.getParameter("customer_id") == "" ? null
				: Integer.valueOf(req.getParameter("customer_id"));
		Integer user_id = req.getParameter("user_id") == null || req.getParameter("user_id") == "" ? null
				: Integer.valueOf(req.getParameter("user_id"));
		Integer customer_category_id = req.getParameter("customer_category_id") == null
				|| req.getParameter("customer_category_id") == "" ? null
						: Integer.valueOf(req.getParameter("customer_category_id"));
		String customer_name = req.getParameter("customer_name");
		Boolean customer_is_male = req.getParameter("customer_is_male") == null
				|| req.getParameter("customer_is_male") == "" ? null
						: Boolean.valueOf(req.getParameter("customer_is_male"));
		String customer_mobile = req.getParameter("customer_mobile");
		String customer_qq = req.getParameter("customer_qq");
		String customer_address = req.getParameter("customer_address");
		String customer_email = req.getParameter("customer_email");
		String customer_remark = req.getParameter("customer_remark");
		String customer_position = req.getParameter("customer_position");
		String customer_blog = req.getParameter("customer_blog");
		String customer_tel = req.getParameter("customer_tel");
		Date customer_birth = req.getParameter("customer_birth") == null || req.getParameter("customer_birth") == ""
				? null
				: new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("customer_birth"));
		String customer_company = req.getParameter("customer_company");
		if (customer_id == null) {

			Customer customer = new Customer(user_id, customer_category_id, customer_name, customer_is_male,
					customer_mobile, customer_qq, customer_address, customer_email, customer_remark, customer_position,
					customer_blog, customer_tel, customer_birth, customer_company);
			service.addCustomer(customer);
		} else {
			Customer customer = new Customer(customer_id, user_id, customer_category_id, customer_name,
					customer_is_male, customer_mobile, customer_qq, customer_address, customer_email, customer_remark,
					customer_position, customer_blog, customer_tel, customer_birth, customer_company);
			service.updateCustomer(customer);
		}
		resp.sendRedirect("customerShow?service=customerShow");
	}

	private static void updateCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("customer", service.selectById(Integer.valueOf(req.getParameter("customer_id"))));
		req.getRequestDispatcher("WEB-INF/jsp/customer/customerManage/updateCustomer.jsp").forward(req, resp);
	}

	private static void deleteCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String customer_id = req.getParameter("customer_id");
		service.deleteById(Integer.valueOf(customer_id));
		req.getRequestDispatcher("customerShow?service=customerShow").forward(req, resp);
	}

}
