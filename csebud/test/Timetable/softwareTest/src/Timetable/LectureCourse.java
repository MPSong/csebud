package Timetable;


public class LectureCourse {
	public String LectureInfo; // �м���ȣ
	public String Division; // �й�

	public String LectureName; // �����̸�
	public String Professor; // ������

	public String FirstWeek; // ù��° ����
	public String FirstStartTime; // ù��° ���۽ð�
	public String FirstEndTime; // ù��° ����ð�

	public String SecondWeek; // �ι�° ����
	public String SecondStartTime; // �ι�° ���۽ð�
	public String SecondEndTime; // �ι�° ����ð�

	public String FirstClassroom; // ù��° ���ǽ�
	public String SecondClassroom; // �ι�° ���ǽ�

	public int Credit; // ����
	public boolean IsEnglish; // ����� ����

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
