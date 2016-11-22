import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class TimeTable2 {

	private ArrayList<String> lectureID = new ArrayList<String>(); // 강의 ID
	private ArrayList<String> lectureClassID = new ArrayList<String>(); // 분반
	private ArrayList<String> LectureName = new ArrayList<String>(); // 강의 이름
	private ArrayList<String> professor = new ArrayList<String>(); // 교수
	private ArrayList<String> Time = new ArrayList<String>(); // 강의 시간(시작, 종료)
	private ArrayList<String> location = new ArrayList<String>(); // 강의 장소

	private ArrayList<String> firstDay = new ArrayList<String>(); // 첫번째 날
	private ArrayList<String> startTimeFirst = new ArrayList<String>(); // 강의
																		// 시작시간
	private ArrayList<String> endTimeFirst = new ArrayList<String>(); // 강의 종료시간

	private ArrayList<String> secondDay = new ArrayList<String>(); // 두번째 날
	private ArrayList<String> startTimeSecond = new ArrayList<String>(); // 강의
																			// 시작시간
	private ArrayList<String> endTimeSecond = new ArrayList<String>(); // 강의
																		// 종료시간

	private ArrayList<Integer> priority = new ArrayList<Integer>(); //우선순위
	
	private ArrayList<Boolean> timeBool =new ArrayList<Boolean>();  //탐색여부

	String[][] table;  //시간표

	public TimeTable2() { // 생성자
		table = new String[25][6];   
		//시간표 틀을 정의하는 부분
		table[0][0] = "";
		table[0][1] = "월";
		table[0][2] = "화";
		table[0][3] = "수";
		table[0][4] = "목";
		table[0][5] = "금";
		table[1][0] = "0900~0930";
		table[2][0] = "0930~1000";
		table[3][0] = "1000~1030";
		table[4][0] = "1030~1100";
		table[5][0] = "1100~1130";
		table[6][0] = "1130~1200";
		table[7][0] = "1200~1230";
		table[8][0] = "1230~1300";
		table[9][0] = "1300~1330";
		table[10][0] = "1330~1400";
		table[11][0] = "1400~1430";
		table[12][0] = "1430~1500";
		table[13][0] = "1500~1530";
		table[14][0] = "1530~1600";
		table[15][0] = "1600~1630";
		table[16][0] = "1630~1700";
		table[17][0] = "1700~1730";
		table[18][0] = "1730~1800";
		table[19][0] = "1800~1830";
		table[20][0] = "1830~1900";
		table[21][0] = "1900~1930";
		table[22][0] = "1930~2000";
		table[23][0] = "2000~2030";
		table[24][0] = "2030~2100";
		//틀을 제외한 나머지 부분은 ""로 초기화한다.
		for (int i = 1; i < 25; i++)
			for (int j = 1; j < 6; j++)
				table[i][j] = "";
	}

	//강의 시간을 잘라 첫번째 날의 시작/종료시간, 두번째 날의 시작/종료시간을 따로 저장하는 매소드이다.
	public void splitTime() {
		for (int i = 0; i < Time.size(); i++) {
			firstDay.add(Time.get(i).substring(0, 1));
			startTimeFirst.add(Time.get(i).substring(9, 11) + Time.get(i).substring(12, 14));
			endTimeFirst.add(Time.get(i).substring(15, 17) + Time.get(i).substring(18, 20));

			secondDay.add(Time.get(i).substring(21, 22));
			startTimeSecond.add(Time.get(i).substring(30, 32) + Time.get(i).substring(33, 35));
			endTimeSecond.add(Time.get(i).substring(36, 38) + Time.get(i).substring(39, 41));
		}
	}

	//Test 파일을 읽는 메소드이다.
	public void readFile() {
		BufferedReader inputStream = null;

		try { // 파일 읽기
			inputStream = new BufferedReader(new FileReader("timetable.txt"));

			String str;
			//실제 구현 시 사용할 파일은 엑셀파일이지만, 테스트 파일은 TXT파일로 작성하였다.
			while ((str = inputStream.readLine()) != null) {
				String[] values = str.split("//"); //구분자를 임의로 "//"로 넣어주었다.

				lectureID.add(values[0]);
				lectureClassID.add(values[1]);
				LectureName.add(values[2]);
				professor.add(values[3]);
				Time.add(values[4]);
				location.add(values[5]);
			}
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<lectureID.size(); i++){
			timeBool.add(true);
		}

	}

	// 강의의 우선순위 지정하는 메소드
	// 실제 프로그램에선 우선순위를 졸업요건과 학기, 사용자가 입력한 우선순위등을 고려하여
	// 설정하지만 시간표알고리즘을 위한 테스트파일이므로 우선순위가 이렇게 있다고 가정하였다.
	public void setPriority() {
		for (int i = 0; i < lectureID.size(); i++) {
			int num;
			switch (lectureID.get(i)) {
			case "CSE2013":
				num = 1;
				break;
			case "CSE2014":
				num = 2;
				break;
			case "CSE2015":
				num = 3;
				break;
			case "CSE2016":
				num = 4;
				break;
			case "CSE2017":
				num = 5;
				break;
			case "CSE2020":
				num = 6;
				break;
			case "CSE2022":
				num = 7;
				break;
			case "CSE2023":
				num = 8;
				break;
			case "CSE4034":
				num = 9;
				break;
			case "CSE4035":
				num = 10;
				break;
			case "CSE4036":
				num = 11;
				break;
			case "CSE4038":
				num = 12;
				break;
			case "CSE4041":
				num = 13;
				break;
			case "CSE4046":
				num = 14;
				break;
			case "CSE4052":
				num = 15;
				break;
			case "CSE4058":
				num = 16;
				break;
			case "CSE4066":
				num = 17;
				break;
			case "CSE4067":
				num = 18;
				break;
			case "CSE4070":
				num = 19;
				break;
			case "CSE4072":
				num = 20;
				break;

			default:
				num = 30;

			}
			priority.add(num);
		}

	}

	//시간에 따라 시간표에 들어갈 행을 지정해주는 메소드이다.
	private int getTableRow(String time) {
		switch (time) {
		case "0900":
			return 1;
		case "0930":
			return 2;
		case "1000":
			return 3;
		case "1030":
			return 4;
		case "1100":
			return 5;
		case "1130":
			return 6;
		case "1200":
			return 7;
		case "1230":
			return 8;
		case "1300":
			return 9;
		case "1330":
			return 10;
		case "1400":
			return 11;
		case "1430":
			return 12;
		case "1500":
			return 13;
		case "1530":
			return 14;
		case "1600":
			return 15;
		case "1630":
			return 16;
		case "1700":
			return 17;
		case "1730":
			return 18;
		case "1800":
			return 19;
		case "1830":
			return 20;
		case "1900":
			return 21;
		case "1930":
			return 22;
		case "2000":
			return 23;
		case "2030":
			return 24;
		default:
			return -1;
		}
	}

	//강의 시간에 따라 시간표에 들어갈 열을 지정해주는 메소드이다.
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

	ArrayList<Integer> priorityIndex=new ArrayList<Integer>(); //각 우선순위가 담고 있는 인덱스 수
	ArrayList<Boolean> IsPriorityIn=new ArrayList<Boolean>();
	// 데이터의 강의들이 학생이 다 들을 수 있는 과목이고, 추천받은 강의라고 가정을 하였다.
	public void CompleteTable() {
		//우선순위를 기반으로 시간표 자동작성하는 알고리즘
		/* 여기 다시 코딩해야함 */
		int priorityNum=1;
		int index_count=0;
		for(int i=0; i<priority.size()-1; i++){  //우선순위 인덱스를 담을 반복문
			index_count++;
			if(priority.get(i+1)==(priorityNum+1))
			{
				IsPriorityIn.add(false);
				priorityIndex.add(index_count);
				index_count=0;
				priorityNum++;
			}
		}
		
		priorityNum=1;
		//int count=4;  //담을 강의수
		
		getLecture(priorityNum, 0, 4);
		
	}
	
	//재귀로 할 것 우선순위를 container에 담아 재귀로 구현
	//탈출조건 생각해봐야함
	int count=2;
	private void getLecture(int priorityNum, int index, int count){
		if(!IsPriorityIn.get(priorityNum-1)&&(count!=0)){  //이번 우선순위에서 들어갔는 지 여부와 아직 더 들어가야할 강의 수 카운트
			for(int i=index; i<priorityIndex.get(priorityNum-1);i++){
				if(isTableEmpty(i)&&!IsPriorityIn.get(priorityNum-1)){
					putTable(i);
					IsPriorityIn.set(priorityNum-1, true); //이번 우선순위에서 테이블에 들어갔으므로..
					getLecture(priorityNum+1, index+priorityIndex.get(priorityNum-1), --count); //다음 우선순위로 넘어간다.
				}
				
				if(IsPriorityIn.get(priorityNum)){ //다음 우선순위에서 테이블에 들어갔거나 들어갈 수 없다면,
					return;
				}
				else if(IsPriorityIn.get(priorityNum-1)&&!IsPriorityIn.get(priorityNum)&&(count!=0)){  
					//이번 우선순위에서 테이블에 들어갔지만 다음 우선순위 테이블에서 안 들어갔다면, 그리고 더 넣어야한다면,
					if(i==(index+priorityIndex.get(priorityNum-1)-1)) //마지막 index이면,
					{
						IsPriorityIn.set(priorityNum, true); //다음 우선순위를 true로 만든다.
						getLecture(priorityNum+1, index+priorityIndex.get(priorityNum-1), count); //다음 우선순위로 넘어간다.
					}
					else  //마지막 인덱스가 아니라면,
					{
						IsPriorityIn.set(priorityNum-1, false); //이번 우선순위를 false로 만든다.
						deleteTable(i);
						continue;
					}
				}
			}
		}
		if(!IsPriorityIn.get(priorityNum-1)) //이번 우선순위에서 안 들어갔다면,
		{
			getLecture(priorityNum+1, index+priorityIndex.get(priorityNum-1), count); //다음 우선순위로 넘어간다.
		}
/*
		if(count!=0)
			getLecture(priorityNum+1, index+priorityIndex.get(priorityNum-1), count); //다음 우선순위로 넘어간다.
		else
			return;*/

	}
	
	private void putTable(int index){  //시간표에 집어넣는 메소드
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			table[j][column] = lectureClassID.get(index) + LectureName.get(index);
		}
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			table[j][column] = lectureClassID.get(index) + LectureName.get(index);
		}
	}
	
	private void deleteTable(int index){ //시간표에서 지우는 메소드
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			table[j][column] = "";
		}
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			table[j][column] = "";
		}
	}

	private boolean isTableEmpty(int index) { // 테이블이 비어있는 지 검사하는 메소드
		//첫번째날 강의시간
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			if (table[j][column] != "")
				return false;
		}
		//두번째날 강의시간
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			if (table[j][column] != "")
				return false;
		}
		return true;
	}

	public void print() { // for test

		for (int i = 0; i < lectureID.size(); i++) {
			System.out.println("강의코드: " + lectureID.get(i) + "-" + lectureClassID.get(i) + ", 강의이름: "
					+ LectureName.get(i) + ", 우선순위: " + priority.get(i));
		}

		/*
		 * for (int i = 0; i < Time.size(); i++) {
		 * System.out.println(Time.get(i)); System.out.println(firstDay.get(i) +
		 * startTimeFirst.get(i) + endTimeFirst.get(i) + secondDay.get(i) +
		 * startTimeSecond.get(i) + endTimeSecond.get(i)); }
		 */

		for (int j = 0; j < 6; j++) {
			System.out.print(table[0][j] + "                                        ");
		}
		System.out.println();
		for (int i = 1; i < 25; i++) {
			for (int j = 0; j < 6; j++) {
				if (table[i][j] == "")
					System.out.print("                 |");
				else
					System.out.print(table[i][j] + "         |");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeTable2 T = new TimeTable2(); //객체 생성
		T.readFile();
		T.splitTime();
		T.setPriority();
		T.CompleteTable();
		T.print();

	}

}
