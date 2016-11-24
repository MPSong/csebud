package Timetable;

import java.util.ArrayList;

public class TimetableGenerator {
	private ArrayList<LectureCourse> lecture;
	// Regulation도 필요
	private TimetableFactory factory;
	private ArrayList<Timetable> timetable;
	private ArrayList<LecturePossible> lecturePossible; // 실제 알고리즘을 적용할 강의들
	private int max_credit; //최대로 들을 credit(사용자로 부터 받는다.)

	public TimetableGenerator() { // 생성자

	}

	public void CreatePossibleLecture() { // Lecture을 LecturePossible에 집어넣는 메소드
		match_Regulation_to_Lecture(); // Lecture에서 강의를 뽑는다.
		setPriority(); // 우선순위를 설정한다.
	}

	private void match_Regulation_to_Lecture() {// Regulation에서 안 들은 강의를 받아 Lecture에서 강의를 뽑아있는지 비교하는 메소드
		//Regulation에서 과목 코드와 
	}

	private void setPriority() { //우선순위를 정하는 메소드
		for(int i=0; i<lecture.size();i++){ 
			//MSC, 등등
		}
	}

	public void autoGenerateTimetable() { // 타임테이블을 생성한다.
		timetable = factory.makeTimetable(lecturePossible, max_credit);
	}
	
	public void setCredit_max(int max_credit){ //최대로 들을 학점 set
		this.max_credit=max_credit;
	}

}
