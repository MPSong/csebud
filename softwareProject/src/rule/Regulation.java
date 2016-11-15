package rule;

import java.util.ArrayList;
import java.util.List;

public class Regulation {

	Integer year;
	Integer gross;
	Integer msc_math;
	Integer msc_gross;
	Integer msc_sience;
	Integer msc_process;
	Integer major_design;
	Integer major_gross;
	Integer english_major;	
	Integer english_gross;
	Integer common;
	Integer prime;
	Integer basic;
	List<Lecture> essential;
	List<Lecture> selection;
	
	
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getGross() {
		return gross;
	}

	public void setGross(Integer gross) {
		this.gross = gross;
	}

	public Integer getMsc_math() {
		return msc_math;
	}

	public void setMsc_math(Integer msc_math) {
		this.msc_math = msc_math;
	}

	public Integer getMsc_gross() {
		return msc_gross;
	}

	public void setMsc_gross(Integer msc_gross) {
		this.msc_gross = msc_gross;
	}

	public Integer getMsc_sience() {
		return msc_sience;
	}

	public void setMsc_sience(Integer msc_sience) {
		this.msc_sience = msc_sience;
	}

	public Integer getMsc_process() {
		return msc_process;
	}

	public void setMsc_process(Integer msc_process) {
		this.msc_process = msc_process;
	}

	public Integer getMajor_design() {
		return major_design;
	}

	public void setMajor_design(Integer major_design) {
		this.major_design = major_design;
	}

	public Integer getMajor_gross() {
		return major_gross;
	}

	public void setMajor_gross(Integer major_gross) {
		this.major_gross = major_gross;
	}

	public Integer getEnglish_major() {
		return english_major;
	}

	public void setEnglish_major(Integer english_major) {
		this.english_major = english_major;
	}

	public Integer getEnglish_gross() {
		return english_gross;
	}

	public void setEnglish_gross(Integer english_gross) {
		this.english_gross = english_gross;
	}

	public Integer getCommon() {
		return common;
	}

	public void setCommon(Integer common) {
		this.common = common;
	}

	public Integer getPrime() {
		return prime;
	}

	public void setPrime(Integer prime) {
		this.prime = prime;
	}

	public Integer getBasic() {
		return basic;
	}

	public void setBasic(Integer basic) {
		this.basic = basic;
	}

	public List<Lecture> getEssential() {
		return Essential;
	}

	public void setEssential(List<Lecture> essential) {
		Essential = essential;
	}


	public int meet(List<Course> courselist, String type) {

		int result = 0;
		Lecture temp;

		for (int i = 0; i < courselist.size(); i++) {
			temp = LectureManager.findLecture(courselist.get(i).getLectureCode());

			if (temp.getType() == type && courselist.get(i).getGrade() != "F") {
				result = result + temp.getCredit();
			}
		}

		return result;
	}

	//
	public int meet_gross(List<Course> courselist) {

		int result = 0;
		Lecture temp;

		for (int i = 0; i < courselist.size(); i++) {
			temp = LectureManager.findLecture(courselist.get(i).getLectureCode());

			if (courselist.get(i).getGrade() != "F") {
				result = result + temp.getCredit();
			}
		}

		return result;

	}

	public int meet_msc_gross(List<Course> courselist) {

		return meet_msc_math(courselist) + meet_msc_sience(courselist) + meet_msc_process(courselist);

	}

	public int meet_msc_math(List<Course> courselist) {

		return meet(courselist, "msc_math");

	}

	public int meet_msc_sience(List<Course> courselist) {

		return meet(courselist, "msc_sience");

	}

	public int meet_msc_process(List<Course> courselist) {

		if (meet(courselist, "msc_process") > this.msc_process) {
			return this.msc_process;
		} else {
			return meet(courselist, "msc_process");

		}

	}

	public int meet_common(List<Course> courselist) {

		return meet(courselist, "common");

	}

	public int meet_prime(List<Course> courselist) {

		return meet(courselist, "prime");

	}

	public int meet_basic(List<Course> courselist) {

		return meet(courselist, "basic");

	}

	public int meet_english_gross(List<Course> courselist) {

		return meet(courselist, "english_gross");

	}

	public int meet_english_major(List<Course> courselist) {

		return meet(courselist, "english_major");

	}

	public int meet_major_design(List<Course> courselist) {

		return meet(courselist, "major_design");

	}

	public List<Lecture> meet_Essential(List<Course> courselist) {
		List<Lecture> essential = new ArrayList();

		essential.addAll(this.Essential);

		for (int i = 0; i < courselist.size(); i++) {
			if (essential.contains(courselist.get(i))) {
				essential.remove(courselist.get(i));
			}
		}

		return essential;

	}

}
