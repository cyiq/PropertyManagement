package cyiq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import cyiq.bean.Apply;
import cyiq.dao.ApplyDao;
import cyiq.utils.JDBCUtils;

public class ApplyDaoImpl implements ApplyDao{

	@Override
	public Apply login(Apply apply) {
		Connection conn = null;
		Apply newapply = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select sid,sname,loginName,loginPassword,stelephone,smessage "
					+ "	from apply "
					+ " where loginName=? and loginpassword=?" ;
			Object[] params = {};
			QueryRunner query = new QueryRunner();
			newapply = query.query(conn, sql, new BeanHandler<Apply>(Apply.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return newapply;
	}
	
	

	@Override
	public void save(Apply apply) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into applylist (sid,sname,deviceid,devicename,deviceprice,applynumber,sumprice)"
					+ " values(?,?,?,?,?,?,?)";
			Object[] params = {apply.getSid(),apply.getSname(),apply.getDeviceId(),apply.getDeviceName(),
								apply.getDevicePrice(),apply.getApplyNumber(),apply.getSumPrice()
							};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public List<Apply> findAllApply() {
		Connection conn = null;
		List<Apply> applyList = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select applyid,sid,sname,deviceid,devicename,deviceprice,applynumber,sumprice"
					+ " from applylist";
			QueryRunner query = new QueryRunner();
			applyList = query.query(conn, sql, new BeanListHandler<Apply>(Apply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return applyList;
	}

	@Override
	public List<Apply> findApplysBySid(Integer sid) {
		Connection conn = null;
		List<Apply> applyList = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select applyid,sid,sname,deviceid,devicename,deviceprice,applynumber,sumprice"
					+ " from applylist"
					+ " where sid=?";
			Object[] params = {sid};
			QueryRunner query = new QueryRunner();
			applyList = query.query(conn, sql, new BeanListHandler<Apply>(Apply.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return applyList;
	}
	
	@Override
	public Apply findApplyByApplyId(Integer applyId) {
		Connection conn = null;
		Apply apply = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select applyid,sid,sname,deviceid,devicename,deviceprice,applynumber,sumprice"
					+ " from applylist"
					+ " where applyId=?";
			Object[] params = {applyId};
			QueryRunner query = new QueryRunner();
			apply = query.query(conn, sql, new BeanHandler<Apply>(Apply.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return apply;
	}
	
	@Override
	public void update(Apply apply) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update applylist set applyid=?,sid=?,sname=?,deviceid=?,"
					+ " devicename=?,deviceprice=?,applynumber=?, sumprice=? "
					+ " where applyid=?";
			Object[] params = {apply.getApplyId(),apply.getSid(),apply.getSname(),apply.getDeviceId(),
								apply.getDeviceName(),apply.getDevicePrice(),apply.getApplyNumber(),apply.getSumPrice(),
								apply.getApplyId()
							};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		
	}

	@Override
	public void delete(Integer applyId) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from applylist where applyId=?";
			Object[] params = {applyId};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
	}

}
