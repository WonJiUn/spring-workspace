package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("mmm")
	//이름지정이 없는경우 memberService라는 이름으로 빈 등록이 된다. 여러개 있는 객체중에 지정해서 매칭해줄수 있음
	//이름지정이 없으면 servlet-context에도 하나 있는것과 MemberService에 있는 객체가 충돌됨
	MemberService ms;
	
	@RequestMapping("insert")
	public String insert(Model model) {
		//ms = new MemberService();
		int result = ms.insert();
		System.out.println("ms : " + ms);
		model.addAttribute("result", result);
		return "di/index";
	}
}
