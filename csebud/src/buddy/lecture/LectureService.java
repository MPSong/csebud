package buddy.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import buddy.lecture.Lecture;

@Service
@Transactional
public class LectureService {
	
	@Autowired LectureDao dao;
	
	public void add(Lecture lecture){
		dao.add(lecture);
	}
	
	public void update(Lecture lecture){
		dao.update(lecture);
	}
	
	public Lecture get(String lectureCode){
		return dao.get(lectureCode);
	}

	
	public List<Lecture> list(){
		return dao.list();
	}
	
	public void delete(String lectureCode){
		dao.delete(lectureCode);
	}
	
}
