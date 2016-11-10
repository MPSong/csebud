package rule;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	private String studentId;
	private String studentName;
	private int[] reviewsWritten;
	//private Timetable []myTimetables;
	private int creditsTaken;  //수강한 학점
	
	private int majorEnglishCourse;  //전공에서 영어강의 들은 횟수
	private int liberalEnglishCourse; //교양에서 영어강의 들은 횟수
	private int totalEnglishCourse;  //총 영어강의 들은 횟수
	
	private ArrayList<Course> courses=new ArrayList<Course>();  //들은 강좌를 모두 담은 ArrayList
	
	boolean IsExcelFile;  //성적 엑셀 파일을 업로드했는지 여부
	
	public Student(){
		
	}
	public Student(String filepath, String tableName){
		if(IsExcelFile){  //성적 엑셀 파일을 업로드 했다면,
			ExcelRead excel=new ExcelRead();
			courses=excel.getExcelData(filepath, tableName); //엑셀 파일을 읽어 저장한다.
			
			/*재수강한 적이 있다면 전에 수강한 과목은 삭제한다.*/
			Iterator<Course> iter=courses.iterator();
			while(iter.hasNext()){
				Course c=iter.next();
				if(c.courseMake_Up=="OLD재수강")
					iter.remove();
			}
		}
		else
		{
			
		}
	}
	
	public void UpdateStudentInfo(){
		
	}
	
	public String getStudentID(){
		return studentId;
	}
	
}
