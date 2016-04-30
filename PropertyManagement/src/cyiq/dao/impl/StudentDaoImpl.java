package cyiq.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;

import cyiq.bean.Student;
import cyiq.dao.StudentDao;
import cyiq.utils.JDBCUtils;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Student login(Student student) {
		Connection conn = null;
		Student newstudent = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select sid,sname,loginName,loginPassword,stelephone,smessage "
					+ "	from student "
					+ " where loginName=? and loginpassword=?" ;
			Object[] params = {student.getLoginName(),student.getLoginPassword()};
			QueryRunner query = new QueryRunner();
			newstudent = query.query(conn, sql, new BeanHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return newstudent;
	}

	@Override
	public void save(Student student) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into student (sname,loginName,loginPassword,stelephone)"
					+ " values(?,?,?,?)";
			Object[] params = {student.getSname(),student.getLoginName(),student.getLoginPassword(),
								student.getStelephone()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
	}

	@Override
	public List<Student> findStudentsByCondition(Student student) {
		Connection conn = null;
		List<Student> studentList = null;
		try {
			conn = JDBCUtils.getConnection();
			StringBuffer stringBuffer = new StringBuffer();
			List paramsList = new ArrayList();
			if(StringUtils.isNotBlank(student.getSname())){
				stringBuffer.append("and sname like ? ");
				paramsList.add("%"+student.getSname()+"%");
			}
			if(StringUtils.isNotBlank(student.getLoginName())){
				stringBuffer.append("and loginName like ? ");
				paramsList.add("%"+student.getLoginName()+"%");
			}
			String sql = "select sid,sname,loginName,loginPassword,stelephone,smessage from student"
					+ " where 1=1 "+stringBuffer.toString();
			System.out.println(sql);
			Object[] params = paramsList.toArray();
			QueryRunner query = new QueryRunner();
			studentList = query.query(conn, sql, new BeanListHandler<Student>(Student.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		return studentList;
	}

	@Override
	public Student findStudentById(Integer sid) {
		Connection conn = null;
		Student newstudent = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select sid,sname,loginName,loginPassword,stelephone,smessage from student"
					+ " where sid=?";
			Object[] params = {sid};
			QueryRunner query = new QueryRunner();
			newstudent = query.query(conn, sql, new BeanHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return newstudent;
	}

	@Override
	public Student findStudentByLoginName(String loginName) {
		Connection conn = null;
		Student newstudent = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select sid,sname,loginName,loginPassword,stelephone,smessage from student"
					+ " where loginName=?";
			Object[] params = {loginName};
			QueryRunner query = new QueryRunner();
			newstudent = query.query(conn, sql, new BeanHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		return newstudent;
	}
	@Override
	public void update(Student student) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update student set sid=?,sname=?,loginName=?,loginPassword=?,stelephone=?"
					+ " where sid=?";
			Object[] params = {student.getSid(),student.getSname(),student.getLoginName(),student.getLoginPassword(),
					student.getStelephone(),student.getSid()};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
		
		
	}

	@Override
	public void delete(Integer sid) {
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from  student where sid=?";
			Object[] params = {sid};
			QueryRunner query = new QueryRunner();
			query.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeResource(conn, null, null);
		}
	}


}
