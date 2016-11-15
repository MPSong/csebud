package buddy.graduation;

import java.util.ArrayList;

import buddy.graduation.GraduationRequirements;
import buddy.student.Student;
import buddy.student.StudentManager;
import buddy.lecture.Lecture;
import buddy.regulation.Regulation;

public class GraduationManager{
	
	private GraduationRequirements grdReq;
	private StudentManager studentManager;
	private ArrayList<Lecture> presentSemLec;
	private Student student;
	private Regulation regulation;
	
	// 아직 구현되지 않은 메서드들
	public void setUserInfo(GraduationRequirements grdReq, int studentId){}
	public void parseGrdReq(){}
	public void recommendLecture(){}
	public void calculateCredits(){}
	public void retrieveNeededCourse(){}
	public void retrieveRequiredInfo(){}
	
	// getter / setter 메서드들
	public GraduationRequirements getGrdReq() {
		return grdReq;
	}
	public void setGrdReq(GraduationRequirements grdReq) {
		this.grdReq = grdReq;
	}
	public StudentManager getStudentManager() {
		return studentManager;
	}
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
	public ArrayList<Lecture> getPresentSemLec() {
		return presentSemLec;
	}
	public void setPresentSemLec(ArrayList<Lecture> presentSemLec) {
		this.presentSemLec = presentSemLec;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Regulation getRegulation() {
		return regulation;
	}
	public void setRegulation(Regulation regulation) {
		this.regulation = regulation;
	}
	
	
}