package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;
import database.ExcelRead;


public class Test {
	
	public static String a2k(String str) {
	    String result = "";
	    if(str != null) {
	        try {
	            result = new String(str.toString().getBytes("KSC5601"),"8859_1");
	        }
	        catch(java.io.UnsupportedEncodingException e) {
	            result = "";
	        }
	    }
	    return result;
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		DataBase db =new DataBase("jdbc:mysql://localhost/csefriend","root","1111");
		
	
		List<String> sqls =ExcelRead.writeToMysql("C:\\Users\\sujin\\Desktop\\소공.xlsx", "regulation",0);
		for(int i=0;i<sqls.size();i++){
			db.UpdateSQL(sqls.get(i) );
		}
		
		
	}
	
	

}
