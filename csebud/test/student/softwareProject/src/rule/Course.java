package rule;

public class Course {

	private String LectureCode;   //강의 코드
	private String Credit; //학점
	private String Grade;  //받은 등급
	private boolean IsEnglishCourse;  //영어강의여부
	
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
