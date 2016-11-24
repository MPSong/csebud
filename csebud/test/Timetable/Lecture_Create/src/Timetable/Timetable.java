package Timetable;

public class Timetable {

	private String []LectureInfo; // �м���ȣ
	private String []Division; // �й�

	private String []LectureName; // �����̸�
	private String []Professor; // ������

	private String []FirstWeek; // ù��° ����
	private String []FirstStartTime; // ù��° ���۽ð�
	private String []FirstEndTime; // ù��° ����ð�

	private String []SecondWeek; // �ι�° ����
	private String []SecondStartTime; // �ι�° ���۽ð�
	private String []SecondEndTime; // �ι�° ����ð�

	private String []FirstClassroom; // ù��° ���ǽ�
	private String []SecondClassroom; // �ι�° ���ǽ�

	private int []Credit; // ����
	private boolean []IsEnglish; // ����� ����
	
	private int index; //�ε���...
	
	public String[][]table; //�ð�ǥ
	
	public Timetable(){
		index=0;
		table=new String[25][6]; //�ð�ǥ ���̺� ����
		for (int i = 0; i < 25; i++) //�ʱ�ȭ
			for (int j = 0; j < 6; j++)
				table[i][j] = "";
	}
	
	public void putTable(int row, int column, LecturePossible l){
		//���̺��� �־������
		table[row][column] = l.LectureInfo+l.Division; //�ӽ�, JSP�� �Ѹ��� �ٽ� �������־����.
		
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
