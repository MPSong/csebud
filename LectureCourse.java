package rule;

public class LectureCourse {
	private String LectureInfo; // 학수번호
	private String Division; // 분반

	private String LectureName; // 강의이름
	private String Professor; // 교원명

	private String FirstWeek; // 첫번째 요일
	private String FirstStartTime; // 첫번째 시작시각
	private String FirstEndTime; // 첫번째 종료시각

	private String SecondWeek; // 두번째 요일
	private String SecondStartTime; // 두번째 시작시각
	private String SecondEndTime; // 두번째 종료시각

	private String FirstClassroom; // 첫번째 강의실
	private String SecondClassroom; // 두번째 강의실

	private int Credit; // 학점
	private boolean IsEnglish; // 영어강의 여부

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
