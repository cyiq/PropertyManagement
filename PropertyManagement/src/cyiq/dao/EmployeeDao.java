package cyiq.dao;

import java.util.List;

import cyiq.bean.Employee;

public interface EmployeeDao {

	public Employee login(Employee employee);

	public void save(Employee employee);

	public List<Employee> findEmployeesByCondition(Employee employee);

	public Employee findEmployeeById(Integer id);

	public void update(Employee employee);

	public void delete(Integer id);
	
}
