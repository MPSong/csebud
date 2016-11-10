package buddy.member;

import java.util.List;

import buddy.domain.Member;

public interface MemberDao {
	
	void add(Member member);
	
	void update(Member member);
	
	Member get(String id);
	
	List<Member> list();
	
	void delete(String id);

}
