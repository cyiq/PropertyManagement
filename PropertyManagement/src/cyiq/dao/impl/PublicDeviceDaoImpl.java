package cyiq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import cyiq.bean.Employee;
import cyiq.bean.PublicDevice;
import cyiq.dao.EmployeeDao;
import cyiq.dao.PublicDeviceDao;
import cyiq.utils.JDBCUtils;

public class PublicDeviceDaoImpl implements PublicDeviceDao{


	@Override
	public void save(PublicDevice publicdevice) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into publicdevice (devicename,deviceprice,devicenum) "
					+ " values(?,?,?)";
			Object[] params = {publicdevice.getDeviceName(),publicdevice.getDevicePrice(),publicdevice.getDeviceNum()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public List<PublicDevice> findAllPublicDevice() {
		Connection conn = null;
		List<PublicDevice> publicDeviceList = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select deviceid,devicename,deviceprice,devicenum "
					+ "from publicdevice";
			QueryRunner query = new QueryRunner();
			publicDeviceList = query.query(conn, sql, new BeanListHandler<PublicDevice>(PublicDevice.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return publicDeviceList;
	}

	@Override
	public PublicDevice findPublicDeviceById(Integer deviceId) {
		
		Connection conn = null;
		PublicDevice publicDevice = null;
		try {
			conn = JDBCUtils.getConnection();
			List paramsList = new ArrayList();
			String sql = "select deviceid,devicename,deviceprice,devicenum "
					+ "from publicdevice"
					+ " where deviceid=? ";
			System.out.println(sql);
			Object[] params = {deviceId};
			QueryRunner query = new QueryRunner();
			publicDevice = query.query(conn, sql, new BeanHandler<PublicDevice>(PublicDevice.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return publicDevice;
	}


	@Override
	public void update(PublicDevice publicdevice) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update  publicdevice set devicename=?,deviceprice=?,devicenum=?"
					+ " where deviceid=?";
			Object[] params = {publicdevice.getDeviceName(),publicdevice.getDevicePrice(),publicdevice.getDeviceNum()
								,publicdevice.getDeviceId()
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
	public void delete(Integer deviceId) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from  publicdevice where deviceid=?";
			Object[] params = {deviceId};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
	}


}
