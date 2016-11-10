package buddy.course;

public class Course{
	
	private int lectureCode; // 학생의 수강한 강의 번호
	private String credit;	 // 학생의 수강한 강의의 학점(A~F)
	
	// getter / setter 메서드
	public int getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(int lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
}