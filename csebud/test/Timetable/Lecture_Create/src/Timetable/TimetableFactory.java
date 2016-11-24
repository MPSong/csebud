package Timetable;

import java.util.ArrayList;

public class TimetableFactory {

	private ArrayList<Integer> priorityIndex=new ArrayList<Integer>(); //각 우선순위가 담고 있는 인덱스 수
	private ArrayList<Boolean> IsPriorityIn=new ArrayList<Boolean>();  //우선순위에서 강의가 들어갔는지 여부
	private ArrayList<LecturePossible> lecturePossible=new ArrayList<LecturePossible>();
	private ArrayList<Timetable> timetable=new ArrayList<Timetable>(); //timeTable객체 생성
	
	private ArrayList<Integer> temp_index=new ArrayList<Integer>(); //알고리즘 중 index를 저장하는 부분
	private ArrayList<Integer> temp_Credit=new ArrayList<Integer>(); //알고리즘 중 max_credit을 저장하는 부분
	
	public ArrayList<Timetable> makeTimetable(ArrayList<LecturePossible> lecturePossible, int max_credit){
		
		
		this.lecturePossible=lecturePossible;
		
		int priorityNum=1; //우선순위 1부터 시작한다.
		int index_count=0; //우선순위에 있는 index를 카운트하기 위함
		for(int i=0; i<lecturePossible.size()-1; i++){  //우선순위 인덱스를 담을 반복문
			index_count++; //인덱스 카운트
			if(lecturePossible.get(i+1).priority==(priorityNum+1))
			{
				IsPriorityIn.add(false); //우선순위 
				priorityIndex.add(index_count); //인덱스 저장
				index_count=0;
				priorityNum++;
			}
		}
		
		priorityNum=1; //다시 1로 초기화
		
		//분반을 몇에서 시작하느냐에 따라 결과가 다르다.
		//한 번 집어넣을때마다 새로운 클래스에 집어넣고 마지막 인덱스를 return한다.
		//리턴한 결과를 가지고 count가 안되면 다시 getLecture에 집어넣는다. 이를 통해 모든 브랜치의 시간표를 생성한다.
		Timetable temp_table=new Timetable();
		timetable.add(temp_table);
		temp_index.add(0);
		temp_Credit.add(0);
		getLecture(timetable.get(0), priorityNum, 0, max_credit);
		
		//test필요
		for(int i=1; i<timetable.size(); i++){
			getLecture(timetable.get(i), lecturePossible.get(temp_index.get(i)).priority, temp_index.get(i), temp_Credit.get(i));
		}
		//여기까지
		//너무 우선순위에서 벗어날 경우 지워주는 알고리즘 작성해야함
		return timetable;
		
		
	}
	
	private void getLecture(Timetable temp_table, int priorityNum, int index, int credit){
		if((credit<3)&&!IsPriorityIn.get(priorityNum-1)){
			if(isTableEmpty(temp_table, index)){  //이번 우선순위에서 안 들어갔으면, count!=0, 테이블이 비었으면,
				//test필요
				if((priorityNum+1)!=(lecturePossible.get(index+1).priority)){ //우선순위의 마지막 인덱스가 아니라면,
					timetable.add(temp_table); //지금까지 진행된 timetable을 임시로 집어넣는다.
					temp_index.add(index+1);
					temp_Credit.add(credit);
				}
				//여기까지
				putTable(temp_table, index);
				IsPriorityIn.set(priorityNum-1, true);
				int temp_credit=lecturePossible.get(index).Credit;
				getLecture(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).LectureInfo)+1+priorityIndex.get(priorityNum-1), credit-temp_credit); //다음 우선순위로 진입				
			}
			else{ //이번 인덱스가 못들어간다면,
				if((priorityNum+1)==(lecturePossible.get(index+1).priority)){ //우선순위의 마지막 인덱스라면,
					getLecture(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).Division)+1+priorityIndex.get(priorityNum-1), credit); //다음 우선순위로 진입
					//IsPriorityIn을 true로 바꿔줘야할 수도 있음
				}
				else{ //마지막 인덱스가 아니라면 같은 우선순위 내 인덱스 증가
					getLecture(temp_table, priorityNum, index+1, credit);
				}
			}
		}
	}
	
	public void putTable(Timetable temp_table, int index){  //시간표에 집어넣는 메소드
		int column = getTableColumn(lecturePossible.get(index).FirstWeek);
		for (int j = getTableRow(lecturePossible.get(index).FirstStartTime); j < getTableRow(lecturePossible.get(index).FirstEndTime); j++) {
			temp_table.putTable(j, column, lecturePossible.get(index));
		}
		column = getTableColumn(lecturePossible.get(index).SecondWeek);
		for (int j = getTableRow(lecturePossible.get(index).SecondStartTime); j < getTableRow(lecturePossible.get(index).SecondEndTime); j++) {
			temp_table.putTable(j, column, lecturePossible.get(index));
		}
	}
	
	public boolean isTableEmpty(Timetable temp_table, int index) { // 테이블이 비어있는 지 검사하는 메소드
		//첫번째날 강의시간
		int column = getTableColumn(lecturePossible.get(index).FirstWeek);
		for (int j = getTableRow(lecturePossible.get(index).FirstStartTime); j < getTableRow(lecturePossible.get(index).FirstEndTime); j++) {
			if (temp_table.isTableEmpty(j, column))
				return false;
		}
		//두번째날 강의시간
		column = getTableColumn(lecturePossible.get(index).SecondWeek);
		for (int j = getTableRow(lecturePossible.get(index).SecondStartTime); j < getTableRow(lecturePossible.get(index).SecondEndTime); j++) {
			if (temp_table.isTableEmpty(j, column))
				return false;
		}
		return true;
	}
	
	//시간에 따라 시간표에 들어갈 행을 지정해주는 메소드
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

	//강의 시간에 따라 시간표에 들어갈 열을 지정해주는 메소드
	private int getTableColumn(String day) {
		switch (day) {
		case "월":
			return 1;
		case "화":
			return 2;
		case "수":
			return 3;
		case "목":
			return 4;
		case "금":
			return 5;
		default:
			return -1;
		}
	}
	
	
}
