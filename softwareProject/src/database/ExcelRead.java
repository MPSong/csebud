package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static List<String> writeToMysql(String filepath,String tableName,int sheetnum)  {
		
		List<String> sqls =new ArrayList();
		try {
			
	        FileInputStream input = new FileInputStream(filepath);
	        XSSFWorkbook workbook=new XSSFWorkbook(input);
	        
	        int rowindex=0;
	        int columnindex=0;

	        XSSFSheet sheet=workbook.getSheetAt(sheetnum);
	        //행의 수
	        int rows=sheet.getPhysicalNumberOfRows();
	        // row 첫번째는 제목을 나타내므로 실제 데이터인 1부터 읽는다.
	        for(rowindex=0;rowindex<rows;rowindex++){
	            //행을읽는다
	            XSSFRow row=sheet.getRow(rowindex);
	            if(row !=null){
	                //셀의 수
	                int cells=row.getPhysicalNumberOfCells();
	                List<XSSFCell> cellList =new ArrayList();
	                String sql="INSERT INTO "+tableName+" VALUES ('";
	                for(columnindex=0;columnindex<cells;columnindex++){

	                	if(columnindex>0)
	                	{
	                		sql=sql+"','";
	                	}
	                	sql=sql+row.getCell(columnindex).toString();

	                }
	                sql=sql+"')";
	                System.out.println(sql);
	                sqls.add(sql);
	            }
	        }
	        
	        input.close();
	        System.out.println("Success import excel to mysql table");
	    } catch (Exception e) {
	    	e.printStackTrace(System.out);
	    }
	            
		return sqls;
	}



}
