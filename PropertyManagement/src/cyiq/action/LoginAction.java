package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Employee;
import cyiq.bean.Notice;
import cyiq.dao.EmployeeDao;
import cyiq.dao.NoticeDao;
import cyiq.dao.impl.EmployeeDaoImpl;
import cyiq.dao.impl.NoticeDaoImpl;

public class LoginAction extends ActionSupport implements ModelDriven<Employee>{
	private Employee employee = new Employee();
	
	public Employee getModel() {
		return employee;
	}
	
	public String home(){
		ServletActionContext.getContext().getSession().clear();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee newemployee = employeeDao.login(employee);
		if(newemployee == null || newemployee.equals("")){
			this.addFieldError("error", "用户名不存在或密码错误");
			return "input";
		}
		ServletActionContext.getContext().getSession().put("userName", newemployee.getUserName());
		ServletActionContext.getContext().getSession().put("isStudent", false);
		if(newemployee.getIsManager().equals(1)){
			ServletActionContext.getContext().getSession().put("isManager",true);
		}else{
			ServletActionContext.getContext().getSession().put("isManager",false);
		}
		ServletActionContext.getContext().getSession().put("loginName", newemployee.getLoginName());
		ServletActionContext.getContext().getSession().put("id", newemployee.getId());
		//公告显示
		NoticeDao noticeDao = new NoticeDaoImpl();
		List<Notice> noticeList = noticeDao.findAllNotice();
		ServletActionContext.getContext().getSession().put("noticeList",noticeList);
 		return "home";
	}
}
