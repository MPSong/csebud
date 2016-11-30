package db.lecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ToDataBase {
   
   static Connection con=makeConnection();
   
   public static Connection makeConnection(){
      String url="jdbc:mysql://localhost/cse-buddy?useSSL=false";
      String id="root";
      String password="anwjrgoqud57";
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
         
         int Credit, boolean IsEnglish, int rnum){
      int tempEnglish; //boolean타입이 안돼서 int형으로 바꾸어준다.
      if(IsEnglish)
         tempEnglish=1;
      else
         tempEnglish=0;
      
      try{
         Statement stmt=con.createStatement();
         String s="INSERT INTO lecture (LectureCode, Division, LectureName, "
               + "Professor, FirstWeekday, FirstStartTime, FirstEndTime, "
               + "SecondWeekday, SecondStartTime, SecondEndTime, FirstClassroom, "
               + "SecondClassroom, Credit, IsEnglish, RNUM) VALUES ";
         
         s+="('"+LectureInfo+"','"+Division+"','"+LectureName+"','"+Professor+"','"
               +FirstWeek+"','"+FirstStartTime+"','"+FirstEndTime+"','"+SecondWeek+"','"
               +SecondStartTime+"','"+SecondEndTime+"','"
               +FirstClassroom+"','"+SecondClassroom+"',"+Credit+","+tempEnglish+","+rnum+")";

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
      lecture=excel.getExcelData("test/Lecture.xlsx", null);  //엑셀로 부터 읽어 객체에 저장한다.
      
      for(int i=0; i<lecture.size(); i++){ //데이터 베이스에 집어넣는다.
         int temp=addLecture(lecture.get(i).LectureInfo, lecture.get(i).Division, lecture.get(i).LectureName, 
               lecture.get(i).Professor, lecture.get(i).FirstWeek, lecture.get(i).FirstStartTime, 
               lecture.get(i).FirstEndTime, lecture.get(i).SecondWeek, lecture.get(i).SecondStartTime, 
               lecture.get(i).SecondEndTime, lecture.get(i).FirstClassroom, lecture.get(i).SecondClassroom, 
               lecture.get(i).Credit, lecture.get(i).IsEnglish, i+1);
         if(temp==1){
            System.out.println((i+1)+"번째 레코드 추가 성공");
         }
         else
            System.out.println((i+1)+"번째 레코드 추가 실패");
      }
      
   }
}
