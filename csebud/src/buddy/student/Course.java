package buddy.student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	String studentId;
	
	String lectureCode;
	
	String credit;
	
	String grade;
	
	int isEnglishCourse;
	
	/**
	 * @return the studentId
	 */
	public String getStudentId(){
		return studentId;
	}
	
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId){
		this.studentId = studentId;
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
	 * @return the credit
	 */
	public String getCredit(){
		return credit;
	}
	
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit){
		this.credit = credit;
	}
	
	/**
	 * @return the grade
	 */
	public String getGrade(){
		return grade;
	}
	
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade){
		this.grade = grade;
	}
	
	/**
	 * @return the isEnglishCourse
	 */
	public int getIsEnglishCourse(){
		return isEnglishCourse;
	}
	
	/**
	 * @param isEnglishCourse the isEnglishCourse to set
	 */
	public void setIsEnglishCourse(int isEnglishCourse){
		this.isEnglishCourse = isEnglishCourse;
	}
	
}

/*package buddy.student;

public class Course {

	private String StudentId;	// 해당 강의목록을 가지는 학생의 학번
	private String LectureCode;   //강의 코드
	private String Credit; //학점
	private String Grade;  //받은 등급
	private boolean IsEnglishCourse;  //영어강의여부
	   
	public Course(String StudentId, String LectureCode, String Credit, String Grade, boolean IsEnglishCourse){
		this.StudentId = StudentId;
		this.LectureCode = LectureCode;
		this.Credit = Credit;
		this.Grade = Grade;
		this.IsEnglishCourse = IsEnglishCourse;
	}   
	      
	public String getStudentId() {
		return StudentId;
	}
	
	public String getLectureCode() {
		return LectureCode;
	}
	   
	public String getCredit(){
		return Credit;
	}
	
	public String getGrade() {
		return Grade;
	}
	
	public boolean getIsEnglishCourse(){
		return IsEnglishCourse;
	}
	   
}*/
