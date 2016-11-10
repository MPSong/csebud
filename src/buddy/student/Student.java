package buddy.student;

import java.util.ArrayList;
import buddy.timetable.Timetable;
import buddy.course.Course;

public class Student{
	
	private String studentId;
	private String studentName;
	private ArrayList<Integer> reviewsWritten;
	private ArrayList<Timetable> myTimetables;
	private int creditsTaken;
	private ArrayList<Course> courses;
	
	// getter / setter 메서드
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ArrayList<Integer> getReviewsWritten() {
		return reviewsWritten;
	}
	public void setReviewsWritten(ArrayList<Integer> reviewsWritten) {
		this.reviewsWritten = reviewsWritten;
	}
	public ArrayList<Timetable> getMyTimetables() {
		return myTimetables;
	}
	public void setMyTimetables(ArrayList<Timetable> myTimetables) {
		this.myTimetables = myTimetables;
	}
	public int getCreditsTaken() {
		return creditsTaken;
	}
	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}