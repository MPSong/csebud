package buddy.student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentInfo {
	
	@Id
	String studentId;
	
	String year;
	
	String semester;
	
	String englishTrack;
	
	String memberId;
	
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
	 * @return the year
	 */
	public String getYear(){
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * @return the semester
	 */
	public String getSemester(){
		return semester;
	}
	
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester){
		this.semester = semester;
	}
	
	/**
	 * @return the englishTrack
	 */
	public String getEnglishTrack(){
		return englishTrack;
	}
	
	/**
	 * @param englishTrack the englishTrack to set
	 */
	public void setEnglishTrack(String englishTrack){
		this.englishTrack = englishTrack;
	}
	
	/**
	 * @return the memberId
	 */
	public String getMemberId(){
		return memberId;
	}
	
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	
}