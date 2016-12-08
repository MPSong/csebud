package buddy.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentInfoDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(StudentInfo studentInfo){
		sqlMapClientTemplate.insert("StudentInfo.add", studentInfo);
	}
	
	public void update(StudentInfo studentInfo){
		sqlMapClientTemplate.update("StudentInfo.update", studentInfo);	
	}
	
	public StudentInfo get(String memberId){
		return (StudentInfo) sqlMapClientTemplate.queryForObject("StudentInfo.get", memberId);
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentInfo> list(){
		return sqlMapClientTemplate.queryForList("StudentInfo.list");
	}
	
	public void delete(String memberId){
		sqlMapClientTemplate.delete("StudentInfo.delete", memberId);
	}

}