package rule;

import java.util.ArrayList;
import java.util.List;

public class LectureManager {

	static List<Lecture> donggukLecture;
	static List<Lecture> current;
	
	
	public LectureManager() {
		super();
		donggukLecture =new ArrayList();
	}

	static List<String> major;
	static List<String> major_design;
	static List<String> msc_math;
	static List<String> msc_gross;
	static List<String> msc_sience;
	static List<String> msc_process;
	static List<String> common;
	static List<String> prime;
	static List<String> basic;
	
	
	public String whatIsType(String lectureCode)
	{
		if(this.major_design.contains(lectureCode))
		{
			return "major_design";
		}
		else if(this.major.contains(lectureCode))
		{
			return "major";
		}
		else if(this.msc_math.contains(lectureCode))
		{
			return "msc_math";
		}
		else if(this.msc_sience.contains(lectureCode))
		{
			return "msc_sience";
		}
		else if(this.msc_process.contains(lectureCode))
		{
			return "msc_process";
		}
		else if(this.msc_sience.contains(lectureCode))
		{
			return "msc_sience";
		}
		else if(this.common.contains(lectureCode))
		{
			return "common";
		}
		else if(this.common.contains(lectureCode))
		{
			return "prime";
		}
		else if(this.common.contains(lectureCode))
		{
			return "basic";
		}
		else{
			return "etc";
		}
	}
	
	static public Lecture findLecture(String code){
		
		Lecture temp;
		for (int i = 0; i < donggukLecture.size(); i++) {
			if (donggukLecture.get(i).getLectureCode() == code) {
				return donggukLecture.get(i);
			}
		}
		return null;
		
	}
}
