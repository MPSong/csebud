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
import buddy.review.LectureReviewManager;
import buddy.rss.Announcement;
import buddy.student.Course;
import buddy.student.ExcelRead;
import buddy.student.StudentManager;
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
	TimetableGenerator timetableGenerator;	// 시간표 자동작성용 객체
	List<Lecture> resultSet; // 검색어에 대한 패턴매칭 result set
	
	// CentralHandler 클래스의 생성자
	public CentralHandler(){
		
		announcement = new Announcement();
		excel = new ExcelRead();
		donggukRM = new RegulationManager();
		myRegulation = new Regulation();
		theRegulation = new Regulation();
		requisiteLecture = new ArrayList<LectureInfo>();
		optionalLecture = new ArrayList<LectureInfo>();
		timetableGenerator = new TimetableGenerator();
		resultSet = new ArrayList<Lecture>();
		
	}
	
	// 시간표 자동 작성에 대한 매핑
	@RequestMapping("timetable_auto")
	public String timetable_auto(){
		return "timetable_auto";
	}
	
	// 해당 학년에 맞는 졸업 요건 계산 및 교칙 알고리즘 수행
	@RequestMapping("graduation")
	public void graduation(Model model, String phone, HttpSession session){
		
		donggukRM.init(regulationInfoService.list(), lectureInfoService.list());
				
		List<Course> courses = new ArrayList<Course>(); 
		courses.addAll(studentManager.c_list());
		
		Member member = (Member) session.getAttribute("userLoginInfo");	// 세션에서 Member 객체 추출
		String memberYear = member.getStudentId().substring(0, 4);		// 세션의 Member 클래스 내에 사용자의 입학년도 스트링 추출

		// 나의 졸업 요건 관리 정보 매핑	
		// 추출한 사용자 입학 년도 정보를 donggukRM(졸업요건관리 객체)에 매핑하여 졸업 요건 정보 추출
		myRegulation.setSelect(1, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "gross")));
		myRegulation.setSelect(2, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscGross")));
		myRegulation.setSelect(3, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscMath")));
		myRegulation.setSelect(4, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscScience")));
		myRegulation.setSelect(5, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "mscProcess")));
		myRegulation.setSelect(7, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "majorDesign")));
		myRegulation.setSelect(8, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "englishMajor")));
		myRegulation.setSelect(9, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "englishGross")));
		myRegulation.setSelect(10, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "common")));
		myRegulation.setSelect(11, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "cultural")));
		myRegulation.setSelect(12, Integer.toString(donggukRM.findRegulation(memberYear).MeetCredit(courses, "basic")));
		myRegulation.setYear(memberYear);
		myRegulation.setSelect(6, Integer.toString(myRegulation.MeetCredit(courses, "major")));

		// 내 학번에 해당하는 졸업 요건 정보 매핑
		// 추출한 사용자 입학 년도 정보를 donggukRM(졸업요건관리 객체)에 매핑하여 해당 년도의 교칙정보 추출
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
		theRegulation.setYear(memberYear);
		
		// 모델에 사용자의 졸업 요건 해당 정보 및 학교 교칙 정보 객체 매핑
		model.addAttribute("myreg", myRegulation);
		model.addAttribute("reg", theRegulation);

		// 레벨별 필수 영어 과목	
		requisiteLecture = donggukRM.findRegulation(memberYear).unMeetEnglishList(courses, "B");
		
		// 필수 수강강의 목록	
		requisiteLecture.addAll(donggukRM.findRegulation(memberYear).unMeetLectureList(courses, "must"));
		
		// 선택 필수 수강강의 목록	
		optionalLecture = donggukRM.findRegulation(memberYear).unMeetLectureList(courses, "select");
		
		// 모델에 사용자의 필수/선택필수 강의 목록
		model.addAttribute("reqLec", requisiteLecture);
		model.addAttribute("optLec", optionalLecture);
		
	}
	
	// 회원가입 페이지에 대한 매핑
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	// 시간표 수동작성 페이지에 대한 매핑
	@RequestMapping("timetable")
	public String timetable(){
		return "timetable";
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
		
		model.addAttribute("list", lectureReviewManager.list());
		
	}
	
	// 학생 개인 정보 매핑 부분
	@RequestMapping("personal_data")
	public void personal_data(Model model){
		
		model.addAttribute("list", studentManager.c_list());
		
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
    
	// 시간표 수동작성시 해당 검색어에 대한 강의 검색 매핑 
	@RequestMapping(value="/lectureSearchProcess", method={RequestMethod.POST, RequestMethod.GET})
	public String lectureSearchProcess(String search, HttpServletRequest request, Model model){
	
		System.out.println(search);
		
		resultSet.addAll(lectureService.getSearchItems(search));
		model.addAttribute("list", resultSet);
		
		System.out.println(Integer.toString(resultSet.size())+"크기");
		
		return "redirect:timetable";
		
	}
	
	// 로그인 세션 생성 매핑
	@RequestMapping(value="/loginProcess", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginProcess(String id, String password, HttpSession session, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.jsp");
		
		Member member = memberService.findByIdAndPwd(id, password);
		
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
	
	// 회원가입 POST 연산
	@RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	public ModelAndView registerProcess(String id, String pass, String name, String email, String phone, String studentId, HttpSession session, HttpServletRequest request){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.jsp");
		
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
	
}
