package buddy.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LectureReviewDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(LectureReview lectureReview){
		sqlMapClientTemplate.insert("LectureReview.add", lectureReview);
	}
	
	public void update(LectureReview lectureReview){
		sqlMapClientTemplate.update("LectureReview.update", lectureReview);	
	}
	
	public LectureReview get(String lectureName){
		return (LectureReview) sqlMapClientTemplate.queryForObject("LectureReview.get", lectureName);
	}
	
	@SuppressWarnings("unchecked")
	public List<LectureReview> list(){
		return sqlMapClientTemplate.queryForList("LectureReview.list");
	}
	
	public void delete(String lectureName){
		sqlMapClientTemplate.delete("LectureReview.delete", lectureName);
	}

}
