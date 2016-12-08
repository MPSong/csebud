package buddy.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import buddy.lecture.Lecture;
import buddy.lecture.LectureService;
import buddy.member.Member;
import buddy.member.MemberService;
import buddy.regulation.LectureInfo;
import buddy.regulation.LectureInfoService;
import buddy.regulation.Regulation;
import buddy.regulation.RegulationInfoService;
import buddy.regulation.RegulationManager;
import buddy.review.LectureReview;
import buddy.review.LectureReviewManager;
import buddy.rss.Announcement;
import buddy.student.Course;
import buddy.student.ExcelRead;
import buddy.student.StudentInfo;
import buddy.student.StudentManager;
import buddy.timetable.LectureCourse;
import buddy.timetable.Timetable;
import buddy.timetable.TimetableGenerator;

@Controller
@RequestMapping("")
@SessionAttributes("member")
public class CentralHandler {
	
	@Autowired MemberService memberService;
	@Autowired LectureService lectureService;
	@Autowired LectureReviewManager lectureReviewManager;
	@Autowired StudentManager studentManager;
	@Autowired LectureInfoService lectureInfoService;
	@Autowired RegulationInfoService regulationInfoService;
	Announcement announcement;	// RSS 크롤링을 연동하는 공지사항 사용사례를 맡은 객체
	ExcelRead excel;			// 엑셀 파싱용 객체
	RegulationManager donggukRM;// 졸업요건관리 객체
	Regulation myRegulation;	// .jsp(뷰)에 매핑할 내 관리
	Regulation theRegulation;	// .jsp(뷰)에 매핑할 학교의 교칙
	List<LectureInfo> requisiteLecture;	// .jsp(뷰)에 매핑할 필수 강의 목록
	List<LectureInfo> optionalLecture;	// .jsp(뷰)에 매핑할 선택필수 강의 목록
	List<LectureInfo> recommendLecture;	// .jsp(뷰)에 매핑할 추천 강의 목록
	List<Course> printCourse; // 강의평가 입력란에서 내가 수강한 강의 목록
	TimetableGenerator timetableGenerator;	// 시간표 자동작성용 객체
	List<Lecture> lectureResultSet; // 검색어에 대한 패턴매칭 result set
	List<Lecture> lecturePrint; //  실제 .jsp(뷰)에 매핑하는 result set
	List<LectureReview> reviewResultSet; // 검색어에 대한 패턴매칭 result set
	List<LectureReview> reviewPrint; // 실제 .jsp(뷰)에 매핑하는 result set 
	StudentInfo stdPrint; // 실제 .jsp(뷰)에 매핑하는 학생 정보 객체
	List<Timetable> timetableList; // 시간표 자동완성 수행 결과로 나오는 시간표 리스트
	List<LectureCourse> timetableFirst, timetableSecond, timetableThird, timetableAuto;
	List<Lecture> lectures;
	StudentInfo stdinfo;
	// 실제 .jsp(뷰)에 매핑되는 시간표 데이터
	
	// CentralHandler 클래스의 생성자
	public CentralHandler(){
		
		announcement = new Announcement();
		excel = new ExcelRead();
		donggukRM = new RegulationManager();
		myRegulation = new Regulation();
		theRegulation = new Regulation();
		requisiteLecture = new ArrayList<LectureInfo>();
		optionalLecture = new ArrayList<LectureInfo>();
		recommendLecture = new ArrayList<LectureInfo>();
		printCourse = new ArrayList<Course>();
		timetableGenerator = new TimetableGenerator();
		lectureResultSet = new ArrayList<Lecture>();
		lecturePrint = new ArrayList<Lecture>();
		reviewResultSet = new ArrayList<LectureReview>();
		reviewPrint = new ArrayList<LectureReview>();
		stdPrint = new StudentInfo();
		timetableList = new ArrayList<Timetable>();
		timetableFirst = new ArrayList<LectureCourse>();
		timetableSecond = new ArrayList<LectureCourse>();
		timetableThird = new ArrayList<LectureCourse>();
		timetableAuto = new ArrayList<LectureCourse>();
		lectures = new ArrayList<Lecture>(); 
		stdinfo = new StudentInfo();
		
	}
	
	// 시간표 자동 작성에 대한 매핑
	@RequestMapping("timetable_auto")
	public void timetable_auto(Model model){
		
		System.out.println(timetableAuto.size());
		model.addAttribute("lecauto", timetableAuto);
		
	}
	
	// 해당 학년에 맞는 졸업 요건 계산 및 교칙 알고리즘 수행
	@RequestMapping("graduation")
	public void graduation(Model model, String phone, HttpSession session){
		
		if (session.getAttribute("userLoginInfo")!=null) {
			donggukRM.init(regulationInfoService.list(), lectureInfoService.list());
			
			List<Course> courses = new ArrayList<Course>(); 
			courses.addAll(studentManager.c_list());
			
			Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
			String memberYear = member.getStudentId().substring(0, 4);		// 세션의 Member 클래스 내에 사용자의 입학년도 스트링 추출

			// 나의 졸업 요건 관리 정보 매핑	
			// 추출한 사용자 입학 년도 정보를 donggukRM(졸업요건관리 객체)에 매핑하여 졸업 요건 정보 추출
			myRegulation.setYear(memberYear);
			myRegulation.setSelect(1, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "gross")));
			myRegulation.setSelect(2, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscGross")));
			myRegulation.setSelect(3, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscMath")));
			myRegulation.setSelect(4, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscScience")));
			myRegulation.setSelect(5, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscProcess")));
			myRegulation.setSelect(6, Integer.toString(myRegulation.MeetCredit(courses, "major")));
			myRegulation.setSelect(7, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "majorDesign")));
			myRegulation.setSelect(8, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "englishMajor")));
			myRegulation.setSelect(9, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "englishGross")));
			myRegulation.setSelect(10, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "common")));
			myRegulation.setSelect(11, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "cultural")));
			myRegulation.setSelect(12, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "basic")));	

			// 내 학번에 해당하는 졸업 요건 정보 매핑
			// 추출한 사용자 입학 년도 정보를 donggukRM(졸업요건관리 객체)에 매핑하여 해당 년도의 교칙정보 추출
			theRegulation.setYear(memberYear);
			theRegulation.setSelect(1, Integer.toString(donggukRM.findRegulation(memberYear).getGross()));
			theRegulation.setSelect(2, Integer.toString(donggukRM.findRegulation(memberYear).getMscGross()));
			theRegulation.setSelect(3, Integer.toString(donggukRM.findRegulation(memberYear).getMscMath()));
			theRegulation.setSelect(4, Integer.toString(donggukRM.findRegulation(memberYear).getMscScience()));
			theRegulation.setSelect(5, Integer.toString(donggukRM.findRegulation(memberYear).getMscProcess()));
			theRegulation.setSelect(6, Integer.toString(donggukRM.findRegulation(memberYear).getMajorGross()));
			theRegulation.setSelect(7, Integer.toString(donggukRM.findRegulation(memberYear).getMajorDesign()));
			theRegulation.setSelect(8, Integer.toString(donggukRM.findRegulation(memberYear).getEnglishMajor()));
			theRegulation.setSelect(9, Integer.toString(donggukRM.findRegulation(memberYear).getEnglishGross()));
			theRegulation.setSelect(10, Integer.toString(donggukRM.findRegulation(memberYear).getCommon()));
			theRegulation.setSelect(11, Integer.toString(donggukRM.findRegulation(memberYear).getCultural()));
			theRegulation.setSelect(12, Integer.toString(donggukRM.findRegulation(memberYear).getBasic()));
			
			// 모델에 사용자의 졸업 요건 해당 정보 및 학교 교칙 정보 객체 매핑
			model.addAttribute("myreg", myRegulation);
			model.addAttribute("reg", theRegulation);

			// 레벨별 필수 영어 과목	
			requisiteLecture = donggukRM.findRegulation(memberYear).unMeetEnglishList(courses, "A");
			
			// 필수 수강강의 목록	
			requisiteLecture.addAll(donggukRM.findRegulation(memberYear).unMeetLectureList(courses, "must"));
			
			// 선택 필수 수강강의 목록	
			optionalLecture = donggukRM.findRegulation(memberYear).unMeetLectureList(courses, "select");
			
			// 모델에 사용자의 필수/선택필수 강의 목록
			model.addAttribute("reqLec", requisiteLecture);
			model.addAttribute("optLec", optionalLecture);
			
			stdinfo = studentManager.s_get(member.getId());
			
			model.addAttribute("sinfo", stdinfo);			
		}
		
	}
	
	// 회원가입 페이지에 대한 매핑
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	// 시간표 수동작성 페이지에 대한 매핑 / 시간표 수동작성에서 검색 알고리즘의 수행
	@RequestMapping("timetable")
	public void timetable(Model model){
		
		lecturePrint.clear();
		
		if (lectureResultSet.isEmpty()) { // 검색을 하지 않고 review.jsp에 접근하는 경우
			lecturePrint.addAll(lectureService.list());
			model.addAttribute("list", lecturePrint);
		}else if(lectureResultSet.size()==1) {
			if(lectureResultSet.get(0)==null){ // null 객체로 채워진 경우 검색 결과가 0개인 경우이다.
				// 이 경우 검색 결과는 출력되지 X 
				lectureResultSet.clear(); // resultSet 초기화
			}else{ // 그 이외에 검색결과가 정상적으로 1개 검색된 경우.
				lecturePrint.addAll(lectureResultSet);
				lectureResultSet.clear(); // resultSet 초기화
				model.addAttribute("list", lecturePrint);
			}
		}else{ // 그 이외에 검색결과가 정상적으로 2개이상 검색된 경우.
			lecturePrint.addAll(lectureResultSet);
			lectureResultSet.clear(); // resultSet 초기화
			model.addAttribute("list", lecturePrint);
		}
		
	}
	
	// 시간표 자동작성 시간표 알고리즘 수행하여 시간표 자동작성 수행
	@RequestMapping("timetable_auto.do")
	public String timetable_do(HttpSession session){
		
		donggukRM.init(regulationInfoService.list(), lectureInfoService.list());
		
		List<Course> courses = new ArrayList<Course>(); 
		courses.addAll(studentManager.c_list());
		
		Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
		String memberYear = member.getStudentId().substring(0, 4);		// 세션의 Member 클래스 내에 사용자의 입학년도 스트링 추출
		
		timetableGenerator.CreatePossibleLecture(lectureService.list(), memberYear, courses, donggukRM);
		timetableGenerator.setCredit_max(18);
		timetableGenerator.autoGenerateTimetable();
		
		return "timetable_auto";
	}
	
	// 파일 업로드 페이지에 대한 매핑
	@RequestMapping("upload")
	public String upload(){
		return "upload";
	}
	
	// 메인 화면에 대한 URL 매핑
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
	// 종합 강의 시간표 정보 매핑 부분
	@RequestMapping("lecture")
	public void lecture(Model model){
		model.addAttribute("list", lectureService.list());
	}
	
	// 강의 평가 정보 매핑 부분
	@RequestMapping("review")
	public void review(Model model){
		
		printCourse.clear();
		reviewPrint.clear();
		printCourse = studentManager.c_list();
		
		model.addAttribute("myLec", printCourse);
		
		if (reviewResultSet.isEmpty()) { // 검색을 하지 않고 review.jsp에 접근하는 경우
			reviewPrint.addAll(lectureReviewManager.list());
			model.addAttribute("list", reviewPrint);
		}else if(reviewResultSet.size()==1) {
			if(reviewResultSet.get(0)==null){ // null 객체로 채워진 경우 검색 결과가 0개인 경우이다.
				// 이 경우 검색 결과는 출력되지 X 
				reviewResultSet.clear(); // resultSet 초기화
			}else{ // 그 이외에 검색결과가 정상적으로 1개 검색된 경우.
				reviewPrint.addAll(reviewResultSet);
				reviewResultSet.clear(); // resultSet 초기화
				model.addAttribute("list", reviewPrint);
			}
		}else{ // 그 이외에 검색결과가 정상적으로 2개이상 검색된 경우.
			reviewPrint.addAll(reviewResultSet);
			reviewResultSet.clear(); // resultSet 초기화
			model.addAttribute("list", reviewPrint);
		}
		
	}
	
	// 학생 개인 정보 매핑 부분
	@RequestMapping("personal_data")
	public void personal_data(Model model){
		
		model.addAttribute("list", studentManager.c_list());
		
	}
	
	// 시간표 자동작성 
	@RequestMapping("auto")
	public ModelAndView auto(Model model, HttpSession session){

		ModelAndView mav = new ModelAndView();
		mav.setViewName("auto");				
		
		donggukRM.init(regulationInfoService.list(), lectureInfoService.list());
		List<Course> courses = new ArrayList<Course>();
		courses.addAll(studentManager.c_list());
		Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
		String memberYear = member.getStudentId().substring(0, 4);		// 세션의 Member 클래스 내에 사용자의 입학년도 스트링 추출
		
		timetableGenerator.CreatePossibleLecture(lectureService.list(), memberYear, courses, donggukRM);
		timetableGenerator.setCredit_max(18);
		timetableGenerator.autoGenerateTimetable();
		timetableGenerator.cutTimetable();
		
		timetableList = timetableGenerator.getTimetable();
		
		System.out.println("총 "+timetableList.size()+"개의 시간표가 자동작성되었습니다.");
		for (int i = 0; i < timetableList.size(); i++) {
			System.out.println(i+"번째 시간표 강의 갯수는 "+timetableList.get(i).LectureInfo.size()+"개 입니다.");
		}
		
		lectures = lectureService.list();
		
		for (int i = 0; i < timetableList.size(); i++) {
			timetableList.get(i).print();
			
			//시간표 복사 부분
			if (i==0) {
				for (int j = 0; j < timetableList.get(i).LectureInfo.size(); j++) {
				
					// 강의 리스트에서 해당 강의에 맞는 정보 매핑부분
				    for(Lecture l : lectures){
				        if(l.getLectureCode().contains(timetableList.get(i).LectureInfo.get(j)) && l.getDivision().contains(timetableList.get(i).Division.get(j))){   	
				        	LectureCourse timelec = new LectureCourse();
				        	timelec.setLectureName(l.getLectureName());
				        	timelec.setLectureInfo(l.getLectureCode());
							timelec.setDivision(l.getDivision());
							timelec.setProfessor(l.getProfessor());
							timelec.setFirstWeek(l.getFirstWeekday());
							timelec.setFirstStartTime(l.getFirstStartTime());
							timelec.setFirstEndTime(l.getFirstEndTime());
							timelec.setSecondWeek(l.getSecondWeekday());
							timelec.setSecondStartTime(l.getSecondStartTime());
							timelec.setSecondEndTime(l.getSecondEndTime());
							timelec.setFirstClassroom(l.getFirstClassroom());
							timelec.setSecondClassroom(l.getSecondClassroom());
							timelec.setCredit(l.getCredit());
							timetableFirst.add(timelec);
				        }
				    }
				    
				}	
			}else if(i==1){
				for (int j = 0; j < timetableList.get(i).LectureInfo.size(); j++) {
					
					// 강의 리스트에서 해당 강의에 맞는 정보 매핑부분
				    for(Lecture l : lectures){
				        if(l.getLectureCode().contains(timetableList.get(i).LectureInfo.get(j)) && l.getDivision().contains(timetableList.get(i).Division.get(j))){   	
				        	LectureCourse timelec = new LectureCourse();
				        	timelec.setLectureName(l.getLectureName());
				        	timelec.setLectureInfo(l.getLectureCode());
							timelec.setDivision(l.getDivision());
							timelec.setProfessor(l.getProfessor());
							timelec.setFirstWeek(l.getFirstWeekday());
							timelec.setFirstStartTime(l.getFirstStartTime());
							timelec.setFirstEndTime(l.getFirstEndTime());
							timelec.setSecondWeek(l.getSecondWeekday());
							timelec.setSecondStartTime(l.getSecondStartTime());
							timelec.setSecondEndTime(l.getSecondEndTime());
							timelec.setFirstClassroom(l.getFirstClassroom());
							timelec.setSecondClassroom(l.getSecondClassroom());
							timelec.setCredit(l.getCredit());
							timetableSecond.add(timelec);
				        }
				    }
					
				}	
			}else if(i==2){
				for (int j = 0; j < timetableList.get(i).LectureInfo.size(); j++) {
					
					// 강의 리스트에서 해당 강의에 맞는 정보 매핑부분
				    for(Lecture l : lectures){
				        if(l.getLectureCode().contains(timetableList.get(i).LectureInfo.get(j)) && l.getDivision().contains(timetableList.get(i).Division.get(j))){
				        	LectureCourse timelec = new LectureCourse();
				        	timelec.setLectureName(l.getLectureName());
				        	timelec.setLectureInfo(l.getLectureCode());
							timelec.setDivision(l.getDivision());
							timelec.setProfessor(l.getProfessor());
							timelec.setFirstWeek(l.getFirstWeekday());
							timelec.setFirstStartTime(l.getFirstStartTime());
							timelec.setFirstEndTime(l.getFirstEndTime());
							timelec.setSecondWeek(l.getSecondWeekday());
							timelec.setSecondStartTime(l.getSecondStartTime());
							timelec.setSecondEndTime(l.getSecondEndTime());
							timelec.setFirstClassroom(l.getFirstClassroom());
							timelec.setSecondClassroom(l.getSecondClassroom());
							timelec.setCredit(l.getCredit());
							timetableThird.add(timelec);
				        }
				    }
					
				}	
			}					
		}
		
		mav.addObject("timefst", timetableFirst);
		model.addAttribute("timefst", timetableFirst);
		mav.addObject("timesec", timetableSecond);
		model.addAttribute("timesec", timetableSecond);
		mav.addObject("timethd", timetableThird);
		model.addAttribute("timethd", timetableThird);
		
		return mav;
	}	
	
	// 강의 추천 탭 매핑 부분
	@RequestMapping("recommend")
	public ModelAndView recommend(Model model){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("recommend");
		
		recommendLecture.clear();
		recommendLecture.addAll(optionalLecture);
		recommendLecture.addAll(requisiteLecture);
		System.out.println("강의추천 검색결과 : "+recommendLecture.size()+"개");
		
		model.addAttribute("recLec", recommendLecture);
		
		return mav;
	}
	
	// 파일 업로드 처리 부분
    @RequestMapping(value = "/excel_insert", method={RequestMethod.POST, RequestMethod.GET})
    public String fileSubmit(HttpServletRequest request, Model model) throws IllegalStateException, IOException {
        
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = null;
        
        while(iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            
            if(multipartFile.isEmpty() == false){
            	
            	File file = new File(multipartFile.getOriginalFilename());
            	multipartFile.transferTo(file);
            	ArrayList<Course> courses = excel.getExcelData("2011112428",file.getAbsolutePath());
            	
    			for(int i=0; i<courses.size(); i++){
    				
    				Course course = courses.get(i);
    				studentManager.c_add(course);
    				
    			}
            	
            }
        }

        model.addAttribute("list", studentManager.c_list());
        
        return "redirect:personal_data";
        
    }
    
    // 각 시간표 자동작성 선택에 대한 결과 매핑
	@RequestMapping(value="/timetable1", method=RequestMethod.GET)
	public String timetableFirst(HttpServletRequest request, Model model){
			
		timetableAuto.addAll(timetableFirst);
		
		return "redirect:timetable_auto";
		
	}
	
	@RequestMapping(value="/timetable2", method=RequestMethod.GET)
	public String timetableSecond(HttpServletRequest request, Model model){
			
		timetableAuto.addAll(timetableSecond);
		
		return "redirect:timetable_auto";
		
	}
	
	@RequestMapping(value="/timetable3", method=RequestMethod.GET)
	public String timetableThird(HttpServletRequest request, Model model){
			
		timetableAuto.addAll(timetableThird);
		
		return "redirect:timetable_auto";
		
	}
	
    
	// 강의평가 정보에 대한 해당 검색어 검색 결과 매핑 
	@RequestMapping(value="/reviewSearchProcess", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView reviewSearchProcess(String search, HttpServletRequest request, Model model){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:review");
		
		reviewResultSet.clear(); // resultSet 초기화
		
		if (search!=null) {	// 검색어가 null이 아닐 경우에만 검색 수행
			
			reviewResultSet.addAll(lectureReviewManager.getSearchItems(search)); // resultSet에 검색어 패턴매칭한 강의평가 리스트 가져옴.
			model.addAttribute("list", reviewResultSet);
			
		}

		System.out.println("검색결과 : 총 " + Integer.toString(reviewResultSet.size()) + "개의 데이터가 검색되었습니다.");
		for (int i = 0; i < reviewResultSet.size(); i++) {
			System.out.println(reviewResultSet.get(i).getLectureName()+" "+reviewResultSet.get(i).getProfessor());
		}
		
		if (reviewResultSet.size()==0) { // 검색 결과가 0개일 경우의 처리
			LectureReview nullObj = null;
			reviewResultSet.add(nullObj);
		}
		
		return mav;
		
	}
    
	// 시간표 수동작성시 해당 검색어에 대한 강의 검색 매핑 
	@RequestMapping(value="/lectureSearchProcess", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView lectureSearchProcess(String search, HttpServletRequest request, Model model){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:timetable");
		
		lectureResultSet.clear(); // resultSet 초기화
		
		if (search!=null) {	// 검색어가 null이 아닐 경우에만 검색 수행
			
			lectureResultSet.addAll(lectureService.getSearchItems(search)); // resultSet에 검색어 패턴매칭한 강의 리스트 가져옴.
			model.addAttribute("rs", lectureResultSet);
			
		}
		
		System.out.println("검색결과 : 총 " + Integer.toString(lectureResultSet.size()) + "개의 데이터가 검색되었습니다.");
		for (int i = 0; i < lectureResultSet.size(); i++) {
			System.out.println("check");
			System.out.println(lectureResultSet.get(i).getLectureName()+" "+lectureResultSet.get(i).getLectureCode()+"-"+lectureResultSet.get(i).getDivision()+" "+lectureResultSet.get(i).getProfessor());
		}
		
		if (lectureResultSet.size()==0) { // 검색 결과가 0개일 경우의 처리
			Lecture nullObj = null;
			lectureResultSet.add(nullObj);
		}
		
		return mav;
		
	}
	
	// 로그인 세션 생성 매핑
	@RequestMapping(value="/loginProcess", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginProcess(String id, String password, HttpSession session, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.jsp");
		
		Member member = new Member();
		
		if (memberService.findByIdAndPwd(id, password)==null) {
			return mav;
		}else {
			member = memberService.findByIdAndPwd(id, password);
		}
		
		if(member!=null){
			session.setAttribute("userLoginInfo", member);
		}
		else{
			return null; 
		}
		
		return mav;
	}
	
	// 로그아웃 처리. 세션 값 초기화(null).
	@RequestMapping("/logoutProcess")
	public String logoutProcess(HttpSession session){
		
		session.setAttribute("userLoginInfo", null);
		return "redirect:main.jsp";
		
	}
	
	// 공지사항 Tab에서 RSS 모듈을 호출하여 링크를 매핑
	@RequestMapping("announcement")
	public void announcement(Model model){
		
		announcement.getAnnouncement();
		
		model.addAttribute("generallist", announcement.getGeneralList());
		model.addAttribute("academiclist", announcement.getAcademicList());
		model.addAttribute("scholarshiplist", announcement.getScholarshipList());
		
	}

	// 회원정보 등록 POST 연산
	@RequestMapping(value="/personalDataProcess", method=RequestMethod.POST)
	public ModelAndView registerProcess(String studentNumber, String grade, String semester, String english, HttpSession session, HttpServletRequest request){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:personal_data");
		
		Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
		String id = member.getId();		// 세션의 Member 클래스 내에 사용자의 아이디 추출
		
		StudentInfo sinfo = new StudentInfo();
		
		sinfo.setStudentId(studentNumber);
		sinfo.setSemester(semester);
		
		if(english.equals("1")){
			sinfo.setEnglishTrack("A");
		}else if(english.equals("2")){
			sinfo.setEnglishTrack("B");
		}else if(english.equals("3")){
			sinfo.setEnglishTrack("C");
		}
		
		sinfo.setYear(grade);
		sinfo.setMemberId(id);
		
		studentManager.s_add(sinfo);
		
		return mav;
	}	
	
	// 회원가입 POST 연산
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public ModelAndView registerProcess(String id, String pass, String name, String email, String phone, String studentId, HttpSession session, HttpServletRequest request){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main");
		
		// 회원 가입란의 모든 입력칸을 채웠을 경우 회원 객체를 생성하여 DB에 삽입
		if(!id.equals("")||!pass.equals("")||!name.equals("")||!phone.equals("")||!email.equals("")||!studentId.equals(""))
		{
			
			Member member = new Member();
		
			member.setId(id);
			member.setPass(pass);
			member.setName(name);
			member.setEmail(email);
			member.setPhone(phone);
			member.setStudentId(studentId);
		
			memberService.add(member);
		}
		
		return mav;
	}
	
	// 강의평가 작성에 대한 POST 연산
	@RequestMapping(value="/lectureReviewProcess", method=RequestMethod.POST)
	public ModelAndView registerProcess(String lecturelist, String starval, String content, HttpSession session, HttpServletRequest request){
	
		System.out.println(lecturelist+" "+starval+" "+content);
		
		Course course = new Course();
		
		course = studentManager.c_get(lecturelist);
		
		System.out.println(lecturelist);
		System.out.println(course.getProfessor());
		System.out.println(starval);
		System.out.println(content);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:review");
		
		Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
		String id = member.getId();		// 세션의 Member 클래스 내에 사용자의 아이디 추출
		
		LectureReview review = new LectureReview();
		
		review.setContent(content);
		review.setLectureName(lecturelist);
		review.setStarval(Integer.parseInt(starval));
		review.setProfessor(course.getProfessor());
		review.setWriterId(id);
		
		lectureReviewManager.add(review);
		
		return mav;
	}	
	
}
