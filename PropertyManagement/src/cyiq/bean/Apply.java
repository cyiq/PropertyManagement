package cyiq.bean;

public class Apply {
	private Integer applyId;
	private Integer sid;
	private String sname;

	private Integer deviceId;
	private String deviceName;
	private Double devicePrice;
	private Integer applyNumber;
	private Double sumPrice;
	
	
	
	public Double getDevicePrice() {
		return devicePrice;
	}
	public void setDevicePrice(Double devicePrice) {
		this.devicePrice = devicePrice;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getApplyNumber() {
		return applyNumber;
	}
	public void setApplyNumber(Integer applyNumber) {
		this.applyNumber = applyNumber;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
}
