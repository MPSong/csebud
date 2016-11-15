package buddy.timetable;

import java.util.ArrayList;

public class Timetable{
	
	private ArrayList<Integer> lectureCode;
	private ArrayList<String> lectureTitle;
	private ArrayList<String> lectureTime;
	
	public String getLecTime(int lectureCode){
		return null;
	}

	// getter / setter 메서드
	public ArrayList<Integer> getLectureCode() {
		return lectureCode;
	}

	public void setLectureCode(ArrayList<Integer> lectureCode) {
		this.lectureCode = lectureCode;
	}

	public ArrayList<String> getLectureTitle() {
		return lectureTitle;
	}

	public void setLectureTitle(ArrayList<String> lectureTitle) {
		this.lectureTitle = lectureTitle;
	}

	public ArrayList<String> getLectureTime() {
		return lectureTime;
	}

	public void setLectureTime(ArrayList<String> lectureTime) {
		this.lectureTime = lectureTime;
	}
	
}