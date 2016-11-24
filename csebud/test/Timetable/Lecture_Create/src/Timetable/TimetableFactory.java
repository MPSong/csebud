package Timetable;

import java.util.ArrayList;

public class TimetableFactory {

	private ArrayList<Integer> priorityIndex=new ArrayList<Integer>(); //�� �켱������ ��� �ִ� �ε��� ��
	private ArrayList<Boolean> IsPriorityIn=new ArrayList<Boolean>();  //�켱�������� ���ǰ� ������ ����
	private ArrayList<LecturePossible> lecturePossible=new ArrayList<LecturePossible>();
	private ArrayList<Timetable> timetable=new ArrayList<Timetable>(); //timeTable��ü ����
	
	private ArrayList<Integer> temp_index=new ArrayList<Integer>(); //�˰��� �� index�� �����ϴ� �κ�
	private ArrayList<Integer> temp_Credit=new ArrayList<Integer>(); //�˰��� �� max_credit�� �����ϴ� �κ�
	
	public ArrayList<Timetable> makeTimetable(ArrayList<LecturePossible> lecturePossible, int max_credit){
		
		
		this.lecturePossible=lecturePossible;
		
		int priorityNum=1; //�켱���� 1���� �����Ѵ�.
		int index_count=0; //�켱������ �ִ� index�� ī��Ʈ�ϱ� ����
		for(int i=0; i<lecturePossible.size()-1; i++){  //�켱���� �ε����� ���� �ݺ���
			index_count++; //�ε��� ī��Ʈ
			if(lecturePossible.get(i+1).priority==(priorityNum+1))
			{
				IsPriorityIn.add(false); //�켱���� 
				priorityIndex.add(index_count); //�ε��� ����
				index_count=0;
				priorityNum++;
			}
		}
		
		priorityNum=1; //�ٽ� 1�� �ʱ�ȭ
		
		//�й��� ��� �����ϴ��Ŀ� ���� ����� �ٸ���.
		//�� �� ������������� ���ο� Ŭ������ ����ְ� ������ �ε����� return�Ѵ�.
		//������ ����� ������ count�� �ȵǸ� �ٽ� getLecture�� ����ִ´�. �̸� ���� ��� �귣ġ�� �ð�ǥ�� �����Ѵ�.
		Timetable temp_table=new Timetable();
		timetable.add(temp_table);
		temp_index.add(0);
		temp_Credit.add(0);
		getLecture(timetable.get(0), priorityNum, 0, max_credit);
		
		//test�ʿ�
		for(int i=1; i<timetable.size(); i++){
			getLecture(timetable.get(i), lecturePossible.get(temp_index.get(i)).priority, temp_index.get(i), temp_Credit.get(i));
		}
		//�������
		//�ʹ� �켱�������� ��� ��� �����ִ� �˰��� �ۼ��ؾ���
		return timetable;
		
		
	}
	
	private void getLecture(Timetable temp_table, int priorityNum, int index, int credit){
		if((credit<3)&&!IsPriorityIn.get(priorityNum-1)){
			if(isTableEmpty(temp_table, index)){  //�̹� �켱�������� �� ������, count!=0, ���̺��� �������,
				//test�ʿ�
				if((priorityNum+1)!=(lecturePossible.get(index+1).priority)){ //�켱������ ������ �ε����� �ƴ϶��,
					timetable.add(temp_table); //���ݱ��� ����� timetable�� �ӽ÷� ����ִ´�.
					temp_index.add(index+1);
					temp_Credit.add(credit);
				}
				//�������
				putTable(temp_table, index);
				IsPriorityIn.set(priorityNum-1, true);
				int temp_credit=lecturePossible.get(index).Credit;
				getLecture(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).LectureInfo)+1+priorityIndex.get(priorityNum-1), credit-temp_credit); //���� �켱������ ����				
			}
			else{ //�̹� �ε����� �����ٸ�,
				if((priorityNum+1)==(lecturePossible.get(index+1).priority)){ //�켱������ ������ �ε������,
					getLecture(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).Division)+1+priorityIndex.get(priorityNum-1), credit); //���� �켱������ ����
					//IsPriorityIn�� true�� �ٲ������ ���� ����
				}
				else{ //������ �ε����� �ƴ϶�� ���� �켱���� �� �ε��� ����
					getLecture(temp_table, priorityNum, index+1, credit);
				}
			}
		}
	}
	
	public void putTable(Timetable temp_table, int index){  //�ð�ǥ�� ����ִ� �޼ҵ�
		int column = getTableColumn(lecturePossible.get(index).FirstWeek);
		for (int j = getTableRow(lecturePossible.get(index).FirstStartTime); j < getTableRow(lecturePossible.get(index).FirstEndTime); j++) {
			temp_table.putTable(j, column, lecturePossible.get(index));
		}
		column = getTableColumn(lecturePossible.get(index).SecondWeek);
		for (int j = getTableRow(lecturePossible.get(index).SecondStartTime); j < getTableRow(lecturePossible.get(index).SecondEndTime); j++) {
			temp_table.putTable(j, column, lecturePossible.get(index));
		}
	}
	
	public boolean isTableEmpty(Timetable temp_table, int index) { // ���̺��� ����ִ� �� �˻��ϴ� �޼ҵ�
		//ù��°�� ���ǽð�
		int column = getTableColumn(lecturePossible.get(index).FirstWeek);
		for (int j = getTableRow(lecturePossible.get(index).FirstStartTime); j < getTableRow(lecturePossible.get(index).FirstEndTime); j++) {
			if (temp_table.isTableEmpty(j, column))
				return false;
		}
		//�ι�°�� ���ǽð�
		column = getTableColumn(lecturePossible.get(index).SecondWeek);
		for (int j = getTableRow(lecturePossible.get(index).SecondStartTime); j < getTableRow(lecturePossible.get(index).SecondEndTime); j++) {
			if (temp_table.isTableEmpty(j, column))
				return false;
		}
		return true;
	}
	
	//�ð��� ���� �ð�ǥ�� �� ���� �������ִ� �޼ҵ�
	private int getTableRow(String time) {
		int temp=Integer.parseInt(time);
		int index=1;
		for(int i=900; i<=2100; ){
			if((i+30)>temp&&temp>=i){
				break;
			}
			index++;
			if((i%100)==0)
				i+=30;
			else
				i+=70;
		}
		return index;
	}

	//���� �ð��� ���� �ð�ǥ�� �� ���� �������ִ� �޼ҵ�
	private int getTableColumn(String day) {
		switch (day) {
		case "��":
			return 1;
		case "ȭ":
			return 2;
		case "��":
			return 3;
		case "��":
			return 4;
		case "��":
			return 5;
		default:
			return -1;
		}
	}
	
	
}
