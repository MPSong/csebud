package buddy.review;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import buddy.lecture.Lecture;

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
	
	public LectureReview get(String lectureName){
		return dao.get(lectureName);
	}
	
	public List<LectureReview> list(){
		return dao.list();
	}
	
	public void delete(String lectureName){
		dao.delete(lectureName);
	}
	
	public List<LectureReview> getSearchItems(String keywords){
		
		List<LectureReview> list =  dao.list();
		List<LectureReview> resultSet = new ArrayList<LectureReview>();

		Pattern p = Pattern.compile(keywords);
		Matcher m;
		int a;
		
		// 검색된 키워드에 대해서 패턴 매칭 알고리즘 수행
		for (int i = 0; i < list.size(); i++) {
			
			m = p.matcher(list.get(i).getLectureName());
			
			a = 0;
			
			if(m.find()){
				a++;
			}
			
			if (a==1) {
				LectureReview lec = new LectureReview();
				lec = list.get(i);
				resultSet.add(lec);
			}	
			
		}
		
		return resultSet;
	}
	
}