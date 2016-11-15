package rule;

public class Course {

	protected String LectureCode;   //강의 코드
	protected String courseMake_Up;  //재수강여부
	protected String Grade;  //받은 등급
	protected boolean IsEnglishCourse;  //영어강의여부
	
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
