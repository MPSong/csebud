package buddy.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LectureReviewManager {
	
	@Autowired LectureReviewDao dao;
	
	public void add(LectureReview lectureReview){
		dao.add(lectureReview);
	}
	
	public void update(LectureReview lectureReview){
		dao.update(lectureReview);
	}
	
	public LectureReview get(int reviewCode){
		return dao.get(reviewCode);
	}
	
	public List<LectureReview> list(){
		return dao.list();
	}
	
	public void delete(int reviewCode){
		dao.delete(reviewCode);
	}
	
}