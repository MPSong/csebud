package buddy.lecture;

import java.util.ArrayList;
import buddy.lecture.LectureReview;

public class Lecture{
	
	private int lectureCode;
	private String lectureTitle;
	private String professorName;
	private ArrayList<LectureReview> reviews;
	
	// getter / setter 메서드
	public int getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(int lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public ArrayList<LectureReview> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<LectureReview> reviews) {
		this.reviews = reviews;
	}
	
	
}