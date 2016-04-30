package cyiq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import cyiq.bean.Charge;
import cyiq.dao.ChargeDao;
import cyiq.utils.JDBCUtils;

public class ChargeDaoImpl implements ChargeDao{

	
	

	@Override
	public void save(Charge charge) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "insert into chargelist (sid,sname,loginName,applyid,deviceid,devicename,deviceprice,applynumber,sumprice,date)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			Object[] params = {charge.getSid(),charge.getSname(),charge.getLoginName(),charge.getApplyId(),charge.getDeviceId(),
					charge.getDeviceName(),	charge.getDevicePrice(),charge.getApplyNumber(),charge.getSumPrice(),charge.getDate()
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
	public List<Charge> findAllCharge() {
		Connection conn = null;
		List<Charge> chargeList = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select chargeid,sid,sname,loginName,applyid,deviceid,devicename,deviceprice,applynumber,sumprice,date"
					+ " from chargelist";
			QueryRunner query = new QueryRunner();
			chargeList = query.query(conn, sql, new BeanListHandler<Charge>(Charge.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return chargeList;
	}

	@Override
	public List<Charge> findChargesBySid(Integer sid) {
		Connection conn = null;
		List<Charge> chargeList = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select chargeid,sid,sname,deviceid,devicename,deviceprice,chargenumber,sumprice"
					+ " from chargelist"
					+ " where sid=?";
			Object[] params = {sid};
			QueryRunner query = new QueryRunner();
			chargeList = query.query(conn, sql, new BeanListHandler<Charge>(Charge.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return chargeList;
	}
	

}
