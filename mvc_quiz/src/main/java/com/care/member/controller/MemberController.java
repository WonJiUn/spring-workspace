package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@RequestMapping("regist")
	public String regist(Model model) {
		return "quiz/regist";
	}
	
	@GetMapping("index")
	public String index_get(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		if(id == null || pwd == null || name == null || id.equals("") || pwd.equals("") || name.equals("")) {
			
		}else {
			//model.addAttribute("id",id);
			//model.addAttribute("pwd",pwd);
			//model.addAttribute("name",name);
			
			ms.insert(id,pwd,name);
		}
		
		return "quiz/index";
	}
	
	@RequestMapping("member_view")
	public String member_view(Model model) {
		
		ArrayList<MemberDTO> list;
		list = ms.view();
		
		model.addAttribute("list", list);
		
		return "quiz/member_view";
	}
	/*
	@GetMapping("member_view")
	public String member_view2(Model model) {
		ms.memberList(model);
		
		return "quiz/member_view";
	}
	
	@PostMapping("register2")
	public String register2(MemberDTO dto) {
		System.out.println("dto.id : " + dto.getId());
		System.out.println("dto.pwd : " + dto.getPwd());
		System.out.println("dto.name : " + dto.getName());
		ms.register(dto);
		
		//register페이지에서 넘어오는 이름과 같으면 dto에 자동으로 저장해줌.
		//수업에서 한거 그대로 필기한거라서 페이지 이름 다름
		return "redirect:index";
	}
	*/
	
}
