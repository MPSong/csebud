package buddy.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import buddy.domain.Member;

@Repository
public class MemberDaoIbatis implements MemberDao {
	
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	public void add(Member member) {
		sqlMapClientTemplate.insert("Member.add", member);
	}

	public void delete(String id) {
		sqlMapClientTemplate.delete("Member.delete", id);
	}

	public Member get(String id) {
		return (Member) sqlMapClientTemplate.queryForObject("Member.get", id);
	}
	
	public void update(Member member) {
		sqlMapClientTemplate.update("Member.update", member);	
	}

	@SuppressWarnings("unchecked")
	public List<Member> list() {
		return sqlMapClientTemplate.queryForList("Member.list");
	}

}
