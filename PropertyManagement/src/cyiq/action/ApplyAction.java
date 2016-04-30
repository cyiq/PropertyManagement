package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Apply;
import cyiq.bean.PublicDevice;
import cyiq.bean.Student;
import cyiq.dao.ApplyDao;
import cyiq.dao.PublicDeviceDao;
import cyiq.dao.StudentDao;
import cyiq.dao.impl.ApplyDaoImpl;
import cyiq.dao.impl.PublicDeviceDaoImpl;
import cyiq.dao.impl.StudentDaoImpl;

public class ApplyAction extends ActionSupport implements ModelDriven<Apply>{
	private Apply apply = new Apply();
	
	public Apply getModel() {
		return apply;
	}
	public String add(){
		StudentDao studentDao = new StudentDaoImpl();
		PublicDeviceDao publicDeviceDao = new PublicDeviceDaoImpl();
		Integer deviceId = Integer.parseInt(ServletActionContext.getRequest().getParameter("deviceId"));
		String loginName = ServletActionContext.getRequest().getParameter("loginName");
		Student student = studentDao.findStudentByLoginName(loginName);
		PublicDevice publicDevice = publicDeviceDao.findPublicDeviceById(deviceId);
		
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(student);
		valueStack.push(publicDevice);
		
		return "add";
	}
	
	public String save(){
		ApplyDao ApplyDao = new ApplyDaoImpl();
		ApplyDao.save(apply);
		return "tolist";
	}
	
	public String list(){
		ApplyDao applyDao = new ApplyDaoImpl();
		Integer sid = (Integer) ServletActionContext.getContext().getSession().get("sid");
		List<Apply> applyList = applyDao.findApplysBySid(sid);
		ServletActionContext.getRequest().setAttribute("applyList", applyList);
		return "list";
	}
	
	public String listAll(){
		ApplyDao applyDao = new ApplyDaoImpl();
		List<Apply> applyList = applyDao.findAllApply();
		ServletActionContext.getRequest().setAttribute("applyList", applyList);
		return "listAll";
	}
	
	public String edit(){
		ApplyDao applyDao = new ApplyDaoImpl();
		Integer applyId = Integer.parseInt(ServletActionContext.getRequest().getParameter("applyId"));
		Apply newApply = applyDao.findApplyByApplyId(applyId);
		Integer sessionSid = (Integer) ServletActionContext.getContext().getSession().get("sid");
		if(newApply.getSid()!=sessionSid){
			this.addFieldError("error", "你没有操作这个申请的权限！");
			return "input";
		}
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(newApply);
		return "edit";
	}
	
	public String adminEdit(){
		ApplyDao applyDao = new ApplyDaoImpl();
		Integer applyId = Integer.parseInt(ServletActionContext.getRequest().getParameter("applyId"));
		Apply newApply = applyDao.findApplyByApplyId(applyId);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(newApply);
		return "edit";
	}
	
	public String update(){
		ApplyDao ApplyDao = new ApplyDaoImpl();
		ApplyDao.update(apply);
		Boolean isStudent = (Boolean)ServletActionContext.getContext().getSession().get("isStudent");
		if(isStudent){
			return "tolist";
		}else{
			return "tolistAll";
		}
	}
	public String delete(){
		Integer applyId = Integer.parseInt(ServletActionContext.getRequest().getParameter("applyId"));
		ApplyDao ApplyDao = new ApplyDaoImpl();
		ApplyDao.delete(applyId);
		return "tolist";
	}
}
