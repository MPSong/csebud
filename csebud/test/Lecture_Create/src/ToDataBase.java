

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ToDataBase {
	
	static Connection con=makeConnection();
	
	public static Connection makeConnection(){
		String url="jdbc:mysql://localhost/song?useSSL=false";
		String id="root";
		String password="1111";
		con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, id, password);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	private static int addLecture(String LectureInfo, String Division, String LectureName, String Professor,

			String FirstWeek, String FirstStartTime, String FirstEndTime,

			String SecondWeek, String SecondStartTime, String SecondEndTime,

			String FirstClassroom, String SecondClassroom,

			int Credit, boolean IsEnglish){
		int tempEnglish; //booleanŸ���� �ȵż� int������ �ٲپ��ش�.
		if(IsEnglish)
			tempEnglish=1;
		else
			tempEnglish=0;
		
		try{
			Statement stmt=con.createStatement();
			String s="INSERT INTO lectureinfo (LectureCode, Division, LectureName, "
					+ "Professor, FirstWeekday, FirstStartTime, FirstEndTime, "
					+ "SecondWeekday, SecondStartTime, SecondEndTime, FirstClassroom, "
					+ "SecondClassroom, Credit, IsEnglish) VALUES ";
			
			s+="('"+LectureInfo+"','"+Division+"','"+LectureName+"','"+Professor+"','"
					+FirstWeek+"','"+FirstStartTime+"','"+FirstEndTime+"','"+SecondWeek+"','"
					+SecondStartTime+"','"+SecondEndTime+"','"
					+FirstClassroom+"','"+SecondClassroom+"',"+Credit+","+tempEnglish+")";

			System.out.println(s);
			return stmt.executeUpdate(s); 
		}catch(SQLException e){ 
			
			e.printStackTrace();
			System.exit(0);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectureInfo_ExcelRead excel = new LectureInfo_ExcelRead();
		ArrayList<LectureCourse> lecture=new ArrayList<LectureCourse>();
		lecture=excel.getExcelData("Lecture.xlsx", null);  //������ ���� �о� ��ü�� �����Ѵ�.
		
		
		for(int i=0; i<lecture.size(); i++){ //������ ���̽��� ����ִ´�.
			int temp=addLecture(lecture.get(i).LectureInfo, lecture.get(i).Division, lecture.get(i).LectureName, 
					lecture.get(i).Professor, lecture.get(i).FirstWeek, lecture.get(i).FirstStartTime, 
					lecture.get(i).FirstEndTime, lecture.get(i).SecondWeek, lecture.get(i).SecondStartTime, 
					lecture.get(i).SecondEndTime, lecture.get(i).FirstClassroom, lecture.get(i).SecondClassroom, 
					lecture.get(i).Credit, lecture.get(i).IsEnglish);
			if(temp==1){
				System.out.println(i+"��° ���ڵ� �߰� ����");
			}
			else
				System.out.println(i+"��° ���ڵ� �߰� ����");
		}
		
	}
}
