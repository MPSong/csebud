package buddy.student;

import java.util.ArrayList;

	public class Student {
	private String studentId;
	private int[] reviewsWritten;
	private int creditsTaken;  // 수강한 학점
	
	/*
	private int majorEnglishCourse;  // 전공에서 영어강의 들은 횟수
	private int liberalEnglishCourse; // 교양에서 영어강의 들은 횟수
	private int totalEnglishCourse;  // 총 영어강의 들은 횟수
	*/
	
	private ArrayList<Course> courses=new ArrayList<Course>(); // 들은 강좌를 모두 담은 ArrayList
	
	boolean IsExcelFile;  // 성적 엑셀 파일을 업로드했는지 여부
	   
	public void UpdateStudentInfo(){
	}
	   
	public String getStudentID(){
		return studentId;
	}
   
}
