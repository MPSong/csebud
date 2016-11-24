package Timetable;

public class LecturePossible {
	public String LectureInfo; // 학수번호
	public String Division; // 분반

	public String FirstWeek; // 첫번째 요일
	public String FirstStartTime; // 첫번째 시작시각
	public String FirstEndTime; // 첫번째 종료시각

	public String SecondWeek; // 두번째 요일
	public String SecondStartTime; // 두번째 시작시각
	public String SecondEndTime; // 두번째 종료시각
	public int Credit; //학점
	
	public int priority; //우선순위

	public LecturePossible(String LectureInfo, String Division, String FirstWeek, String FirstStartTime,
			String FirstEndTime, String SecondWeek, String SecondStartTime, String SecondEndTime, 
			int Credit, int priority) {
		

		this.LectureInfo=LectureInfo;
		this.Division=Division;
		this.FirstWeek=FirstWeek;
		this.SecondWeek=SecondWeek;
		this.FirstStartTime=FirstStartTime;
		this.FirstEndTime=FirstEndTime;
		this.SecondStartTime=SecondStartTime;
		this.SecondEndTime=SecondEndTime;
		this.Credit=Credit;
		this.priority=priority;
	}
}
