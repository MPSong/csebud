package buddy.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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

import buddy.member.Member;
import buddy.member.MemberService;
import buddy.review.LectureReviewManager;
import buddy.lecture.LectureService;
import buddy.rss.Announcement;
import buddy.student.Course;
import buddy.student.ExcelRead;
import buddy.student.Student;
import buddy.student.StudentManager;
import buddy.file.FileInfo;

@Controller
@RequestMapping("")
@SessionAttributes("member")
public class CentralHandler {
	
	@Autowired MemberService memberService;
	@Autowired LectureService lectureService;
	@Autowired LectureReviewManager lectureReviewManager;
	@Autowired StudentManager studentManager;
	Announcement announcement = new Announcement();
	ExcelRead excel = new ExcelRead();
	
	@RequestMapping("timetable_auto")
	public String timetable_auto(){
		return "timetable_auto";
	}
	
	@RequestMapping("notice")
	public String notice(){
		return "notice";
	}
	
	@RequestMapping("review")
	public void review(Model model){
		model.addAttribute("list", lectureReviewManager.list());
	}
	
	@RequestMapping("graduation")
	public String graduation(){
		return "graduation";
	}
	
	@RequestMapping("lecture")
	public void lecture(Model model){
		model.addAttribute("list", lectureService.list());
	}
	
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("introduction")
	public String introduction(){
		return "introduction";
	}
	
	@RequestMapping("timetable")
	public String timetable(){
		return "timetable";
	}
	
	@RequestMapping("upload")
	public String upload(){
		return "upload";
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
        
        return "redirect:personal_data"; // 리스트 요청으로 보내야하는데 일단 제외하고 구현
        
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
	public ModelAndView registerProcess(String id, String pass, String name, String email, String phone, HttpSession session, HttpServletRequest request){
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.jsp");
		
		Member member = new Member();
		
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		
		memberService.add(member);
		
		return mav;
	}
	
}
