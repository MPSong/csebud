package buddy.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	
	@Autowired MemberDao dao;
	
	public void add(Member member){
		dao.add(member);
	}
	
	public void update(Member member){
		dao.update(member);
	}
	
	public Member get(String id){
		return dao.get(id);
	}

	
	public List<Member> list(){
		return dao.list();
	}
	
	public void delete(String id){
		dao.delete(id);
	}

	public Member findByIdAndPwd(String id, String pass){
		
		Member member = new Member();
		
		if(id.equals(dao.get(id).getId())&&pass.equals(dao.get(id).getPass())){
		// id&password 매칭시 Account 객체 반환	
			member = dao.get(id);
			return member;
			
		}
		else{
			
			return null;
			
		}
		
	}
	
}
