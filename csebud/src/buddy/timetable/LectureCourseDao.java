package buddy.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LectureCourseDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(LectureCourse lectureCourse){
		sqlMapClientTemplate.insert("Course.add", lectureCourse);
	}
	
	public void update(LectureCourse lectureCourse){
		sqlMapClientTemplate.update("Course.update", lectureCourse);	
	}
	
	public LectureCourse get(String TimetableName){
		return (LectureCourse) sqlMapClientTemplate.queryForObject("LectureCourse.get", TimetableName);
	}
	
	@SuppressWarnings("unchecked")
	public List<LectureCourse> list(){
		return sqlMapClientTemplate.queryForList("LectureCourse.list");
	}
	
	public void delete(String TimetableName){
		sqlMapClientTemplate.delete("LectureCourse.delete", TimetableName);
	}

}