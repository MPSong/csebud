package buddy.timetable;

import java.util.ArrayList;

public class TimetableFactory {

   private ArrayList<Integer> priorityIndex=new ArrayList<Integer>(); //각 우선순위가 담고 있는 인덱스 수
   private ArrayList<Boolean> IsPriorityIn=new ArrayList<Boolean>();  //우선순위에서 강의가 들어갔는지 여부
   private ArrayList<LecturePossible> lecturePossible=new ArrayList<LecturePossible>();
   private ArrayList<Timetable> timetable=new ArrayList<Timetable>(); //timeTable객체 생성
   
   public ArrayList<Timetable> makeTimetable(ArrayList<LecturePossible> lecturePossible, int max_credit, int first_priority_num){
      
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
      /*마지막꺼 담는다.*/
      IsPriorityIn.add(false); //우선순위 
      priorityIndex.add(index_count+1); //인덱스 저장
      
      priorityNum=1; //다시 1로 초기화
      
      /*첫 번째 우선순위는 모든 분반이 처음부터 시작한 결과가 나온다.*/
      for(int i=0; i<first_priority_num; i++){ 
         timetable.add(i, new Timetable());
         makeTimetableSub(timetable.get(i), priorityNum, i, max_credit);
         for(int j=0; j<IsPriorityIn.size(); j++){  //IsPriorityIn 초기화
            IsPriorityIn.set(j, false);
         }
      }
         
      for(int i=0; i<timetable.size(); i++){ //for test
         timetable.get(i).print();
         System.out.println("");
      }
      
      return timetable;
      
      
   }
   
   private void makeTimetableSub(Timetable temp_table, int priorityNum, int index, int credit){
      if((credit>=3)&&!IsPriorityIn.get(priorityNum-1)){
         if(isTableEmpty(temp_table, index)){  //이번 우선순위에서 안 들어갔으면, count!=0, 테이블이 비었으면,

            putTable(temp_table, index);
            IsPriorityIn.set(priorityNum-1, true);
            int temp_credit=lecturePossible.get(index).Credit;
            makeTimetableSub(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).Division)+1+priorityIndex.get(priorityNum-1), credit-temp_credit); //다음 우선순위로 진입            
         }
         else{ //이번 인덱스가 못들어간다면,
            if((priorityNum+1)==(lecturePossible.get(index+1).priority)){ //우선순위의 마지막 인덱스라면,
            	makeTimetableSub(temp_table, priorityNum+1, index-Integer.parseInt(lecturePossible.get(index).Division)+1+priorityIndex.get(priorityNum-1), credit); //다음 우선순위로 진입
               //IsPriorityIn을 true로 바꿔줘야할 수도 있음
            }
            else{ //마지막 인덱스가 아니라면 같은 우선순위 내 인덱스 증가
            	makeTimetableSub(temp_table, priorityNum, index+1, credit);
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
      if(!time.equals("")){
         int temp=Integer.parseInt(time);
         int index=1;
         for(int i=900; i<=2300; ){
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
      else{
         return -1;
      }
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