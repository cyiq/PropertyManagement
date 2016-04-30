package cyiq.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.Notice;
import cyiq.dao.NoticeDao;
import cyiq.dao.impl.NoticeDaoImpl;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {
	
	private Notice notice = new Notice();

	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		return notice;
	}
	
	public String saveUI(){
		return "tobackgroup";
	}
	
	public String findAll(){
		NoticeDao noticeDao = new NoticeDaoImpl();
		List<Notice> noticeList = noticeDao.findAllNotice();
		ServletActionContext.getContext().getSession().put("noticeList", noticeList);
		return "home";
	}
	
	public String save(){
		NoticeDao noticeDao = new NoticeDaoImpl();
		noticeDao.saveNotice(notice);
		return "action2action";
	}
	
	public String editUI(){
		NoticeDao noticeDao = new NoticeDaoImpl();
		Integer noticeId = Integer.parseInt(ServletActionContext.getRequest().getParameter("noticeId"));
		Notice notice = noticeDao.findNoticeById(noticeId);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(notice);
		return "editUI";
	}
	
	public String edit(){
		NoticeDao noticeDao = new NoticeDaoImpl();
		noticeDao.updateNotice(notice);
		return "action2action";
	}
	public String delete(){
		NoticeDao noticeDao = new NoticeDaoImpl();
		Integer noticeId = Integer.parseInt(ServletActionContext.getRequest().getParameter("noticeId"));
		noticeDao.deleteNoticeById(noticeId);
		List<Notice> noticeList = noticeDao.findAllNotice();
		ServletActionContext.getContext().getSession().put("noticeList", noticeList);
		return "delete";
	}
}
