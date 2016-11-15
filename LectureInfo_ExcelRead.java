package rule;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LectureInfo_ExcelRead {	
	private String LectureInfo;  //학수번호
	private String Division; //분반
	
	private String LectureName; //강의이름
	private String Professor; //교원명
	
	private String FirstWeek; //첫번째 요일
	private String FirstStartTime;  //첫번째 시작시각
	private String FirstEndTime;  //첫번째 종료시각
	
	private String SecondWeek;  //두번째 요일
	private String SecondStartTime; //두번째 시작시각
	private String SecondEndTime;  //두번째 종료시각
	
	private String FirstClassroom;  //첫번째 강의실
	private String SecondClassroom;  //두번째 강의실
	
	private int Credit; //학점
	private boolean IsEnglish; //영어강의 여부

	public ArrayList<LectureCourse> getExcelData(String filepath, String tableName) {
		ArrayList<LectureCourse> tempLecture=new ArrayList<LectureCourse>();
		
		String temp_LectureCode;  //학수강좌번호
		String temp_Campus;  //수업 캠퍼스
		String temp_Time;  //강의 시간
		String temp_Classroom;  //강의실
		boolean temp_IsEnglishCourse; //영어강의 여부
		
		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);

			XSSFSheet sheet = workbook.getSheetAt(0); // 성적은 시트가 하나만 존재하므로, 0을 준다.														
			
			int totalRow = sheet.getPhysicalNumberOfRows(); // 행의 수를 받아온다.
		
			for (int rowIndex = 1; rowIndex < totalRow-1; rowIndex++) { // 행을 읽는다.
				XSSFRow row = sheet.getRow(rowIndex);
				if (row != null) {
					temp_LectureCode=getCellValue(row, 3); //학수강좌번호
					splitLecture(temp_LectureCode);
					LectureName=getCellValue(row, 4);  //강좌 이름
					Professor=getCellValue(row, 5);  //교원명
					temp_Campus=getCellValue(row, 6);  //수업 캠퍼스
					
					temp_Time=getCellValue(row, 7);  //강의 시간
					splitTime(temp_Time);
					temp_Classroom=getCellValue(row, 8);  //강의실
					splitClassroom(temp_Classroom);
					Credit=Integer.parseInt(getCellValue(row, 9));  //학점
					
					String EnglishCourse=getCellValue(row, 17);   //원어강의종류
					if(EnglishCourse=="영어"){
						temp_IsEnglishCourse=true;
					}
					else temp_IsEnglishCourse=false;
					
					
					//for test
					/*System.out.print(LectureInfo+" "+Division+" "+LectureName+" "+Professor+" "
							+FirstWeek+" "+FirstStartTime+" "+FirstEndTime+" "+SecondWeek+" "
							+SecondStartTime+" "+SecondEndTime+" "+FirstClassroom+" "+SecondClassroom+" "
							+Credit+" "+EnglishCourse);	*/
					
					//객체에 쓰는 부분
					if(temp_Campus.equals("서울")){
						LectureCourse temp=new LectureCourse(LectureInfo, Division, LectureName, Professor, 
								FirstWeek, FirstStartTime, FirstEndTime, SecondWeek, SecondStartTime, SecondEndTime,
								FirstClassroom, SecondClassroom, Credit, IsEnglish );
						tempLecture.add(temp);
					}
					else
					{
						continue;
					}
				}
				//System.out.println("");
			}
		}
		catch (Exception e) {  //에러 검사
			e.printStackTrace(System.out);
		}
		
		return tempLecture;
		
	}
	
	public String getCellValue(XSSFRow row, int columnIndex) {
		XSSFCell cell = row.getCell(columnIndex); // 각 셀을 가져온다.

		String value = ""; // 셀의 값을 받을 변수
		if (cell == null) { // 셀이 비어있다면 NULL
			return null;
		} else {
			// 타입별로 내용 읽기
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_FORMULA:
				value = cell.getCellFormula();
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				value = cell.getNumericCellValue() + "";
				break;
			case XSSFCell.CELL_TYPE_STRING:
				value = cell.getStringCellValue() + "";
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				value = cell.getBooleanCellValue() + "";
				break;
			case XSSFCell.CELL_TYPE_ERROR:
				value = cell.getErrorCellValue() + "";
				break;
			default:
				value = null;
			}
		}
		return value;

	}
	
	private void splitLecture(String Lecture){
		String[] tempValue=Lecture.split("-");
		
		LectureInfo=tempValue[0];
		Division=tempValue[1];
	}
	
	private void splitTime(String time){
		String temp_first="";
		String temp_Second="";
		
		if(time.equals("")){
			FirstWeek="";
			SecondWeek="";
			FirstStartTime="";
			FirstEndTime="";
			SecondStartTime="";
			SecondEndTime="";
		}
		else if(time.contains(","))  // 두 번 강의하면,
		{
			String[] tempValue=time.split(",");  //,로 한번 자른다.
			
			temp_first=tempValue[0];
			temp_Second=tempValue[1];
			FirstWeek=temp_first.substring(0,1);   //요일 집어넣는 것
			SecondWeek=temp_Second.substring(0,1);  //요일 집어넣는 것
			
			tempValue=temp_first.split("/");  //다음 /로 한번 자른다.
			String temp_LecTime=tempValue[1];
			tempValue=temp_Second.split("/");
			String temp_LecTime2=tempValue[1];
			temp_LecTime=temp_LecTime.replaceAll("[^0-9]", "");  //숫자만 남기고 지운다.
			temp_LecTime2=temp_LecTime2.replaceAll("[^0-9]", "");  //숫자만 남기고 지운다.
			
			FirstStartTime=temp_LecTime.substring(0,4);
			FirstEndTime=temp_LecTime.substring(4,8);
			SecondStartTime=temp_LecTime2.substring(0,4);
			SecondEndTime=temp_LecTime2.substring(4,8);
		}
		else{  //한 번 강의하면,
			temp_first=time;
			temp_Second="";
			FirstWeek=temp_first.substring(0,1);
			SecondWeek="";
			
			String []tempValue=temp_first.split("/");  //다음 /로 한번 자른다.
			String temp_LecTime=tempValue[1];
			temp_LecTime=temp_LecTime.replaceAll("[^0-9]", "");  //숫자만 남기고 지운다.
			FirstStartTime=temp_LecTime.substring(0,4);
			FirstEndTime=temp_LecTime.substring(4,8);
			SecondStartTime="";
			SecondEndTime="";
		}
		
		
	}

	private void splitClassroom(String classroom){
		String temp_first="";
		String temp_Second="";
		
		if(classroom.equals("")){
			FirstClassroom="";
			SecondClassroom="";
		}
		else if(classroom.contains(","))  // 두 번 강의하면,
		{
			String[] tempValue=classroom.split(",");  //,로 한번 자른다.
			
			temp_first=tempValue[0];
			temp_Second=tempValue[1];

			FirstClassroom=temp_first.substring(temp_first.indexOf('(')+1);  //다음 (로 한번 자른다.
			SecondClassroom=temp_Second.substring(temp_Second.indexOf('(')+1);  //다음 (로 한번 자른다.
			
			FirstClassroom=new StringBuilder(FirstClassroom).reverse().toString();
			FirstClassroom=FirstClassroom.substring(FirstClassroom.indexOf(')')+1);  //다음 (로 한번 자른다.
			FirstClassroom=new StringBuilder(FirstClassroom).reverse().toString();
			
			SecondClassroom=new StringBuilder(SecondClassroom).reverse().toString();
			SecondClassroom=SecondClassroom.substring(SecondClassroom.indexOf(')')+1);  //다음 (로 한번 자른다.
			SecondClassroom=new StringBuilder(SecondClassroom).reverse().toString();
		}
		else{  //한 번 강의하면,
			temp_first=classroom;
			temp_Second="";
			SecondClassroom="";
			
			FirstClassroom=temp_first.substring(temp_first.indexOf('(')+1);  //다음 (로 한번 자른다.
			FirstClassroom=new StringBuilder(FirstClassroom).reverse().toString();
			FirstClassroom=FirstClassroom.substring(FirstClassroom.indexOf(')')+1);  //다음 (로 한번 자른다.
			FirstClassroom=new StringBuilder(FirstClassroom).reverse().toString();
		}
	}
	
	/*
	 * public static List<String> writeToMysql(String filepath, String
	 * tableName) {
	 * 
	 * List<String> sqls = new ArrayList(); try {
	 * 
	 * FileInputStream input = new FileInputStream(filepath); XSSFWorkbook
	 * workbook = new XSSFWorkbook(input);
	 * 
	 * int rowindex = 0; int columnindex = 0;
	 * 
	 * XSSFSheet sheet = workbook.getSheetAt(0); // �뻾�쓽 �닔 int rows =
	 * sheet.getPhysicalNumberOfRows(); // row 泥ル쾲吏몃뒗 �젣紐⑹쓣 �굹���궡誘�濡� �떎�젣
	 * �뜲�씠�꽣�씤 1遺��꽣 �씫�뒗�떎. for (rowindex = 0; rowindex < rows; rowindex++) {
	 * // �뻾�쓣�씫�뒗�떎 XSSFRow row = sheet.getRow(rowindex); if (row != null) { //
	 * ���쓽 �닔 int cells = row.getPhysicalNumberOfCells(); List<XSSFCell>
	 * cellList = new ArrayList(); // sqㅣ에 학수강좌번호(G), 등급(L), 재수강구분(N), 원어강의종류(V)
	 * String sql = "INSERT INTO " + tableName + " VALUES ('"; for (columnindex
	 * = 0; columnindex < cells; columnindex++) {
	 * 
	 * if (columnindex > 0) { sql = sql + "','"; } sql = sql +
	 * row.getCell(columnindex).toString();
	 * 
	 * } sql = sql + "')"; System.out.println(sql); sqls.add(sql); } }
	 * 
	 * input.close(); System.out.println("Success import excel to mysql table");
	 * } catch (Exception e) { e.printStackTrace(System.out); }
	 * 
	 * return sqls; }
	 */
}
