package com.zhiyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou.dao.NoticeDao;
import com.zhiyou.model.Notice;
import com.zhiyou.util.JDBCUtil;

public class NoticeDaoImpl implements NoticeDao {

	public List<Notice> selectAll(int page, int number) {
		String sql = "select * from notice limit " + page + "," + number;
		return JDBCUtil.dbDQL(sql, Notice.class);
	}

	public void addNotice(Notice notice) {
		String sql = "insert into notice(notice_id,receive_id,subject,text,pub_time,expire_time,creater) values(null,?,?,?,?,?,?)";
		JDBCUtil.dbDML(sql, notice.getReceive_id(), notice.getSubject(), notice.getText(), notice.getPub_time(),
				notice.getExpire_time(), notice.getCreater());

	}

	public void deleteById(Integer notice_id) {
		String sql = "delete from notice where notice_id=?";
		JDBCUtil.dbDML(sql, notice_id);

	}

	public void updateNotice(Notice notice) {
		String sql = "update notice set receive_id=?,subject=?,text=?,pub_time=?,expire_time=?,creater=? where notice_id=? ";
		JDBCUtil.dbDML(sql, notice.getReceive_id(), notice.getSubject(), notice.getText(), notice.getPub_time(),
				notice.getExpire_time(), notice.getCreater(), notice.getNotice_id());

	}

	public Notice selectById(Integer notice_id) {
		String sql = "select * from notice where notice_id=?";
		return JDBCUtil.dbDQL(sql, Notice.class, notice_id).get(0);
	}

	public int selectCount() {
		Connection con = JDBCUtil.getConnection();
		String sql = "select count(*) from notice";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
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

}
