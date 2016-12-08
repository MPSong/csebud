package buddy.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(Course course){
		sqlMapClientTemplate.insert("Course.add", course);
	}
	
	public void update(Course course){
		sqlMapClientTemplate.update("Course.update", course);	
	}
	
	public Course get(String lectureName){
		return (Course) sqlMapClientTemplate.queryForObject("Course.get", lectureName);
	}
	
	@SuppressWarnings("unchecked")
	public List<Course> list(){
		return sqlMapClientTemplate.queryForList("Course.list");
	}
	
	public void delete(String lectureName){
		sqlMapClientTemplate.delete("Course.delete", lectureName);
	}

}