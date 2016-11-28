package Timetable;

import java.util.ArrayList;

public class Timetable {

	private ArrayList<String> LectureInfo=new ArrayList<String>(); // �м���ȣ
	private ArrayList<String> Division=new ArrayList<String>(); // �й�

	private ArrayList<String> LectureName=new ArrayList<String>(); // �����̸�
	private ArrayList<String> Professor=new ArrayList<String>(); // ������

	private ArrayList<String> FirstWeek=new ArrayList<String>(); // ù��° ����
	private ArrayList<String> FirstStartTime=new ArrayList<String>(); // ù��° ���۽ð�
	private ArrayList<String> FirstEndTime=new ArrayList<String>(); // ù��° ����ð�

	private ArrayList<String> SecondWeek=new ArrayList<String>(); // �ι�° ����
	private ArrayList<String> SecondStartTime=new ArrayList<String>(); // �ι�° ���۽ð�
	private ArrayList<String> SecondEndTime=new ArrayList<String>(); // �ι�° ����ð�

	private ArrayList<String> FirstClassroom=new ArrayList<String>(); // ù��° ���ǽ�
	private ArrayList<String> SecondClassroom=new ArrayList<String>(); // �ι�° ���ǽ�

	private ArrayList<Integer> Credit=new ArrayList<Integer>(); // ����
	//private ArrayList<boolean> IsEnglish=new ArrayList<boolean>(); // ����� ����
	
	public String[][]table; //�ð�ǥ
	
	public Timetable(){
		table=new String[25][6]; //�ð�ǥ ���̺� ����
		for (int i = 0; i < 25; i++) //�ʱ�ȭ
			for (int j = 0; j < 6; j++)
				table[i][j] = "";
	}
	
	public Timetable(Timetable t){ //���� ������
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
		//���̺��� �־������
		table[row][column] = l.LectureInfo+l.Division; //�ӽ�, JSP�� �Ѹ��� �ٽ� �������־����.
		
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
	
	public void print(){ //�׽�Ʈ ��
		for(int i=0; i<LectureInfo.size(); i++){
			System.out.println(LectureInfo.get(i)+"-"+Division.get(i));
		}
		System.out.println("");
	}
	
}
