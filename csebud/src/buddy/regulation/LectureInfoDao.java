package buddy.regulation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LectureInfoDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(LectureInfo lectureInfo){
		sqlMapClientTemplate.insert("LectureInfo.add", lectureInfo);
	}
	
	public void update(LectureInfo lectureInfo){
		sqlMapClientTemplate.update("LectureInfo.update", lectureInfo);	
	}
	
	public LectureInfo get(String Lcode){
		return (LectureInfo) sqlMapClientTemplate.queryForObject("LectureInfo.get", Lcode);
	}
	
	@SuppressWarnings("unchecked")
	public List<LectureInfo> list(){
		return sqlMapClientTemplate.queryForList("LectureInfo.list");
	}
	
	public void delete(String Lcode){
		sqlMapClientTemplate.delete("LectureInfo.delete", Lcode);
	}

}