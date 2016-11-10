package buddy.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import buddy.domain.Member;
import buddy.member.MemberService;

@Controller
@RequestMapping("")
@SessionAttributes("member")
public class CentralHandler {

	@Autowired MemberService memberService;
	
	@RequestMapping(value="/groupmap", method = RequestMethod.GET)
	public ModelAndView groupmap(HttpSession session, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:groupmap.jsp");
		
		Member member = (Member) session.getAttribute("userLoginInfo");
		
		mav.addObject(memberService.get(member.getId()));
		
		return mav;
	}
	
	@RequestMapping("autotimetable")
	public String autotimetable(){
		return "autotimetable";
	}
	
	@RequestMapping("developernotice")
	public String developernotice(){
		return "developernotice";
	}
	
	@RequestMapping("evaluate")
	public String evaluate(){
		return "evaluate";
	}
	
	@RequestMapping("graduationrequirement")
	public String graduationrequirement(){
		return "graduationrequirement";
	}
	
	@RequestMapping("lectureinfo")
	public String lectureinfo(){
		return "lectureinfo";
	}
	
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("notice")
	public String notice(){
		return "notice";
	}
	
	@RequestMapping("personaldata")
	public String personaldata(){
		return "personaldata";
	}
	
	@RequestMapping("register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("siteexplain")
	public String siteexplain(){
		return "siteexplain";
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
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(String id, String password, HttpSession session, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		
		Member member = memberService.findByIdAndPwd(id, password);
		
		if(member!=null){
			session.setAttribute("userLoginInfo", member);
		}
		else return null;
		
		return mav;
	}
	
}
