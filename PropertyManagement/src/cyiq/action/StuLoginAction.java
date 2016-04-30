package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cyiq.bean.Notice;
import cyiq.bean.Student;
import cyiq.dao.NoticeDao;
import cyiq.dao.StudentDao;
import cyiq.dao.impl.NoticeDaoImpl;
import cyiq.dao.impl.StudentDaoImpl;

public class StuLoginAction extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	
	public Student getModel() {
		return student;
	}
	public String home(){
		ServletActionContext.getContext().getSession().clear();
		StudentDao studentDao = new StudentDaoImpl();
		Student newstudent = studentDao.login(student);
		if(newstudent == null || newstudent.equals("")){
			this.addFieldError("error", "用户名不存在或密码错误");
			return "input";
		}
		ServletActionContext.getContext().getSession().put("userName", newstudent.getSname());
		ServletActionContext.getContext().getSession().put("sid", newstudent.getSid());
		ServletActionContext.getContext().getSession().put("isStudent", true);
		ServletActionContext.getContext().getSession().put("loginName", newstudent.getLoginName());
		//公告显示
		NoticeDao noticeDao = new NoticeDaoImpl();
		List<Notice> noticeList = noticeDao.findAllNotice();
		ServletActionContext.getContext().getSession().put("noticeList",noticeList);
 		return "home";
	}
}
