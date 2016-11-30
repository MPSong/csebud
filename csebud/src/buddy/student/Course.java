package buddy.student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	String studentId;	// 강의를 수강한 학생의 학번
	
	String lectureCode;	// 해당되는 강의의 학수번호
	
	String lectureName;	// 해당되는 강의의 강의명
	
	String professor;	// 해당되는 강의의 교수명
	
	String credit;		// 해당되는 강의의 학점
	
	String grade;		// 해당되는 강의의 등급
	
	int isEnglishCourse;// 해당되는 강의의 영어강의 유무
	
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