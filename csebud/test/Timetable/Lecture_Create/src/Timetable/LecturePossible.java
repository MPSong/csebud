package Timetable;

public class LecturePossible {
	public String LectureInfo; // �м���ȣ
	public String Division; // �й�

	public String FirstWeek; // ù��° ����
	public String FirstStartTime; // ù��° ���۽ð�
	public String FirstEndTime; // ù��° ����ð�

	public String SecondWeek; // �ι�° ����
	public String SecondStartTime; // �ι�° ���۽ð�
	public String SecondEndTime; // �ι�° ����ð�
	public int Credit; //����
	
	public int priority; //�켱����

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
