package cyiq.dao;

import java.util.List;

import cyiq.bean.Employee;
import cyiq.bean.PublicDevice;

public interface PublicDeviceDao {

	public void save(PublicDevice publicdevice);

	public List<PublicDevice> findAllPublicDevice();
	
	public PublicDevice findPublicDeviceById(Integer deviceId);
	
	public void update(PublicDevice publicdevice);

	public void delete(Integer deviceId);

}
