package cyiq.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;	

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cyiq.bean.Apply;
import cyiq.bean.Charge;
import cyiq.bean.PublicDevice;
import cyiq.bean.Student;
import cyiq.dao.ApplyDao;
import cyiq.dao.ChargeDao;
import cyiq.dao.PublicDeviceDao;
import cyiq.dao.StudentDao;
import cyiq.dao.impl.ApplyDaoImpl;
import cyiq.dao.impl.ChargeDaoImpl;
import cyiq.dao.impl.PublicDeviceDaoImpl;
import cyiq.dao.impl.StudentDaoImpl;

public class ChargeAction extends ActionSupport implements ModelDriven<Charge>{
	private Charge charge = new Charge();
	
	public Charge getModel() {
		return charge;
	}
	
	public String save(){
		//<a href="${pageContext.request.contextPath}/charge/ChargeAction_save.do?applyId=/>&sid=&deviceId=">
		ApplyDao applyDao = new ApplyDaoImpl();
		StudentDao studentDao = new StudentDaoImpl();
		PublicDeviceDao publicDeviceDao = new PublicDeviceDaoImpl();
		ChargeDao chargeDao = new ChargeDaoImpl();
		
		Integer applyId = Integer.parseInt(ServletActionContext.getRequest().getParameter("applyId"));
		Integer sid = Integer.parseInt(ServletActionContext.getRequest().getParameter("sid"));
		Integer deviceId = Integer.parseInt(ServletActionContext.getRequest().getParameter("deviceId"));
		
		Apply apply = applyDao.findApplyByApplyId(applyId);
		Student student = studentDao.findStudentById(sid);
		PublicDevice publicDevice = publicDeviceDao.findPublicDeviceById(deviceId);
		
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String chargeDate = sf.format(date);
		
		charge.setSid(student.getSid());
		charge.setSname(student.getSname());
		charge.setApplyId(apply.getApplyId());
		charge.setDeviceId(publicDevice.getDeviceId());
		charge.setDeviceName(publicDevice.getDeviceName());;
		charge.setLoginName(student.getLoginName());
		charge.setDevicePrice(publicDevice.getDevicePrice());
		charge.setApplyNumber(apply.getApplyNumber());
		charge.setSumPrice(apply.getSumPrice());
		charge.setDate(chargeDate);
		
		chargeDao.save(charge);
		applyDao.delete(applyId);
		return "tolist";	
	}
	
	public String list(){
		ChargeDao chargeDao = new ChargeDaoImpl();
		List<Charge> chargeList = chargeDao.findAllCharge();
		ServletActionContext.getRequest().setAttribute("chargeList", chargeList);
		return "list";
	}
	
}
