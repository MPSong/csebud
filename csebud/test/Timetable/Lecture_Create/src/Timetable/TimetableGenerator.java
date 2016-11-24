package Timetable;

import java.util.ArrayList;

public class TimetableGenerator {
	private ArrayList<LectureCourse> lecture;
	// Regulation�� �ʿ�
	private TimetableFactory factory;
	private ArrayList<Timetable> timetable;
	private ArrayList<LecturePossible> lecturePossible; // ���� �˰����� ������ ���ǵ�
	private int max_credit; //�ִ�� ���� credit(����ڷ� ���� �޴´�.)

	public TimetableGenerator() { // ������

	}

	public void CreatePossibleLecture() { // Lecture�� LecturePossible�� ����ִ� �޼ҵ�
		match_Regulation_to_Lecture(); // Lecture���� ���Ǹ� �̴´�.
		setPriority(); // �켱������ �����Ѵ�.
	}

	private void match_Regulation_to_Lecture() {// Regulation���� �� ���� ���Ǹ� �޾� Lecture���� ���Ǹ� �̾��ִ��� ���ϴ� �޼ҵ�
		//Regulation���� ���� �ڵ�� 
	}

	private void setPriority() { //�켱������ ���ϴ� �޼ҵ�
		for(int i=0; i<lecture.size();i++){ 
			//MSC, ���
		}
	}

	public void autoGenerateTimetable() { // Ÿ�����̺��� �����Ѵ�.
		timetable = factory.makeTimetable(lecturePossible, max_credit);
	}
	
	public void setCredit_max(int max_credit){ //�ִ�� ���� ���� set
		this.max_credit=max_credit;
	}

}
