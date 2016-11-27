package buddy.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentManager {
	
	@Autowired StudentInfoDao s_dao;
	@Autowired CourseDao c_dao;
	
	// 학생 정보에 관한 Dao 연결
	
	public void s_add(StudentInfo studentInfo){
		s_dao.add(studentInfo);
	}
	
	public void s_update(StudentInfo studentInfo){
		s_dao.update(studentInfo);
	}
	
	public StudentInfo s_get(String studentId){
		return s_dao.get(studentId);
	}

	public List<StudentInfo> s_list(){
		return s_dao.list();
	}
	
	public void s_delete(String studentId){
		s_dao.delete(studentId);
	}
	
	
	// 학생이 가지는 수강 정보에 관한 Dao 연결
	
	public void c_add(Course course){
		c_dao.add(course);
	}
	
	public void c_update(Course course){
		c_dao.update(course);
	}
	
	public Course c_get(String studentId){
		return c_dao.get(studentId);
	}

	public List<Course> c_list(){
		return c_dao.list();
	}
	
	public void c_delete(String studentId){
		c_dao.delete(studentId);
	}
	
}