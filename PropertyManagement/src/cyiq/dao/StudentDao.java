package cyiq.dao;

import java.util.List;

import cyiq.bean.Student;

public interface StudentDao {

	public Student login(Student student);

	public void save(Student student);

	public List<Student> findStudentsByCondition(Student student);

	public Student findStudentById(Integer sid);
	
	public Student findStudentByLoginName(String loginName);
	
	public void update(Student student);

	public void delete(Integer sid);

}
