package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="index")	//url 경로가 /root/index
	public String memberIndex() {
		return "member/index";
		//파일경로가 멤버 폴더안의 인덱스. 위에있는 url 경로와 혼동하지 말것
	}
	@RequestMapping("logout")		//value가 하나만 들어가는 경우는 value= 를 생략가능
	public String memberLogout(Model model) {
		model.addAttribute("key", "로그아웃 되었습니다");	
		//값을 전달하는 방법. model이라는 객체에 담아서 사용. 세션과 비슷한역할. 수업에선 주로 이 방법을 사용함
		return "member/logout";
	}
	@RequestMapping("/login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();	//위의 방식과 비슷하게 동작하는 다른 방법
		mv.addObject("login", "로그인 성공하였다!!!");
		mv.setViewName("member/login");
		return mv;
	}
}
