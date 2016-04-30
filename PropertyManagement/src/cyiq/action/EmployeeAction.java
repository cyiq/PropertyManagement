package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Employee;
import cyiq.dao.EmployeeDao;
import cyiq.dao.impl.EmployeeDaoImpl;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private Employee employee = new Employee();
	
	public Employee getModel() {
		return employee;
	}
	public String add(){
		return "add";
	}
	
	public String save(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.save(employee);
		return "tolist";
	}
	
	public String list(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		List<Employee> employeeList = employeeDao.findEmployeesByCondition(employee);
		ServletActionContext.getRequest().setAttribute("employeeList", employeeList);
		return "list";
	}
	
	public String edit(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Employee employee = employeeDao.findEmployeeById(id);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(employee);
		return "edit";
	}
	
	public String update(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.update(employee);
		return "tolist";
	}
	public String delete(){
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		employeeDao.delete(id);
		return "tolist";
	}
}
