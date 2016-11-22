package buddy.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import buddy.lecture.Lecture;

@Repository
public class LectureDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(Lecture lecture){
		sqlMapClientTemplate.insert("Lecture.add", lecture);
	}
	
	public void update(Lecture lecture){
		sqlMapClientTemplate.update("Lecture.update", lecture);	
	}
	
	public Lecture get(String lectureCode){
		return (Lecture) sqlMapClientTemplate.queryForObject("Lecture.get", lectureCode);
	}
	
	@SuppressWarnings("unchecked")
	public List<Lecture> list(){
		return sqlMapClientTemplate.queryForList("Lecture.list");
	}
	
	public void delete(String lectureCode){
		sqlMapClientTemplate.delete("Lecture.delete", lectureCode);
	}

}