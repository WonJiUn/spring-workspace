package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController02 {
	
	@RequestMapping("index02")
	public String memberIndex(Model model) {
		model.addAttribute("indexKey", "기본 페이지 입니다");
		return "member02/index";
	}
	@RequestMapping("login02")
	public String memberLogin(Model model) {
		model.addAttribute("loginKey", "로그인 페이지 입니다");
		return "member02/login";
	}
	@RequestMapping("logout02")
	public String memberLogout(Model model) {
		model.addAttribute("logoutKey", "로그아웃 페이지 입니다");
		return "member02/logout";
	}
}
