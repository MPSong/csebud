package buddy.regulation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// 컴공과 MSC, 전공 교과과목 불러옴
public class RegulationManager {

	public List<RegulationInfo> RegulationInfoList = new ArrayList<RegulationInfo>();
	
	public static List<Regulation> RegulationList = new ArrayList<Regulation>();
	public static List<LectureInfo> cseTypeLecture = new ArrayList<LectureInfo>();
	
	static int a;
	
	@Autowired LectureInfoService lectureInfoService;
	
	public void init(List<RegulationInfo> regulations, List<LectureInfo> lectures){
		
		System.out.println("0");
		RegulationInfoList.addAll(regulations);
		System.out.println("1");
		cseTypeLecture.addAll(lectures);
		System.out.println("2");
		System.out.println("3");
		
		for(int i=0; i<regulations.size(); i++){
			
			System.out.println("4");
			Regulation regulation = new Regulation();
			System.out.println("5");
			regulation.setSelect(0, regulations.get(i).getYear());
			regulation.setSelect(1, regulations.get(i).getGross());
			regulation.setSelect(2, regulations.get(i).getMsc_gross());
			regulation.setSelect(3, regulations.get(i).getMsc_math());
			regulation.setSelect(4, regulations.get(i).getMsc_science());
			regulation.setSelect(5, regulations.get(i).getMsc_process());
			regulation.setSelect(6, regulations.get(i).getMajor_gross());
			regulation.setSelect(7, regulations.get(i).getMajor_design());
			regulation.setSelect(8, regulations.get(i).getEnglish_major());
			regulation.setSelect(9, regulations.get(i).getEnglish_gross());
			regulation.setSelect(10, regulations.get(i).getCommon());
			regulation.setSelect(11, regulations.get(i).getPrime());
			regulation.setSelect(12, regulations.get(i).getBasic());
			regulation.setYear(regulations.get(i).getYear());
			System.out.println("6");
			RegulationList.add(regulation);
			System.out.println("7");
			
		}
		
	}

	public List<RegulationInfo> getRegulationInfoList() {
		return RegulationInfoList;
	}

	public void setRegulationInfoList(List<RegulationInfo> regulationInfoList) {
		RegulationInfoList = regulationInfoList;
	}
	
	public LectureInfo findLecture(String lecturecode) {
		      
		if (cseTypeLecture==null)
		{
			System.out.println(" cseTypeLecture is not initailized");
			return null;
		}
		for (int i = 0; i < cseTypeLecture.size(); i++) {
			//System.out.println(RegulationList.get(i).getYear());
			if (cseTypeLecture.get(i).getYear().equals(lecturecode)) 
			{
				return cseTypeLecture.get(i);
			}
		}
		
		return null;
	
	}

	public Regulation findRegulation(String year) {
	      
	if (RegulationList==null)
	{
		System.out.println(" RegulationList is not initailized");
		return null;
	}
	
	for (int i = 0; i < RegulationList.size(); i++) {
		//System.out.println(RegulationList.get(i).getYear());
		if (RegulationList.get(i).getYear().equals(year)) 
		{	
			return RegulationList.get(i);
		}
	}
		return null;
	}

}
