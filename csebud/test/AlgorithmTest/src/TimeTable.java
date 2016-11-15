import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class TimeTable {

	private ArrayList<String> lectureID = new ArrayList<String>(); // ���� ID
	private ArrayList<String> lectureClassID = new ArrayList<String>(); // �й�
	private ArrayList<String> LectureName = new ArrayList<String>(); // ���� �̸�
	private ArrayList<String> professor = new ArrayList<String>(); // ����
	private ArrayList<String> Time = new ArrayList<String>(); // ���� �ð�(����, ����)
	private ArrayList<String> location = new ArrayList<String>(); // ���� ���

	private ArrayList<String> firstDay = new ArrayList<String>(); // ù��° ��
	private ArrayList<String> startTimeFirst = new ArrayList<String>(); // ����
																		// ���۽ð�
	private ArrayList<String> endTimeFirst = new ArrayList<String>(); // ���� ����ð�

	private ArrayList<String> secondDay = new ArrayList<String>(); // �ι�° ��
	private ArrayList<String> startTimeSecond = new ArrayList<String>(); // ����
																			// ���۽ð�
	private ArrayList<String> endTimeSecond = new ArrayList<String>(); // ����
																		// ����ð�

	private ArrayList<Integer> priority = new ArrayList<Integer>(); //�켱����
	
	private ArrayList<Boolean> timeBool =new ArrayList<Boolean>();

	String[][] table;  //�ð�ǥ

	public TimeTable() { // ������
		table = new String[25][6];   
		//�ð�ǥ Ʋ�� �����ϴ� �κ�
		table[0][0] = "";
		table[0][1] = "��";
		table[0][2] = "ȭ";
		table[0][3] = "��";
		table[0][4] = "��";
		table[0][5] = "��";
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
		//Ʋ�� ������ ������ �κ��� ""�� �ʱ�ȭ�Ѵ�.
		for (int i = 1; i < 25; i++)
			for (int j = 1; j < 6; j++)
				table[i][j] = "";
	}

	//���� �ð��� �߶� ù��° ���� ����/����ð�, �ι�° ���� ����/����ð��� ���� �����ϴ� �żҵ��̴�.
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

	//Test ������ �д� �޼ҵ��̴�.
	public void readFile() {
		BufferedReader inputStream = null;

		try { // ���� �б�
			inputStream = new BufferedReader(new FileReader("timetable.txt"));

			String str;
			//���� ���� �� ����� ������ ��������������, �׽�Ʈ ������ TXT���Ϸ� �ۼ��Ͽ���.
			while ((str = inputStream.readLine()) != null) {
				String[] values = str.split("//"); //�����ڸ� ���Ƿ� "//"�� �־��־���.

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

	// ������ �켱���� �����ϴ� �޼ҵ�
	// ���� ���α׷����� �켱������ ������ǰ� �б�, ����ڰ� �Է��� �켱�������� ����Ͽ�
	// ���������� �ð�ǥ�˰����� ���� �׽�Ʈ�����̹Ƿ� �켱������ �̷��� �ִٰ� �����Ͽ���.
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

	//�ð��� ���� �ð�ǥ�� �� ���� �������ִ� �޼ҵ��̴�.
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

	//���� �ð��� ���� �ð�ǥ�� �� ���� �������ִ� �޼ҵ��̴�.
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

	// �������� ���ǵ��� �л��� �� ���� �� �ִ� �����̰�, ��õ���� ���Ƕ�� ������ �Ͽ���.
	public void CompleteTable() {
		//�켱������ ������� �ð�ǥ �ڵ��ۼ��ϴ� �˰���
		/* ���� �ٽ� �ڵ��ؾ��� */
		Stack<Integer> stack=new Stack<>(); //�켱������ ���� Stack
		int priorityNum=1;
		int lastpriority=1;
		int count=0;  //���� ���� ��
		ArrayList<Integer> exceptpriority=new ArrayList<>(); //���ܵ� �켱���� ���� ArrayList
		do{
			int index=getLecture(priorityNum);  //Ž���� index
			if(index==-1){  
				if(stack.empty()){ //�ٽ� ó������ priorityNum�� ���ƿ���,
					exceptpriority.add(lastpriority);
					for(int k : exceptpriority){
						for(int i=0; i<timeBool.size(); i++){
							if(i==k)
								timeBool.set(i, false);
							else
								timeBool.set(i, true);
						}
					}
					continue;
				}
				//���̺��� ����
				int priorIndex=stack.pop();
				deleteTable(priorIndex);
				count--;
				priorityNum--;
			}
			else{
				//���̺� �����ϴ� �κ�
				putTable(index);
				count++;
				stack.push(index);
				if(lastpriority<=priorityNum)
					lastpriority=priorityNum;
				priorityNum++;
				
			}
			
			
		}while(count<3);
	}
	
	private int getLecture(int priorityNum){
		for(int i=0; i<LectureName.size(); i++){
			if(priority.get(i)==priorityNum){
				if(timeBool.get(i)){
					if(isTableEmpty(i)){
						timeBool.set(i, false);
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	private void putTable(int index){  //�ð�ǥ�� ����ִ� �޼ҵ�
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			table[j][column] = lectureClassID.get(index) + LectureName.get(index);
		}
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			table[j][column] = lectureClassID.get(index) + LectureName.get(index);
		}
	}
	
	private void deleteTable(int index){ //�ð�ǥ���� ����� �޼ҵ�
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			table[j][column] = "";
		}
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			table[j][column] = "";
		}
	}

	private boolean isTableEmpty(int index) { // ���̺��� ����ִ� �� �˻��ϴ� �޼ҵ�
		//ù��°�� ���ǽð�
		int column = getTableColumn(firstDay.get(index));
		for (int j = getTableRow(startTimeFirst.get(index)); j < getTableRow(endTimeFirst.get(index)); j++) {
			if (table[j][column] != "")
				return false;
		}
		//�ι�°�� ���ǽð�
		column = getTableColumn(secondDay.get(index));
		for (int j = getTableRow(startTimeSecond.get(index)); j < getTableRow(endTimeSecond.get(index)); j++) {
			if (table[j][column] != "")
				return false;
		}
		return true;
	}

	public void print() { // for test

		for (int i = 0; i < lectureID.size(); i++) {
			System.out.println("�����ڵ�: " + lectureID.get(i) + "-" + lectureClassID.get(i) + ", �����̸�: "
					+ LectureName.get(i) + ", �켱����: " + priority.get(i));
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
		TimeTable T = new TimeTable(); //��ü ����
		T.readFile();
		T.splitTime();
		T.setPriority();
		T.CompleteTable();
		T.print();

	}

}
