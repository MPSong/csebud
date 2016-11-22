package buddy.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import buddy.member.Member;
import buddy.member.MemberService;
import buddy.review.LectureReviewManager;
import buddy.lecture.LectureService;
import buddy.rss.Announcement;

@Controller
@RequestMapping("")
@SessionAttributes("member")
public class CentralHandler {
	
	@Autowired MemberService memberService;
	@Autowired LectureService lectureService;
	@Autowired LectureReviewManager lectureReviewManager;
	Announcement announcement = new Announcement();
	
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
	
	@RequestMapping("personal_data")
	public String personal_data(){
		return "personal_data";
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
