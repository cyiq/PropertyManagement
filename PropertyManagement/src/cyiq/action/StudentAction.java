package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Employee;
import cyiq.bean.Student;
import cyiq.dao.EmployeeDao;
import cyiq.dao.StudentDao;
import cyiq.dao.impl.EmployeeDaoImpl;
import cyiq.dao.impl.StudentDaoImpl;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	
	public Student getModel() {
		return student;
	}
	public String add(){
		return "add";
	}
	
	public String save(){
		StudentDao StudentDao = new StudentDaoImpl();
		StudentDao.save(student);
		return "tolist";
	}
	
	public String list(){
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> studentList = studentDao.findStudentsByCondition(student);
		ServletActionContext.getRequest().setAttribute("studentList", studentList);
		return "list";
	}
	
	public String edit(){
		StudentDao studentDao = new StudentDaoImpl();
		Integer sid = Integer.parseInt(ServletActionContext.getRequest().getParameter("sid"));
		Student student = studentDao.findStudentById(sid);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(student);
		return "edit";
	}
	
	public String update(){
		StudentDao StudentDao = new StudentDaoImpl();
		StudentDao.update(student);
		return "tolist";
	}
	public String delete(){
		Integer sid = Integer.parseInt(ServletActionContext.getRequest().getParameter("sid"));
		StudentDao StudentDao = new StudentDaoImpl();
		StudentDao.delete(sid);
		return "tolist";
	}
}
