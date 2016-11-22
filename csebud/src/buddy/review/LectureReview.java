package buddy.review;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LectureReview{
	
	@Id
	int reviewCode;		// 해당 강의평가의 코드번호
	
	String writerId;	// 해당 강의평가의 작성자 아이디
	
	String content;		// 해당 강의평가의 내용
	
	String writtenTime;	// 해당 강의평가의 작성시간
	
	String lectureCode;	// 해당 강의평가에 해당하는 강의코드
	
	String lectureName; // 해당 강의평가에 해당하는 강의이름
	
	String professor;	// 해당 강의평가에 해당하는 교수이름
	
	int starval;		// 해당 강의평가의 별점(1~10 : 점수 1점당 별 반개로 채점하며, 만점은 별 다섯개)

	
	/**
	 * @return the reviewCode
	 */
	public int getReviewCode(){
		return reviewCode;
	}
	
	/**
	 * @param reviewCode the reviewCode to set
	 */
	public void setReviewCode(int reviewCode){
		this.reviewCode = reviewCode;
	}
	
	/**
	 * @return the writerId
	 */
	public String getWriterId(){
		return writerId;
	}
	
	/**
	 * @param writerId the writerId to set
	 */
	public void setWriterId(String writerId){
		this.writerId = writerId;
	}
	
	/**
	 * @return the content
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 * @return the writtenTime
	 */
	public String getWrittenTime(){
		return writtenTime;
	}
	
	/**
	 * @param writtenTime the writtenTime to set
	 */
	public void setWrittenTime(String writtenTime){
		this.writtenTime = writtenTime;
	}
	
	/**
	 * @return the lectureCode
	 */
	public String getLectureCode(){
		return lectureCode;
	}
	
	/**
	 * @param lectureCode the lectureCode to set
	 */
	public void setLectureCode(String lectureCode){
		this.lectureCode = lectureCode;
	}
	
	/**
	 * @return the lectureName
	 */
	public String getLectureName(){
		return lectureName;
	}
	
	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName){
		this.lectureName = lectureName;
	}
	
	/**
	 * @return the professor
	 */
	public String getProfessor(){
		return professor;
	}
	
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(String professor){
		this.professor = professor;
	}
	
	/**
	 * @return the starval
	 */
	public int getStarval(){
		return starval;
	}
	
	/**
	 * @param starval the starval to set
	 */
	public void setStarval(int starval){
		this.starval = starval;
	}
	
}