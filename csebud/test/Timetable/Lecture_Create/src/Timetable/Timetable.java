package Timetable;

public class Timetable {

	private String []LectureInfo; // 학수번호
	private String []Division; // 분반

	private String []LectureName; // 강의이름
	private String []Professor; // 교원명

	private String []FirstWeek; // 첫번째 요일
	private String []FirstStartTime; // 첫번째 시작시각
	private String []FirstEndTime; // 첫번째 종료시각

	private String []SecondWeek; // 두번째 요일
	private String []SecondStartTime; // 두번째 시작시각
	private String []SecondEndTime; // 두번째 종료시각

	private String []FirstClassroom; // 첫번째 강의실
	private String []SecondClassroom; // 두번째 강의실

	private int []Credit; // 학점
	private boolean []IsEnglish; // 영어강의 여부
	
	private int index; //인덱스...
	
	public String[][]table; //시간표
	
	public Timetable(){
		index=0;
		table=new String[25][6]; //시간표 테이블 생성
		for (int i = 0; i < 25; i++) //초기화
			for (int j = 0; j < 6; j++)
				table[i][j] = "";
	}
	
	public void putTable(int row, int column, LecturePossible l){
		//테이블에도 넣어줘야함
		table[row][column] = l.LectureInfo+l.Division; //임시, JSP에 뿌릴때 다시 설정해주어야함.
		
		this.LectureInfo[index]=l.LectureInfo;
		this.Division[index]=l.Division;
		this.FirstWeek[index]=l.FirstWeek;
		this.SecondWeek[index]=l.SecondWeek;
		this.FirstStartTime[index]=l.FirstStartTime;
		this.FirstEndTime[index]=l.FirstEndTime;
		this.SecondStartTime[index]=l.SecondStartTime;
		this.SecondEndTime[index]=l.SecondEndTime;
		this.Credit[index]=l.Credit;
		
	}
	
	public boolean isTableEmpty(int row, int column){
		if (table[row][column] != "")
			return true;
		else 
			return false;
	}
	
	
}
