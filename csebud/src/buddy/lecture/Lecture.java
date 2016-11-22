package buddy.lecture;

import javax.persistence.Entity;

@Entity
public class Lecture{
	
	String lectureCode;		// 강의의 과목코드
	
	String division;		// 강의의 분반정보(ex. XXXX-01, XXXX-02)
	
	String lectureName;		// 강의의 이름
	
	String professor;		// 강의의 담당교수
	
	String firstWeekday;	// 강의의 첫번째 수업의 요일
	
	String firstStartTime;	// 강의의 첫번째 수업의 시작시간
	
	String firstEndTime;	// 강의의 첫번째 수업의 종료시간
	
	String secondWeekday;	// 강의의 두번째 수업의 요일
	
	String secondStartTime; // 강의의 두번째 수업의 시작시간
	
	String secondEndTime;	// 강의의 두번째 수업의 종료시간
	
	String firstClassroom;	// 강의의 첫번째 수업의 강의실
	
	String secondClassroom;	// 강의의 두번째 수업의 강의실
	
	String credit;			// 강의의 학점
	
	String isEnglish;		// 강의의 영어강의 여부(true/false)
	
	
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
	 * @return the division
	 */
	public String getDivision(){
		return division;
	}
	
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division){
		this.division = division;
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
	 * @return the firstWeekday
	 */
	public String getFirstWeekday(){
		return firstWeekday;
	}
	
	/**
	 * @param firstWeekday the firstWeekday to set
	 */
	public void setFirstWeekday(String firstWeekday){
		this.firstWeekday = firstWeekday;
	}
	
	/**
	 * @return the firstStartTime
	 */
	public String getFirstStartTime(){
		return firstStartTime;
	}
	
	/**
	 * @param firstStartTime the firstStartTime to set
	 */
	public void setFirstStartTime(String firstStartTime){
		this.firstStartTime = firstStartTime;
	}
	
	/**
	 * @return the firstEndTime
	 */
	public String getFirstEndTime(){
		return firstEndTime;
	}
	
	/**
	 * @param firstEndTime the firstEndTime to set
	 */
	public void setFirstEndTime(String firstEndTime){
		this.firstEndTime = firstEndTime;
	}
	
	/**
	 * @return the secondWeekday
	 */
	public String getSecondWeekday(){
		return secondWeekday;
	}
	
	/**
	 * @param secondWeekday the secondWeekday to set
	 */
	public void setSecondWeekday(String secondWeekday){
		this.secondWeekday = secondWeekday;
	}
	
	/**
	 * @return the secondStartTime
	 */
	public String getSecondStartTime(){
		return secondStartTime;
	}
	
	/**
	 * @param secondStartTime the secondStartTime to set
	 */
	public void setSecondStartTime(String secondStartTime){
		this.secondStartTime = secondStartTime;
	}
	
	/**
	 * @return the secondEndTime
	 */
	public String getSecondEndTime(){
		return secondEndTime;
	}
	
	/**
	 * @param secondEndTime the secondEndTime to set
	 */
	public void setSecondEndTime(String secondEndTime){
		this.secondEndTime = secondEndTime;
	}
	
	/**
	 * @return the firstClassroom
	 */
	public String getFirstClassroom(){
		return firstClassroom;
	}
	
	/**
	 * @param firstClassroom the firstClassroom to set
	 */
	public void setFirstClassroom(String firstClassroom){
		this.firstClassroom = firstClassroom;
	}
	
	/**
	 * @return the secondClassroom
	 */
	public String getSecondClassroom(){
		return secondClassroom;
	}
	
	/**
	 * @param secondClassroom the secondClassroom to set
	 */
	public void setSecondClassroom(String secondClassroom){
		this.secondClassroom = secondClassroom;
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
	 * @return the isEnglish
	 */
	public String getIsEnglish(){
		return isEnglish;
	}
	
	/**
	 * @param isEnglish the isEnglish to set
	 */
	public void setIsEnglish(String isEnglish){
		this.isEnglish = isEnglish;
	}
	
}