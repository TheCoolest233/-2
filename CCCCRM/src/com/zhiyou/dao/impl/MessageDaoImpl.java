package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.MessageDao;
import com.zhiyou.model.Message;
import com.zhiyou.util.JDBCUtil;

public class MessageDaoImpl implements MessageDao {

	public List<Message> selectAll(int page, int number, Integer receiver) {
		String sql = "select * from message where receive_delete=2 and send_status=2 and receiver=? limit " + page + ","
				+ number;
		return JDBCUtil.dbDQL(sql, Message.class, receiver);
	}

	public void addMessage(Message message) {
		String sql = "insert into message(message_id,subject,content,sender,send_status,receiver,receive_delete) values(null,?,?,?,2,?,2)";
		JDBCUtil.dbDML(sql, message.getSubject(), message.getContent(), message.getSender(), message.getReceiver());

	}

	public void deleteById(Integer message_id) {
		String sql = "delete from message where message_id=?";
		JDBCUtil.dbDML(sql, message_id);

	}

	public void draftMessage(Message message) {
		String sql = "insert into message(message_id,subject,content,sender,send_status,receiver) values(null,?,?,?,0,?)";
		JDBCUtil.dbDML(sql, message.getSubject(), message.getContent(), message.getSender(), message.getReceiver());

	}

	public Message selectById(Integer message_id) {
		String sql = "select * from message where message_id=?";
		return JDBCUtil.dbDQL(sql, Message.class, message_id).get(0);
	}

	public int selectCountS(Integer user_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from message where receive_delete=2 and receiver=? and send_status=2";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}

	public List<Message> selectDAll(int page, int number, Integer user_id) {
		String sql = "select * from message where send_status=0 and sender=? limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, Message.class, user_id);
	}

	public List<Message> selectFAll(int page, int number, Integer sender) {
		String sql = "select * from message where send_delete=2 and sender=? and send_status=2  limit " + page + ","
				+ number;
		return JDBCUtil.dbDQL(sql, Message.class, sender);
	}

	public void dustbinMessage(Message message) {
		System.out.println("进来啦！");
		String sql = "update message set receive_delete=0 where message_id=?";
		JDBCUtil.dbDML(sql, message.getMessage_id());
	}

//	查询垃圾箱
	public List<Message> selectLAll(int page, int number, Integer user_id) {
//		aa  
//		发件人是aa  sender=id   发件状态 是已经删除senddelete=0
//		收件人是aa  receiver =id  收件状态是0 receive_delete=0
		String sql = " select * from message where (sender=? and send_delete=0 ) or (receiver=? and receive_delete=0 ) limit "
				+ page + "," + number;

		return JDBCUtil.dbDQL(sql, Message.class, user_id, user_id);
	}

	public void dustbinFDMessage(Message message) {
		System.out.println("进来啦");
		String sql = "update message set send_delete=0 where message_id=?";
		JDBCUtil.dbDML(sql, message.getMessage_id());

	}

	public int selectCountF(Integer user_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from message where send_delete=2 and sender=? and send_status=2";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}

	public int selectCountC(Integer user_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from message where send_status=0 and sender=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}

	public int selectCountL(Integer user_id) {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from message where (receive_delete=0 and send_status=2 and receiver=?) or (sender=? and send_delete=0 )";
		PreparedStatement ps = null;

		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, user_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return count;
	}

	public void updateMessage(Message message1) {
		String sql = "update message set subject=?,content=?,sender=?,receiver=? where message_id=? ";
		JDBCUtil.dbDML(sql, message1.getSubject(), message1.getContent(), message1.getSender(), message1.getReceiver(),
				message1.getMessage_id());
	}

}