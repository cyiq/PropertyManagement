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
import cyiq.dao.EmployeeDao;
import cyiq.utils.JDBCUtils;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee login(Employee employee) {
		Connection conn = null;
		Employee newUser = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select id,userName,loginName,loginPassword,sex,age,address,"
					+ "telephone,isManager,message from employee"
					+ " where loginName=? and loginPassword=?";
			Object[] params = {employee.getLoginName(),employee.getLoginPassword()};
			QueryRunner query = new QueryRunner();
			newUser = query.query(conn, sql, new BeanHandler<Employee>(Employee.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return newUser;
	}

	@Override
	public void save(Employee employee) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into employee (userName,loginName,loginPassword,sex,age,address,"
					+ "telephone,isManager)"
					+ " values(?,?,?,?,?,?,?,?)";
			Object[] params = {employee.getUserName(),employee.getLoginName(),employee.getLoginPassword(),employee.getSex(),
								employee.getAge(),employee.getAddress(),employee.getTelephone(),employee.getIsManager()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public List<Employee> findEmployeesByCondition(Employee employee) {
		Connection conn = null;
		List<Employee> employeeList = null;
		try {
			conn = JDBCUtils.getConnection();
			StringBuffer stringBuffer = new StringBuffer();
			List paramsList = new ArrayList();
			if(StringUtils.isNotBlank(employee.getUserName())){
				stringBuffer.append("and userName like ? ");
				paramsList.add("%"+employee.getUserName()+"%");
			}
			if(StringUtils.isNotBlank(employee.getSex())){
				stringBuffer.append("and sex=?");
				paramsList.add(employee.getSex());
			}
			if(employee.getIsManager()!=null && employee.getIsManager()==1){
				stringBuffer.append("and isManager=?");
				paramsList.add(employee.getIsManager());
			}
			if(employee.getIsManager()!=null && employee.getIsManager()==0){
				stringBuffer.append("and isManager=?");
				paramsList.add(employee.getIsManager());
			}
			
			String sql = "select id,userName,loginName,loginPassword,sex,age,address,"
					+ "telephone,isManager,message from employee"
					+ " where 1=1 "+stringBuffer.toString();
			System.out.println(sql);
			Object[] params = paramsList.toArray();
			QueryRunner query = new QueryRunner();
			employeeList = query.query(conn, sql, new BeanListHandler<Employee>(Employee.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		Connection conn = null;
		Employee newUser = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select id,userName,loginName,loginPassword,sex,age,address,"
					+ "telephone,isManager,message from employee " 
					+ " where id=?";
			Object[] params = {id};
			QueryRunner query = new QueryRunner();
			newUser = query.query(conn, sql, new BeanHandler<Employee>(Employee.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return newUser;
	}

	@Override
	public void update(Employee employee) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update  employee set userName=?,loginName=?,loginPassword=?,sex=?,age=?,address=?,"
					+ "telephone=?,isManager=? "
					+ " where id=?";
			Object[] params = {employee.getUserName(),employee.getLoginName(),
					employee.getLoginPassword(),employee.getSex(),
					employee.getAge(),employee.getAddress(),employee.getTelephone(),
					employee.getIsManager(),employee.getId()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		
	}

	@Override
	public void delete(Integer employeeID) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from  employee where id=?";
			Object[] params = {employeeID};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
	}

}
