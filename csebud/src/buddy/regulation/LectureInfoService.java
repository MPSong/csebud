package buddy.regulation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LectureInfoService {
	
	@Autowired LectureInfoDao dao;
	
	public void add(LectureInfo lectureInfo){
		dao.add(lectureInfo);
	}
	
	public void update(LectureInfo lectureInfo){
		dao.update(lectureInfo);
	}
	
	public LectureInfo get(String Lcode){
		return dao.get(Lcode);
	}

	
	public List<LectureInfo> list(){
		return dao.list();
	}
	
	public void delete(String Lcode){
		dao.delete(Lcode);
	}
	
}