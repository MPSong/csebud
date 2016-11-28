package Timetable;

import java.util.ArrayList;

public class Timetable {

	private ArrayList<String> LectureInfo=new ArrayList<String>(); // 학수번호
	private ArrayList<String> Division=new ArrayList<String>(); // 분반

	private ArrayList<String> LectureName=new ArrayList<String>(); // 강의이름
	private ArrayList<String> Professor=new ArrayList<String>(); // 교원명

	private ArrayList<String> FirstWeek=new ArrayList<String>(); // 첫번째 요일
	private ArrayList<String> FirstStartTime=new ArrayList<String>(); // 첫번째 시작시각
	private ArrayList<String> FirstEndTime=new ArrayList<String>(); // 첫번째 종료시각

	private ArrayList<String> SecondWeek=new ArrayList<String>(); // 두번째 요일
	private ArrayList<String> SecondStartTime=new ArrayList<String>(); // 두번째 시작시각
	private ArrayList<String> SecondEndTime=new ArrayList<String>(); // 두번째 종료시각

	private ArrayList<String> FirstClassroom=new ArrayList<String>(); // 첫번째 강의실
	private ArrayList<String> SecondClassroom=new ArrayList<String>(); // 두번째 강의실

	private ArrayList<Integer> Credit=new ArrayList<Integer>(); // 학점
	//private ArrayList<boolean> IsEnglish=new ArrayList<boolean>(); // 영어강의 여부
	
	public String[][]table; //시간표
	
	public Timetable(){
		table=new String[25][6]; //시간표 테이블 생성
		for (int i = 0; i < 25; i++) //초기화
			for (int j = 0; j < 6; j++)
				table[i][j] = "";
	}
	
	public Timetable(Timetable t){ //복사 생성자
		for(int i=0; i<t.LectureInfo.size(); i++){
			this.LectureInfo.add(t.LectureInfo.get(i));
			this.Division.add(t.Division.get(i));
			this.FirstWeek.add(t.FirstWeek.get(i));
			this.SecondWeek.add(t.SecondWeek.get(i));
			this.FirstStartTime.add(t.FirstStartTime.get(i));
			this.FirstEndTime.add(t.FirstEndTime.get(i));
			this.SecondStartTime.add(t.SecondStartTime.get(i));
			this.SecondEndTime.add(t.SecondEndTime.get(i));
			this.Credit.add(t.Credit.get(i));
		}
		
	}
	
	public void putTable(int row, int column, LecturePossible l){
		//테이블에도 넣어줘야함
		table[row][column] = l.LectureInfo+l.Division; //임시, JSP에 뿌릴때 다시 설정해주어야함.
		
		this.LectureInfo.add(l.LectureInfo);
		this.Division.add(l.Division);
		this.FirstWeek.add(l.FirstWeek);
		this.SecondWeek.add(l.SecondWeek);
		this.FirstStartTime.add(l.FirstStartTime);
		this.FirstEndTime.add(l.FirstEndTime);
		this.SecondStartTime.add(l.SecondStartTime);
		this.SecondEndTime.add(l.SecondEndTime);
		this.Credit.add(l.Credit);
	}
	
	public boolean isTableEmpty(int row, int column){
		if (table[row][column] != "")
			return true;
		else 
			return false;
	}
	
	public void print(){ //테스트 용
		for(int i=0; i<LectureInfo.size(); i++){
			System.out.println(LectureInfo.get(i)+"-"+Division.get(i));
		}
		System.out.println("");
	}
	
}
