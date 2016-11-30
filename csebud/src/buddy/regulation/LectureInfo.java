package buddy.regulation;

import javax.persistence.Entity;

@Entity
public class LectureInfo {

	String Lcode;	// 강의 코드
	
	String Lname;	// 강의 명
	
	String Ltype;	// 강의 유형
	
	String Lcredit;	// 학점
	
	String must;	// 필수강의 여부
	
	String select;	// 선택강의 여부
	
	String etc;		// 영어트랙 정보
	
	String sub;		// 대체과목
	
	String year;	// 몇년도 MSC인지 여부
	
	/**
	 * @return the Lcode
	 */
	public String getLcode(){
		return Lcode;
	}
	
	/**
	 * @param Lcode the Lcode to set
	 */
	public void setLcode(String Lcode){
		this.Lcode = Lcode;
	}
	
	/**
	 * @return the Lname
	 */
	public String getLname(){
		return Lname;
	}
	
	/**
	 * @param Lname the Lname to set
	 */
	public void setLname(String Lname){
		this.Lname = Lname;
	}

	/**
	 * @return the Ltype
	 */
	public String getLtype(){
		return Ltype;
	}
	
	/**
	 * @param Ltype the Ltype to set
	 */
	public void setLtype(String Ltype){
		this.Ltype = Ltype;
	}
	
	/**
	 * @return the Lcredit
	 */
	public String getLcredit(){
		return Lcredit;
	}
	
	/**
	 * @param Lcredit the Lcredit to set
	 */
	public void setLcredit(String Lcredit){
		this.Lcredit = Lcredit;
	}
	
	/**
	 * @return the must
	 */
	public String getMust(){
		return must;
	}
	
	/**
	 * @param must the must to set
	 */
	public void setMust(String must){
		this.must = must;
	}
	
	/**
	 * @return the select
	 */
	public String getSelect(){
		return select;
	}
	
	/**
	 * @param select the select to set
	 */
	public void setSelect(String select){
		this.select = select;
	}
	
	/**
	 * @return the etc
	 */
	public String getEtc(){
		return etc;
	}
	
	/**
	 * @param etc the etc to set
	 */
	public void setEtc(String etc){
		this.etc = etc;
	}
	
	/**
	 * @return the sub
	 */
	public String getSub(){
		return sub;
	}
	
	/**
	 * @param sub the sub to set
	 */
	public void setSub(String sub){
		this.sub = sub;
	}
	
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
	
}
