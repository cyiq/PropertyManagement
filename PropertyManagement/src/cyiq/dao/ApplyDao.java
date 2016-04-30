package cyiq.dao;

import java.util.List;

import cyiq.bean.Apply;

public interface ApplyDao {

	public Apply login(Apply apply);

	public void save(Apply apply);

	public List<Apply> findAllApply();
	
	public List<Apply> findApplysBySid(Integer sid);
	
	public Apply findApplyByApplyId(Integer applyId);

	public void update(Apply apply);

	public void delete(Integer applyId);

}
