package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Employee;
import cyiq.bean.PublicDevice;
import cyiq.dao.EmployeeDao;
import cyiq.dao.PublicDeviceDao;
import cyiq.dao.impl.EmployeeDaoImpl;
import cyiq.dao.impl.PublicDeviceDaoImpl;

public class PublicDeviceAction extends ActionSupport implements ModelDriven<PublicDevice>{
	private PublicDevice publicDevice = new PublicDevice();
	
	public PublicDevice getModel() {
		return publicDevice;
	}
	public String add(){
		return "add";
	}
	
	public String save(){
		PublicDeviceDao PublicDeviceDao = new PublicDeviceDaoImpl();
		PublicDeviceDao.save(publicDevice);
		return "tolist";
	}
	
	public String list(){
		PublicDeviceDao publicDeviceDao = new PublicDeviceDaoImpl();
		List<PublicDevice> publicDeviceList = publicDeviceDao.findAllPublicDevice();
		ServletActionContext.getRequest().setAttribute("publicDeviceList", publicDeviceList);
		return "list";
	}
	
	public String edit(){
		PublicDeviceDao publicDeviceDao = new PublicDeviceDaoImpl();
		Integer deviceId = Integer.parseInt(ServletActionContext.getRequest().getParameter("deviceId"));
		PublicDevice publicDevice = publicDeviceDao.findPublicDeviceById(deviceId);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(publicDevice);
		return "edit";
	}
	
	public String update(){
		PublicDeviceDao PublicDeviceDao = new PublicDeviceDaoImpl();
		PublicDeviceDao.update(publicDevice);
		return "tolist";
	}
	public String delete(){
		Integer deviceId = Integer.parseInt(ServletActionContext.getRequest().getParameter("deviceId"));
		PublicDeviceDao PublicDeviceDao = new PublicDeviceDaoImpl();
		PublicDeviceDao.delete(deviceId);
		return "tolist";
	}
}
