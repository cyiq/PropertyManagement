package cyiq.bean;

import java.io.Serializable;

public class Notice implements Serializable {
	private Integer noticeId;
	
	private String noticeDate;
	
	private String noticeTitle;
	
	private String noticeContent;

	public Integer getNoticeId() {
		return noticeId;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeDate=" + noticeDate
				+ ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + "]";
	}
}
