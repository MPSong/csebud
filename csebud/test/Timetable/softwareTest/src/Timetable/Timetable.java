package Timetable;

public class Timetable {

	private String []LectureInfo=new String[10]; // �м���ȣ
	private String []Division=new String[10]; // �й�

	private String []LectureName=new String[10]; // �����̸�
	private String []Professor=new String[10]; // ������

	private String []FirstWeek=new String[10]; // ù��° ����
	private String []FirstStartTime=new String[10]; // ù��° ���۽ð�
	private String []FirstEndTime=new String[10]; // ù��° ����ð�

	private String []SecondWeek=new String[10]; // �ι�° ����
	private String []SecondStartTime=new String[10]; // �ι�° ���۽ð�
	private String []SecondEndTime=new String[10]; // �ι�° ����ð�

	private String []FirstClassroom=new String[10]; // ù��° ���ǽ�
	private String []SecondClassroom=new String[10]; // �ι�° ���ǽ�

	private int []Credit=new int[10]; // ����
	private boolean []IsEnglish=new boolean[10]; // ����� ����
	
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
		index++;
		
	}
	
	public boolean isTableEmpty(int row, int column){
		if (table[row][column] != "")
			return true;
		else 
			return false;
	}
	
	public void print(){ //�׽�Ʈ ��
		System.out.println("index: "+index);
		for(int i=0; i<index; i++){
			System.out.println(LectureInfo[i]);
		}
	}
	
}
