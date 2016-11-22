package buddy.rss;

import java.util.List;

public class Announcement{
	
	List<RssContainer> generalList;	// 일반공지 목록
	List<RssContainer> academicList;	// 학사공지 목록
	List<RssContainer> scholarshipList;// 장학공지 목록 
	
	public void getAnnouncement(){
		this.setGeneralList();
		this.setAcademicList();
		this.setScholarshipList();
	}

	// getter / setter 메서드
	
	public List<RssContainer> getGeneralList() {
		return generalList;
	}

	public void setGeneralList() {
		RssModule generalParser = new RssModule(
				"http://www.dongguk.edu/rssList.jsp?boardId=3646&id=kr_010802000000&site_id=kr");
		generalParser.readRSS();
		this.generalList = (List<RssContainer>) generalParser.getList();
	}

	public List<RssContainer> getAcademicList() {
		return academicList;
	}

	public void setAcademicList() {
		RssModule academicParser = new RssModule(
				"http://www.dongguk.edu/rssList.jsp?boardId=3638&id=kr_010801000000&site_id=kr");
		academicParser.readRSS();
		this.academicList = (List<RssContainer>) academicParser.getList();
	}

	public List<RssContainer> getScholarshipList() {
		return scholarshipList;
	}

	public void setScholarshipList() {
		RssModule scholarshipParser = new RssModule(
				"http://www.dongguk.edu/rssList.jsp?boardId=3662&id=kr_010804000000&site_id=kr");
		scholarshipParser.readRSS();
		this.scholarshipList = (List<RssContainer>) scholarshipParser.getList();
	}

}