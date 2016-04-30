package cyiq.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Employee;
import cyiq.bean.Student;
import cyiq.dao.EmployeeDao;
import cyiq.dao.StudentDao;
import cyiq.dao.impl.EmployeeDaoImpl;
import cyiq.dao.impl.StudentDaoImpl;
import cyiq.utils.SplitUtils;

public class MessageAction extends ActionSupport {
	
	private String message;
	private String smessage;
	private Integer id;
	private Integer sid;

	public Integer getId() {
		return id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getMessage() {
		return message;
	}

	public String getSmessage() {
		return smessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSmessage(String smessage) {
		this.smessage = smessage;
	}

	public String list(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee employee = new Employee();
		Student student = new Student();
		//判断是否显示的是学生的消息或者是员工的消息
		Boolean showStudentMessage;
		List<Employee> employeeList = employeeDao.findEmployeesByCondition(new Employee());

		StudentDao studentDao = new StudentDaoImpl();
		List<Student> studentList = studentDao.findStudentsByCondition(new Student());
		
		ServletActionContext.getRequest().setAttribute("employeeList", employeeList);
		ServletActionContext.getRequest().setAttribute("studentList", studentList);
		//显示自己的消息
		Object sid = ServletActionContext.getContext().getSession().get("sid");
		SplitUtils splitstring = new SplitUtils();
		if(sid!=null){
			showStudentMessage = true;
			ServletActionContext.getRequest().setAttribute("showStudentMessage", showStudentMessage);
			Integer newSid = (Integer) sid;
			Student newStudent = studentDao.findStudentById(newSid);
			if(StringUtils.isNotBlank(newStudent.getSmessage())){
				List<List<String>> listMessage = splitstring.splitName(newStudent.getSmessage());
				ServletActionContext.getRequest().setAttribute("listMessage", listMessage);
			}
		}else{
			Integer id = (Integer) ServletActionContext.getContext().getSession().get("id");
			Employee newEmployee = employeeDao.findEmployeeById(id);
			if(StringUtils.isNotBlank(newEmployee.getMessage())){
				List<List<String>> listMessage = splitstring.splitName(newEmployee.getMessage());
				ServletActionContext.getRequest().setAttribute("listMessage", listMessage);
			}
		}
		return "list";
	}
	
	public String setMessage(){
		Boolean toStudentMessage;
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		StudentDao studentDao = new StudentDaoImpl();
		String sid = ServletActionContext.getRequest().getParameter("sid");
		if(sid!=null){
			toStudentMessage = true;
			ServletActionContext.getRequest().setAttribute("toStudentMessage", toStudentMessage);
			Student student = new Student();
			Integer newSid = Integer.parseInt(sid);
			student = studentDao.findStudentById(newSid);
			ServletActionContext.getContext().put("sid", student.getSid());
		}else{
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Employee employee = new Employee();
		employee = employeeDao.findEmployeeById(id);
		ServletActionContext.getContext().put("id", employee.getId());
		}
		return "editMessage";
	}
	
	public String updateEmployeeMessage(){
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee employee = new Employee();
		employee = employeeDao.findEmployeeById(id);
		String loginName = (String) ServletActionContext.getContext().getSession().get("loginName");
		if(employee.getMessage()==null){
			String newMessage = loginName+":"+message;
			employee.setMessage(newMessage);
		}
		else{
			String newMessage = loginName+":"+message+"bobo"+employee.getMessage();
			employee.setMessage(newMessage);
		}
		employeeDao.update(employee);
		return "action2action";
	}
	public String updateStudentMessage(){
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		student = studentDao.findStudentById(sid);
		String loginName = (String) ServletActionContext.getContext().getSession().get("loginName");
		if(student.getSmessage()==null){
			String newMessage = loginName+":"+smessage;
			student.setSmessage(newMessage);
		}
		else{
			String newMessage = loginName+":"+smessage+"bobo"+student.getSmessage();
			student.setSmessage(newMessage);
		}
		studentDao.update(student);
		return "action2action";
	}
	public String delete(){
		Object sid = ServletActionContext.getContext().getSession().get("sid");
		SplitUtils splitstring = new SplitUtils();
		if(sid!=null){
			Integer newSid = (Integer) sid;
			StudentDao studentDao = new StudentDaoImpl();
			Integer mid = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
			Student student = studentDao.findStudentById(newSid);
			List<List<String>> listMessage = splitstring.splitName(student.getSmessage());
			listMessage.remove(mid.intValue());
			String newMessage = splitstring.toMessage(listMessage);
			student.setSmessage(newMessage);
			studentDao.update(student);
		}else{
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			Integer id = (Integer) ServletActionContext.getContext().getSession().get("id");
			Integer mid = Integer.parseInt(ServletActionContext.getRequest().getParameter("mid"));
			Employee employee = employeeDao.findEmployeeById(id);
			List<List<String>> listMessage = splitstring.splitName(employee.getMessage());
			listMessage.remove(mid.intValue());
			String newMessage = splitstring.toMessage(listMessage);
			employee.setMessage(newMessage);
			employeeDao.update(employee);
		}
		return "action2action";
}
}