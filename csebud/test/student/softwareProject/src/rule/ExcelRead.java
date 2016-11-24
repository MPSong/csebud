package rule;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	private String temp_LectureCode;
	private String temp_courseMake_Up;
	private String temp_Credit;
	private String temp_Grade;
	private boolean temp_IsEnglishCourse;

	public ArrayList<Course> getExcelData(String filepath, String tableName) {
		// public ArrayList<Course> getExcelData(String filepath, String
		// tableName){
		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			FileInputStream input = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(input);

			XSSFSheet sheet = workbook.getSheetAt(0); // 성적은 시트가 하나만 존재하므로, 0을 준다.

			int totalRow = sheet.getPhysicalNumberOfRows(); // 행의 수를 받아온다.
			// 학수강좌번호(G), 학점(K), 등급(L), 재수강구분(N), 원어강의종류(V)
			for (int rowIndex = 1; rowIndex < totalRow; rowIndex++) { // 행을 읽는다.
				XSSFRow row = sheet.getRow(rowIndex);
				if (row != null) {
					int totalCell = row.getPhysicalNumberOfCells(); // 셀의 수를
																	// 읽는다.

					temp_LectureCode = getCellValue(row, 6); // 학수강좌번호
					temp_courseMake_Up = getCellValue(row, 13); // 재수강구분
					temp_Credit = getCellValue(row, 10); // 학점
					temp_Grade = getCellValue(row, 11); // 등급
					String EnglishCourse = getCellValue(row, 21); // 원어강의종류
					if(temp_courseMake_Up.equals("OLD재수강"))
					{
						continue;
					}
					else{
						if (EnglishCourse.equals("영어")) {
							temp_IsEnglishCourse = true;
						} else
							temp_IsEnglishCourse = false;
						courses.add(new Course(temp_LectureCode, temp_Credit, temp_Grade,
								temp_IsEnglishCourse));
					}
					
					System.out.println(temp_LectureCode + " " + temp_courseMake_Up + " " + temp_Credit + " "
							+ temp_Grade + " " + temp_IsEnglishCourse);
				}
			}
			System.out.println("");
		} catch (Exception e) { // 에러 검사
			e.printStackTrace(System.out);
		}

		return courses;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelRead excel = new ExcelRead();
		excel.getExcelData("2012.xlsx", null);
	}
}
