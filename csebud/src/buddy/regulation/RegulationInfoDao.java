package buddy.regulation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegulationInfoDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(RegulationInfo regulationInfo){
		sqlMapClientTemplate.insert("RegulationInfo.add", regulationInfo);
	}
	
	public void update(RegulationInfo regulationInfo){
		sqlMapClientTemplate.update("RegulationInfo.update", regulationInfo);	
	}
	
	public RegulationInfo get(String year){
		return (RegulationInfo) sqlMapClientTemplate.queryForObject("RegulationInfo.get", year);
	}
	
	@SuppressWarnings("unchecked")
	public List<RegulationInfo> list(){
		return sqlMapClientTemplate.queryForList("RegulationInfo.list");
	}
	
	public void delete(String year){
		sqlMapClientTemplate.delete("RegulationInfo.delete", year);
	}

}