package buddy.lecture;

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
	
	public List<Lecture> getSearchItems(String keywords){
		
		List<Lecture> list =  dao.list();
		List<Lecture> resultSet = new ArrayList<Lecture>();
		
		/*
		// 검색된 키워드에 대해서 패턴 매칭 알고리즘 수행
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getLectureName().contains(keywords)) {
				resultSet.add(list.get(i));
			}	
			
		}
		
		return resultSet;
		*/

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
				Lecture lec = new Lecture();
				lec = list.get(i);
				resultSet.add(lec);
			}	
			
		}
		System.out.println(Integer.toString(resultSet.size())+"크기");
		return resultSet;
	}
	
}
