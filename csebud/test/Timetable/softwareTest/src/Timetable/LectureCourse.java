package Timetable;


public class LectureCourse {
	public String LectureInfo; // 학수번호
	public String Division; // 분반

	public String LectureName; // 강의이름
	public String Professor; // 교원명

	public String FirstWeek; // 첫번째 요일
	public String FirstStartTime; // 첫번째 시작시각
	public String FirstEndTime; // 첫번째 종료시각

	public String SecondWeek; // 두번째 요일
	public String SecondStartTime; // 두번째 시작시각
	public String SecondEndTime; // 두번째 종료시각

	public String FirstClassroom; // 첫번째 강의실
	public String SecondClassroom; // 두번째 강의실

	public int Credit; // 학점
	public boolean IsEnglish; // 영어강의 여부

	public LectureCourse(String LectureInfo, String Division, String LectureName, String Professor,

			String FirstWeek, String FirstStartTime, String FirstEndTime,

			String SecondWeek, String SecondStartTime, String SecondEndTime,

			String FirstClassroom, String SecondClassroom,

			int Credit, boolean IsEnglish) {

		this.LectureInfo=LectureInfo;
		this.Division=Division;
		this.LectureName=LectureName;
		this.Professor=Professor;
		this.FirstWeek=FirstWeek;
		this.SecondWeek=SecondWeek;
		this.FirstStartTime=FirstStartTime;
		this.FirstEndTime=FirstEndTime;
		this.SecondStartTime=SecondStartTime;
		this.SecondEndTime=SecondEndTime;
		this.FirstClassroom=FirstClassroom;
		this.SecondClassroom=SecondClassroom;
		this.Credit=Credit;
		this.IsEnglish=IsEnglish;
	}
	
}
