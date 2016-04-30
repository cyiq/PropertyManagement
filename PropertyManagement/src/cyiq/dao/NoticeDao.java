package cyiq.dao;

import java.util.List;

import cyiq.bean.Notice;

public interface NoticeDao {

	public List<Notice> findAllNotice();
	public void saveNotice(Notice notice);
	public Notice findNoticeById(Integer noticeId);
	public void updateNotice(Notice notice);
	public void deleteNoticeById(Integer noticeId);
}
