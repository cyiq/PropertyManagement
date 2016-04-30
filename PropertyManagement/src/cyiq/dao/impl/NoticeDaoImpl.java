package cyiq.dao.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cyiq.bean.Notice;
import cyiq.dao.NoticeDao;
import cyiq.utils.JDBCUtils;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public List<Notice> findAllNotice() {
		Connection conn = null;
		List<Notice> noticeList = null;
		JDBCUtils jdbcUtils = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "select noticeId,noticeDate,noticeTitle,noticeContent from notice";
			QueryRunner query = new QueryRunner();
			noticeList = query.query(conn, sql, new BeanListHandler<Notice>(Notice.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeResource(conn, null, null);
		}
		return noticeList;
	}

	@Override
	public void saveNotice(Notice notice) {
		Connection conn = null;
		JDBCUtils jdbcUtils = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "insert into notice (noticeDate,noticeTitle,noticeContent) values(?,?,?)";
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			String time = sf.format(date);
			notice.setNoticeDate(time);
			Object[] params = {notice.getNoticeDate(),notice.getNoticeTitle(),notice.getNoticeContent()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeResource(conn, null, null);
		}
	}

	@Override
	public Notice findNoticeById(Integer noticeId) {
		Connection conn = null;
		JDBCUtils jdbcUtils = null;
		Notice newNotice = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql="select noticeId,noticeDate,noticeTitle,noticeContent from notice where noticeId=?";
			Object[] params = {noticeId};
			QueryRunner query = new QueryRunner();
			newNotice = query.query(conn,sql, new BeanHandler<Notice>(Notice.class),params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeResource(conn, null, null);
		}
		return newNotice;
	}

	@Override
	public void updateNotice(Notice notice) {
		Connection conn = null;
		JDBCUtils jdbcUtils = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "update notice set noticeDate=?,noticeTitle=?,noticeContent=? where noticeId=?";
			Object[] params = {notice.getNoticeDate(),notice.getNoticeTitle(),notice.getNoticeContent(),notice.getNoticeId()};
			QueryRunner query = new QueryRunner();
			query.update(conn,sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public void deleteNoticeById(Integer noticeId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		JDBCUtils jdbcUtils = null;
		try {
			conn = jdbcUtils.getConnection();
			String sql = "delete from notice where noticeId=?";
			Object[] params = {noticeId};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcUtils.closeResource(conn, null, null);
		}
	}

}
