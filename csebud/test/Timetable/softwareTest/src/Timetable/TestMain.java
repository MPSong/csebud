package Timetable;

import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		TimetableGenerator g=new TimetableGenerator();
		g.CreatePossibleLecture("2012.xlsx", "2012");
		g.setCredit_max(18);
		g.autoGenerateTimetable();
	}

}
