package rule;

public class Lecture {

	String lectureCode;
	String lectureTitle;
	int credit;
	String type;
	
	//getter setter
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	public int getCredit() {
		return credit;
	}
}
