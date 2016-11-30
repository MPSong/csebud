package buddy.regulation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegulationInfoService {
	
	@Autowired RegulationInfoDao dao;
	
	public void add(RegulationInfo regulationInfo){
		dao.add(regulationInfo);
	}
	
	public void update(RegulationInfo regulationInfo){
		dao.update(regulationInfo);
	}
	
	public RegulationInfo get(String year){
		return dao.get(year);
	}

	
	public List<RegulationInfo> list(){
		return dao.list();
	}
	
	public void delete(String year){
		dao.delete(year);
	}
	
}