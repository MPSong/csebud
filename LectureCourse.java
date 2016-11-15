package rule;

public class LectureCourse {
	private String LectureInfo; // �м���ȣ
	private String Division; // �й�

	private String LectureName; // �����̸�
	private String Professor; // ������

	private String FirstWeek; // ù��° ����
	private String FirstStartTime; // ù��° ���۽ð�
	private String FirstEndTime; // ù��° ����ð�

	private String SecondWeek; // �ι�° ����
	private String SecondStartTime; // �ι�° ���۽ð�
	private String SecondEndTime; // �ι�° ����ð�

	private String FirstClassroom; // ù��° ���ǽ�
	private String SecondClassroom; // �ι�° ���ǽ�

	private int Credit; // ����
	private boolean IsEnglish; // ����� ����

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
