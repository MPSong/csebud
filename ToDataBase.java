package rule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectureInfo_ExcelRead excel = new LectureInfo_ExcelRead();
		ArrayList<LectureCourse> lecture=new ArrayList<LectureCourse>();
		lecture=excel.getExcelData("Lecture.xlsx", null);
		
		try{
			Connection con = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost",
                  "root", "1111");

            
         } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());

		}
	}

}
