package rule;

public class StudentManager {
	public Student[]student;
	
	public Student getStudentInfo(String studentID){ //Student ������ ��ȯ�Ѵ�.		
		return findStudent(studentID);
	}
	
	public void getTimetable(){
		
	}
	
	public Student findStudent(String studentID){ //�л� ������ �ִ��� �˻��ϴ� �޼ҵ�
		for(int i=0; i<student.length; i++){
			if(student[i].getStudentID().equals(studentID))
				return student[i];
		}
		return null; //���ٸ� null�� ��ȯ�Ѵ�.
	}
	
	public void changeStudentInfo(String studentID){ //�л� ������ �����ϴ� �޼ҵ�
		Student s=findStudent(studentID); //ã�� �л�
		if(s!=null){
			s.UpdateStudentInfo(); //������ Update�Ѵ�.
		}
		else
			return;
	}
}
