package rule;

public class Course {

	private String LectureCode;   //���� �ڵ�
	private String Credit; //����
	private String Grade;  //���� ���
	private boolean IsEnglishCourse;  //����ǿ���
	
	public Course(String LectureCode, String Credit, String Grade, boolean IsEnglishCourse){
		this.LectureCode=LectureCode;
		this.Credit=Credit;
		this.Grade=Grade;
		this.IsEnglishCourse=IsEnglishCourse;
	}	
		
	public String getLectureCode() {
		return LectureCode;
	}
	
	public String getCredit(){
		return Credit;
	}

	public String getGrade() {
		return Grade;
	}

	public boolean getIsEnglishCourse(){
		return IsEnglishCourse;
	}


	
}
