package buddy.timetable;

import java.util.ArrayList;
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
	
	public LectureCourse get(String TimetableName){
		return dao.get(TimetableName);
	}
	
	public List<LectureCourse> list(){
		return dao.list();
	}
	
	public List<LectureCourse> listByName(String TimetableName){
		
		// 결과 리스트에서 매개변수와 일치하는 리스트 반환
		List<LectureCourse> resultset = new ArrayList<LectureCourse>();
		List<LectureCourse> templist = new ArrayList<LectureCourse>();
		LectureCourse templec = new LectureCourse();
		templist.addAll(dao.list());
		for (int i = 0; i < templist.size(); i++) {
			if(templist.get(i).getTimetableName().equals(TimetableName)){
				templec = templist.get(i);
				resultset.add(templec);
			}		
		}
		return resultset;
		
	}
	
	public void delete(String TimetableName){
		dao.delete(TimetableName);
	}
	
}