package rule;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	private String studentId;
	private String studentName;
	private int[] reviewsWritten;
	//private Timetable []myTimetables;
	private int creditsTaken;  //������ ����
	
	private int majorEnglishCourse;  //�������� ����� ���� Ƚ��
	private int liberalEnglishCourse; //���翡�� ����� ���� Ƚ��
	private int totalEnglishCourse;  //�� ����� ���� Ƚ��
	
	private ArrayList<Course> courses=new ArrayList<Course>();  //���� ���¸� ��� ���� ArrayList
	
	boolean IsExcelFile;  //���� ���� ������ ���ε��ߴ��� ����
	
	public Student(){
		
	}
	public Student(String filepath, String tableName){
		if(IsExcelFile){  //���� ���� ������ ���ε� �ߴٸ�,
			ExcelRead excel=new ExcelRead();
			courses=excel.getExcelData(filepath, tableName); //���� ������ �о� �����Ѵ�.
			
			/*������� ���� �ִٸ� ���� ������ ������ �����Ѵ�.*/
			Iterator<Course> iter=courses.iterator();
			while(iter.hasNext()){
				Course c=iter.next();
				if(c.courseMake_Up=="OLD�����")
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
