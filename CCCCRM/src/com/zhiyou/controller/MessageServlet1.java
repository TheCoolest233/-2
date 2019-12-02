package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Message;
import com.zhiyou.model.User;
import com.zhiyou.service.MessageService;
import com.zhiyou.service.impl.MessageServiceImpl;
import com.zhiyou.util.SessionKey;

/**
 * Servlet implementation class MessageServlet1
 */
@WebServlet("/MessageServlet1")
public class MessageServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MessageService service = new MessageServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String string = req.getParameter("service");
		System.out.println(string);
		if (string.equals("messageShow")) {
			messageShow(req, resp);
		}
		if (string.equals("addMessage")) {
			addMessage(req, resp);
		}
		if (string.equals("alterMessage")) {
			alterMessage(req, resp);
		}
		if (string.equals("draftShow")) {
			draftShow(req, resp);
		}
		if (string.equals("outShow")) {
			outShow(req, resp);
		}
		if (string.equals("dustbinShow")) {
			dustbinShow(req, resp);
		}
		if (string.equals("deleteMessage")) {
			deleteMessage(req, resp);
		}
		if (string.equals("updateMessage")) {
			updateMessage(req, resp);
		}
		if (string.equals("deleteLjMessage")) {
			deleteLjMessage(req, resp);
		}
	}

	private static void messageShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(SessionKey.USER_LOGIN);
		System.out.println(user);
		System.out.println(user.getUser_id());
		int count = service.selectCountS(user.getUser_id());
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectAll((page - 1) * 5, 5, user.getUser_id()));
		req.getRequestDispatcher("WEB-INF/jsp/message/messageShow.jsp").forward(req, resp);
	}

	private static void addMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/message/addMessage.jsp").forward(req, resp);
	}

	private static void alterMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String sub = req.getParameter("sub");
		Integer message_id = req.getParameter("message_id") == "" || req.getParameter("message_id") == null ? null
				: Integer.valueOf(req.getParameter("message_id"));
		String content = req.getParameter("content");
		String subject = req.getParameter("subject");
		Integer sender = req.getParameter("sender") == "" || req.getParameter("sender") == null ? null
				: Integer.valueOf(req.getParameter("sender"));
		Integer receiver = req.getParameter("receiver") == "" || req.getParameter("receiver") == null ? null
				: Integer.valueOf(req.getParameter("receiver"));
		if (message_id == null) {
			if (sub.equals("发送")) {
				Message message = new Message(subject, content, sender, receiver);
				service.addMessage(message);
				resp.sendRedirect("MessageServlet1?service=messageShow");
			} else {
				Message message = new Message(subject, content, sender, receiver);
				service.draftMessage(message);
				resp.sendRedirect("MessageServlet1?service=draftShow");
			}

		} else {
			Message message1 = new Message(message_id, subject, content, sender, receiver);
			service.updateMessage(message1);
			resp.sendRedirect("MessageServlet1?service=draftShow");

		}

	}

	private static void draftShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(SessionKey.USER_LOGIN);
		int count = service.selectCountC(user.getUser_id());
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);

		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectDAll((page - 1) * 5, 5, user.getUser_id()));
		req.getRequestDispatcher("WEB-INF/jsp/message/draftMessage.jsp").forward(req, resp);
	}

	private static void outShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(SessionKey.USER_LOGIN);
		int count = service.selectCountF(user.getUser_id());
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);
		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectFAll((page - 1) * 5, 5, user.getUser_id()));
		req.getRequestDispatcher("WEB-INF/jsp/message/outboxMessage.jsp").forward(req, resp);
	}

	private static void dustbinShow(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute(SessionKey.USER_LOGIN);
		int count = service.selectCountL(user.getUser_id());
		int page = req.getParameter("page") == null || req.getParameter("page") == "" ? 1
				: Integer.valueOf(req.getParameter("page"));
		System.out.println(page);

		req.setAttribute("count", count);
		req.setAttribute("page", page);
		req.setAttribute("list", service.selectLAll((page - 1) * 5, 5, user.getUser_id()));
		req.getRequestDispatcher("WEB-INF/jsp/message/dustbinMessage.jsp").forward(req, resp);
	}

	private static void deleteMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message_id = req.getParameter("message_id");
		service.deleteById(Integer.valueOf(message_id));
		req.getRequestDispatcher("WEB-INF/jsp/message/messageShow.jsp").forward(req, resp);
	}

	private static void updateMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("message1", service.selectById(Integer.valueOf(req.getParameter("message_id"))));
		req.getRequestDispatcher("WEB-INF/jsp/message/updateShow.jsp").forward(req, resp);

	}

	private static void deleteLjMessage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer message_id = req.getParameter("message_id") == "" || req.getParameter("message_id") == null ? null
				: Integer.valueOf(req.getParameter("message_id"));
		Message message = new Message(message_id);

		if (req.getParameter("name").equals("1")) {
			service.dustbinFDMessage(message);
		} else {
			service.dustbinMessage(message);
		}

	}

}
