package buddy.timetable;

import javax.persistence.Entity;

@Entity
public class LectureCourse {		// 시간표에 들어가는 LectureCourse 객체
	
	public String LectureInfo; 	// 학수번호
	public String Division; 		// 분반

	public String LectureName; 	// 강의이름
	public String Professor; 		// 교원명

	public String FirstWeek; 		// 첫번째 요일
	public String FirstStartTime; 	// 첫번째 시작시각
	public String FirstEndTime; 	// 첫번째 종료시각

	public String SecondWeek; 		// 두번째 요일
	public String SecondStartTime; // 두번째 시작시각
	public String SecondEndTime; 	// 두번째 종료시각

	public String FirstClassroom; 	// 첫번째 강의실
	public String SecondClassroom; // 두번째 강의실

	public int Credit; 			// 학점
	public String TimetableName;	// 시간표 이름

	/**
	 * @return the LectureInfo
	 */
	public String getLectureInfo(){
		return LectureInfo;
	}
	
	/**
	 * @param LectureInfo the LectureInfo to set
	 */
	public void setLectureInfo(String LectureInfo){
		this.LectureInfo = LectureInfo;
	}
	
	/**
	 * @return the Division
	 */
	public String getDivision(){
		return Division;
	}
	
	/**
	 * @param Division the Division to set
	 */
	public void setDivision(String Division){
		this.Division = Division;
	}
	
	/**
	 * @return the LectureName
	 */
	public String getLectureName(){
		return LectureName;
	}
	
	/**
	 * @param LectureName the LectureName to set
	 */
	public void setLectureName(String LectureName){
		this.LectureName = LectureName;
	}
	
	/**
	 * @return the Professor
	 */
	public String getProfessor(){
		return Professor;
	}
	
	/**
	 * @param Professor the Professor to set
	 */
	public void setProfessor(String Professor){
		this.Professor = Professor;
	}
	
	/**
	 * @return the FirstWeek
	 */
	public String getFirstWeek(){
		return FirstWeek;
	}
	
	/**
	 * @param FirstWeek the FirstWeek to set
	 */
	public void setFirstWeek(String FirstWeek){
		this.FirstWeek = FirstWeek;
	}
	
	/**
	 * @return the FirstStartTime
	 */
	public String getFirstStartTime(){
		return FirstStartTime;
	}
	
	/**
	 * @param FirstStartTime the FirstStartTime to set
	 */
	public void setFirstStartTime(String FirstStartTime){
		this.FirstStartTime = FirstStartTime;
	}
	
	/**
	 * @return the FirstEndTime
	 */
	public String getFirstEndTime(){
		return FirstEndTime;
	}
	
	/**
	 * @param FirstEndTime the FirstEndTime to set
	 */
	public void setFirstEndTime(String FirstEndTime){
		this.FirstEndTime = FirstEndTime;
	}
	
	/**
	 * @return the SecondWeek
	 */
	public String getSecondWeek(){
		return SecondWeek;
	}
	
	/**
	 * @param SecondWeek the SecondWeek to set
	 */
	public void setSecondWeek(String SecondWeek){
		this.SecondWeek = SecondWeek;
	}
	
	/**
	 * @return the SecondStartTime
	 */
	public String getSecondStartTime(){
		return SecondStartTime;
	}
	
	/**
	 * @param SecondStartTime the SecondStartTime to set
	 */
	public void setSecondStartTime(String SecondStartTime){
		this.SecondStartTime = SecondStartTime;
	}
	
	/**
	 * @return the SecondEndTime
	 */
	public String getSecondEndTime(){
		return SecondEndTime;
	}
	
	/**
	 * @param SecondEndTime the SecondEndTime to set
	 */
	public void setSecondEndTime(String SecondEndTime){
		this.SecondEndTime = SecondEndTime;
	}
	
	/**
	 * @return the FirstClassroom
	 */
	public String getFirstClassroom(){
		return FirstClassroom;
	}
	
	/**
	 * @param FirstClassroom the FirstClassroom to set
	 */
	public void setFirstClassroom(String FirstClassroom){
		this.FirstClassroom = FirstClassroom;
	}	
	
	/**
	 * @return the SecondClassroom
	 */
	public String getSecondClassroom(){
		return SecondClassroom;
	}
	
	/**
	 * @param SecondClassroom the SecondClassroom to set
	 */
	public void setSecondClassroom(String SecondClassroom){
		this.SecondClassroom = SecondClassroom;
	}	
	
	/**
	 * @return the Credit
	 */
	public int getCredit(){
		return Credit;
	}
	
	/**
	 * @param Credit the Credit to set
	 */
	public void setCredit(int Credit){
		this.Credit = Credit;
	}	
	
	/**
	 * @return the TimetableName
	 */
	public String getTimetableName(){
		return TimetableName;
	}
	
	/**
	 * @param TimetableName the TimetableName to set
	 */
	public void setTimetableName(String TimetableName){
		this.TimetableName = TimetableName;
	}
	
	
}
