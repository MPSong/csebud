package rule;

public class Course {

	protected String LectureCode;   //���� �ڵ�
	protected String courseMake_Up;  //���������
	protected String Grade;  //���� ���
	protected boolean IsEnglishCourse;  //����ǿ���
	
	public Course(String LectureCode, String courseMake_Up, String Grade, boolean IsEnglishCourse){
		this.LectureCode=LectureCode;
		this.courseMake_Up=courseMake_Up;
		this.Grade=Grade;
		this.IsEnglishCourse=IsEnglishCourse;
	}	
		
	public String getLectureCode() {
		return LectureCode;
	}

	public String getGrade() {
		return Grade;
	}
	
	public String getCourseMake_up(){
		return courseMake_Up;
	}

	public boolean getIsEnglishCourse(){
		return IsEnglishCourse;
	}


	
}
