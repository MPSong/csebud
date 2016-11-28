package Timetable;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;
import database.ExcelRead;
import rule.*;

public class TimetableGenerator{
	
	private ArrayList<LectureCourse> lecture;
	private TimetableFactory factory;
	private ArrayList<Timetable> timetable;
	private ArrayList<LecturePossible> lecturePossible; // ���� �˰����� ������ ���ǵ�
	private int max_credit; //�ִ�� ���� credit(����ڷ� ���� �޴´�.)
	private int Major_count; //�ʼ������� ����� ��� ����
	private int first_priority_num;

	RegulationManager donggukRM;  //regulation�� �Ѱ��ϴ� ��
	
	public TimetableGenerator() throws SQLException{ // ������
		donggukRM=new RegulationManager();  //SQLException ���߿� ������ �ҵ�
		lecturePossible=new ArrayList<LecturePossible>();
		timetable=new ArrayList<Timetable>();
		factory=new TimetableFactory();
		first_priority_num=0;
	}

	public void CreatePossibleLecture(String filename, String regulation_num) { // Lecture�� LecturePossible�� ����ִ� �޼ҵ�
		Major_count=match_Regulation_to_Lecture(filename, regulation_num); // Lecture���� ���Ǹ� �̴´�.
		setPriority(Major_count); // �켱������ �����Ѵ�.
	}

	private int match_Regulation_to_Lecture(String filename, String regulation_num) {// Regulation���� �� ���� ���Ǹ� �޾� Lecture���� ���Ǹ� �̾��ִ��� ���ϴ� �޼ҵ�
		//Regulation���� ���� �ڵ�� 
		
		//������� TEST����
		rule.ExcelRead excel = new rule.ExcelRead(); //���� �д� �κ�
		String ExcelFileName=filename; //���� ���� �̸�
	    List<Course> cl = excel.getExcelData(ExcelFileName, null); //���� ������ �д´�.
	    
	    /*��ü ���������� �о���� �κ�*/
	    LectureInfo_ExcelRead excel_Lecture=new LectureInfo_ExcelRead();
	    ArrayList<LectureCourse> Semester_Lecture=new ArrayList<LectureCourse>();
	    Semester_Lecture=excel_Lecture.getExcelData("Lecture.xlsx");
	    
	    int Major_Count=0; //�ʼ����񿡼� ���� ������ �����Ѵ�.
	    
	    //2012���� Regulation�� �����´�, �ʼ�����
	    List<Lecture> un = donggukRM.findRegulation(regulation_num).unMeetLectureList(cl, "must"); 
	    for(int i=0; i<un.size(); i++){
	    	String temp_Code=un.get(i).getLectureCode(); //���� �ڵ带 �޾ƿ´�.
	    	for(int j=0; j<Semester_Lecture.size(); j++){ //Lecture�� �޾Ƽ� ó��
	    		if(temp_Code.equals(Semester_Lecture.get(j).LectureInfo)){
	    			if(Semester_Lecture.get(j).LectureInfo.contains("CSE")){
		    			Major_Count++;
		    		}
	    			lecturePossible.add(new LecturePossible(Semester_Lecture.get(j).LectureInfo, Semester_Lecture.get(j).Division,
	    					Semester_Lecture.get(j).FirstWeek, Semester_Lecture.get(j).FirstStartTime, 
	    					Semester_Lecture.get(j).FirstEndTime, Semester_Lecture.get(j).SecondWeek,
	    					Semester_Lecture.get(j).SecondStartTime, Semester_Lecture.get(j).SecondEndTime, 
	    					Semester_Lecture.get(j).Credit, 0)); //Possible�� �ִ� �κ�
	    			//break;
	    		}
	    		
	    	}
	    }

	    un = donggukRM.findRegulation(regulation_num).unMeetLectureList(cl, "select"); //���� �ʼ�����
	    for(int i=0; i<un.size(); i++){
	    	String temp_Code=un.get(i).getLectureCode(); //���� �ڵ带 �޾ƿ´�.
	    	for(int j=0; j<Semester_Lecture.size(); j++){ //Lecture�� �޾Ƽ� ó��
	    		if(temp_Code.equals(Semester_Lecture.get(j).LectureInfo)){
	    			lecturePossible.add(new LecturePossible(Semester_Lecture.get(j).LectureInfo, Semester_Lecture.get(j).Division,
	    					Semester_Lecture.get(j).FirstWeek, Semester_Lecture.get(j).FirstStartTime, 
	    					Semester_Lecture.get(j).FirstEndTime, Semester_Lecture.get(j).SecondWeek,
	    					Semester_Lecture.get(j).SecondStartTime, Semester_Lecture.get(j).SecondEndTime, 
	    					Semester_Lecture.get(j).Credit, 1)); //Possible�� �ִ� �κ�
	    			//break;
	    		}
	    	}
	    }
	      
	    if(donggukRM.findRegulation(regulation_num).getMscMath() > donggukRM.findRegulation(regulation_num).MeetCredit(cl, "mscMath")) //���а���
	    {
	    	un = donggukRM.findRegulation(regulation_num).unMeetLectureList(cl, "mscMath");
	    	for(int i =0 ; i<un.size();i++ )
	    	{
	    		String temp_Code=un.get(i).getLectureCode(); //���� �ڵ带 �޾ƿ´�.
		    	for(int j=0; j<Semester_Lecture.size(); j++){ //Lecture�� �޾Ƽ� ó��
		    		if(temp_Code.equals(Semester_Lecture.get(j).LectureInfo)){
		    			lecturePossible.add(new LecturePossible(Semester_Lecture.get(j).LectureInfo, Semester_Lecture.get(j).Division,
		    					Semester_Lecture.get(j).FirstWeek, Semester_Lecture.get(j).FirstStartTime, 
		    					Semester_Lecture.get(j).FirstEndTime, Semester_Lecture.get(j).SecondWeek,
		    					Semester_Lecture.get(j).SecondStartTime, Semester_Lecture.get(j).SecondEndTime, 
		    					Semester_Lecture.get(j).Credit, 2)); //Possible�� �ִ� �κ�
		    			//break;
		    		}
		    	}
	    	}
	    	  
	    }
	    
	    if(donggukRM.findRegulation(regulation_num).getMscScience() > donggukRM.findRegulation(regulation_num).MeetCredit(cl, "mscScience")){//���а���
		      un = donggukRM.findRegulation(regulation_num).unMeetLectureList(cl, "mscScience");
		      for(int i =0 ; i<un.size();i++ )
		      {
		    	  String temp_Code=un.get(i).getLectureCode(); //���� �ڵ带 �޾ƿ´�.
			    	for(int j=0; j<Semester_Lecture.size(); j++){ //Lecture�� �޾Ƽ� ó��
			    		if(temp_Code.equals(Semester_Lecture.get(j).LectureInfo)){
			    			lecturePossible.add(new LecturePossible(Semester_Lecture.get(j).LectureInfo, Semester_Lecture.get(j).Division,
			    					Semester_Lecture.get(j).FirstWeek, Semester_Lecture.get(j).FirstStartTime, 
			    					Semester_Lecture.get(j).FirstEndTime, Semester_Lecture.get(j).SecondWeek,
			    					Semester_Lecture.get(j).SecondStartTime, Semester_Lecture.get(j).SecondEndTime, 
			    					Semester_Lecture.get(j).Credit, 2)); //Possible�� �ִ� �κ�
			    			//break;
			    		}
			    	}
		      }
	      }
	    
	    return Major_Count;
	      
	}

	private void setPriority(int Major_count) { //�켱������ ���ϴ� �޼ҵ�
		int temp_priority=1;
		Major_count+=1;
		ArrayList<LecturePossible> temp_Lecture=new ArrayList<LecturePossible>();

		for(int i=0; i<lecturePossible.size(); i++){ //�ʱ�ȭ
			temp_Lecture.add(null);
		}
		
		int First_Major_count=Major_count;
		boolean Is_no_major=false;
		for(int i=0; i<lecturePossible.size();i++){ //�켱���� ���� ����ִ´�.
			switch(lecturePossible.get(i).priority){
			case 0:
				if(lecturePossible.get(i).LectureInfo.contains("CSE")){ 
					lecturePossible.get(i).priority=temp_priority++;
					LecturePossible temp=lecturePossible.get(i);
					temp_Lecture.set(temp_priority-2, temp);
				}
				else{//������ �ƴϸ� �ڷ� �̷��.
					lecturePossible.get(i).priority=Major_count++;
					LecturePossible temp=lecturePossible.get(i);
					temp_Lecture.set(Major_count-2, temp);
					Is_no_major=true;
				}
				break;
			default:
				lecturePossible.get(i).priority=temp_priority++;
				LecturePossible temp=lecturePossible.get(i);
				temp_Lecture.set(temp_priority-2, temp);
			}
			if(temp_priority>=(First_Major_count)&&Is_no_major){
				while(temp_priority!=(Major_count))
					temp_priority++;
				Is_no_major=false;
			}
			
		}
		
		//���� ���� ������ �޾ƿ� ��
		
		lecturePossible=temp_Lecture;
		int real_priority=1;
		for(int i=1; i<lecturePossible.size(); i++){
			if(lecturePossible.get(i-1).LectureInfo.equals(lecturePossible.get(i).LectureInfo)){ //�� �ε����� ���������� ���ٸ�,
				lecturePossible.get(i).setPriority(real_priority);
			}
			else{
				lecturePossible.get(i).setPriority(++real_priority);
			}
		}
		
		for(int i=0; i<lecturePossible.size(); i++){
			if(lecturePossible.get(i).priority==1){ //ù ��° �켱���� ������ ī��Ʈ�Ѵ�.
				first_priority_num++;
			}
			else if(lecturePossible.get(i).priority==2)
				break;
		}
		

		for(int i=0; i<lecturePossible.size(); i++){ //test
			System.out.println(lecturePossible.get(i).LectureInfo+" "+lecturePossible.get(i).priority);
		}
		
	}

	public void autoGenerateTimetable() { // Ÿ�����̺��� �����Ѵ�.
		timetable=factory.makeTimetable(lecturePossible, max_credit, first_priority_num);
	}
	
	public void setCredit_max(int max_credit){ //�ִ�� ���� ���� set
		this.max_credit=max_credit;
	}

}
