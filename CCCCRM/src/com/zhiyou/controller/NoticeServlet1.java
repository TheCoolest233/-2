package com.zhiyou.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Notice;
import com.zhiyou.service.NoticeService;
import com.zhiyou.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeServlet1
 */
@WebServlet("/NoticeServlet1")
public class NoticeServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NoticeService service = new NoticeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);

		if (string.equals("noticeShow")) {
			noticeShow(req, resp);

		}

		if (string.equals("addNotice")) {
			addNotice(req, resp);
		}

		if (string.equals("alterNotice")) {
			try {
				alterNotice(req, resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (string.equals("updateNotice")) {
			updateNotice(req, resp);
		}
		if (string.equals("deleteNotice")) {
			deleteNotice(req, resp);
		}
		if (string.equals("noticeT")) {
			noticeT(req, resp);
		}

	}

	private static void noticeShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		System.out.println(service.selectAll((page - 1) * 5, 5));
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("WEB-INF/jsp/admin/notice/noticeShow.jsp").forward(req, resp);
	}

	private static void addNotice(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/admin/notice/addNotice.jsp").forward(req, resp);
	}

	private static void alterNotice(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {

		Integer notice_id = req.getParameter("notice_id") == "" || req.getParameter("notice_id") == null ? null
				: Integer.valueOf(req.getParameter("notice_id"));
		Integer receive_id = req.getParameter("receive_id") == "" || req.getParameter("receive_id") == null ? null
				: Integer.valueOf(req.getParameter("receive_id"));
		String subject = req.getParameter("subject");
		String text = req.getParameter("text");

		Date pub_time = req.getParameter("pub_time") == "" || req.getParameter("pub_time") == null ? null
				: Date.valueOf(req.getParameter("pub_time"));
		Date expire_time = req.getParameter("expire_time") == "" || req.getParameter("expire_time") == null ? null
				: Date.valueOf(req.getParameter("expire_time"));
		Integer creater = req.getParameter("creater") == "" || req.getParameter("creater") == null ? null
				: Integer.valueOf(req.getParameter("creater"));
		if (notice_id == null) {
			Notice notice = new Notice(receive_id, subject, text, pub_time, expire_time, creater);
			service.addNotice(notice);
		} else {
			Notice notice = new Notice(notice_id, receive_id, subject, text, pub_time, expire_time, creater);
			service.updateNotice(notice);
		}

		resp.sendRedirect("NoticeServlet1?service=noticeShow");
	}

	private static void updateNotice(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("notice", service.selectById(Integer.valueOf(req.getParameter("notice_id"))));
		req.getRequestDispatcher("/WEB-INF/jsp/admin/notice/updateNotice.jsp").forward(req, resp);
	}

	private static void deleteNotice(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String notice_id = req.getParameter("notice_id");
		service.deleteById(Integer.valueOf(notice_id));
		req.getRequestDispatcher("noticeShow?service=noticeShow").forward(req, resp);
	}

	private static void noticeT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = service.selectCount();
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5));
		req.getRequestDispatcher("WEB-INF/jsp/inside/notice.jsp").forward(req, resp);
	}

}
