package buddy.regulation;

import javax.persistence.Entity;

@Entity
public class RegulationInfo {

	String year;		// 해당 규정의 년도
	
	String gross;		// 총 요구 학점
	
	String msc_gross;	// 총 MSC 요구 학점
	
	String msc_math;	// MSC 학점 중 수학강의의 요구 학점
	
	String msc_science;	// MSC 학점 중 과학강의의 요구 학점
	
	String msc_process; 
	
	String major_gross; // 총 전공 요구 학점 
	
	String major_design;// 전공 학점 중 설계과목의 요구 학점
	
	String english_major;// 전공 학점 중 영어과목의 요구 학점
	
	String english_gross;//	총 영어강의 요구 학점
	
	String common;		// 일반 강의
	
	String prime;		// 필수 강의
	
	String basic;		// 기본 강의

	
	/**
	 * @return the year
	 */
	public String getYear(){
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * @return the gross
	 */
	public String getGross(){
		return gross;
	}
	
	/**
	 * @param gross the gross to set
	 */
	public void setGross(String gross){
		this.gross = gross;
	}
	
	/**
	 * @return the msc_gross
	 */
	public String getMsc_gross(){
		return msc_gross;
	}
	
	/**
	 * @param msc_gross the msc_gross to set
	 */
	public void setMsc_gross(String msc_gross){
		this.msc_gross = msc_gross;
	}
	
	/**
	 * @return the msc_math
	 */
	public String getMsc_math(){
		return msc_math;
	}
	
	/**
	 * @param msc_math the msc_math to set
	 */
	public void setMsc_math(String msc_math){
		this.msc_math = msc_math;
	}
	
	/**
	 * @return the msc_science
	 */
	public String getMsc_science(){
		return msc_science;
	}
	
	/**
	 * @param msc_science the msc_science to set
	 */
	public void setMsc_science(String msc_science){
		this.msc_science = msc_science;
	}
	
	/**
	 * @return the msc_process
	 */
	public String getMsc_process(){
		return msc_process;
	}
	
	/**
	 * @param msc_process the msc_process to set
	 */
	public void setMsc_process(String msc_process){
		this.msc_process = msc_process;
	}
	
	/**
	 * @return the major_gross
	 */
	public String getMajor_gross(){
		return major_gross;
	}
	
	/**
	 * @param major_gross the major_gross to set
	 */
	public void setMajor_gross(String major_gross){
		this.major_gross = major_gross;
	}
	
	/**
	 * @return the major_design
	 */
	public String getMajor_design(){
		return major_design;
	}
	
	/**
	 * @param major_design the major_design to set
	 */
	public void setMajor_design(String major_design){
		this.major_design = major_design;
	}
	
	/**
	 * @return the english_major
	 */
	public String getEnglish_major(){
		return english_major;
	}
	
	/**
	 * @param english_major the english_major to set
	 */
	public void setEnglish_major(String english_major){
		this.english_major = english_major;
	}
	
	/**
	 * @return the english_gross
	 */
	public String getEnglish_gross(){
		return english_gross;
	}
	
	/**
	 * @param english_gross the english_gross to set
	 */
	public void setEnglish_gross(String english_gross){
		this.english_gross = english_gross;
	}
	
	/**
	 * @return the common
	 */
	public String getCommon(){
		return common;
	}
	
	/**
	 * @param common the common to set
	 */
	public void setCommon(String common){
		this.common = common;
	}
	
	/**
	 * @return the prime
	 */
	public String getPrime(){
		return prime;
	}
	
	/**
	 * @param prime the prime to set
	 */
	public void setPrime(String prime){
		this.prime = prime;
	}
	
	/**
	 * @return the basic
	 */
	public String getBasic(){
		return basic;
	}
	
	/**
	 * @param basic the basic to set
	 */
	public void setBasic(String basic){
		this.basic = basic;
	}
	
	
}