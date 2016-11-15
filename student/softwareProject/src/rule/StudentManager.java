package rule;

public class StudentManager {
	public Student[]student;
	
	public Student getStudentInfo(String studentID){ //Student 정보를 반환한다.		
		return findStudent(studentID);
	}
	
	public void getTimetable(){
		
	}
	
	public Student findStudent(String studentID){ //학생 정보가 있는지 검사하는 메소드
		for(int i=0; i<student.length; i++){
			if(student[i].getStudentID().equals(studentID))
				return student[i];
		}
		return null; //없다면 null을 반환한다.
	}
	
	public void changeStudentInfo(String studentID){ //학생 정보를 변경하는 메소드
		Student s=findStudent(studentID); //찾은 학생
		if(s!=null){
			s.UpdateStudentInfo(); //정보를 Update한다.
		}
		else
			return;
	}
}
