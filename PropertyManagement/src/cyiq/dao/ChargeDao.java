package cyiq.dao;

import java.util.List;

import cyiq.bean.Charge;

public interface ChargeDao {

	public void save(Charge charge);

	public List<Charge> findAllCharge();
	
	public List<Charge> findChargesBySid(Integer sid);

}
