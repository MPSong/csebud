package buddy.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LectureCourseService {
	
	@Autowired LectureCourseDao dao;
	
	public void add(LectureCourse lectureCourse){
		dao.add(lectureCourse);
	}
	
	public void update(LectureCourse lectureCourse){
		dao.update(lectureCourse);
	}
	
	public LectureCourse get(String lectureInfo){
		return dao.get(lectureInfo);
	}
	
	public List<LectureCourse> list(){
		return dao.list();
	}
	
	public void delete(String lectureInfo){
		dao.delete(lectureInfo);
	}
	
}