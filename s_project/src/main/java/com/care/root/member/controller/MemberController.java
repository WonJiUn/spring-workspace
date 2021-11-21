package com.care.root.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("insert")
	public String insert(MemberDTO dto) {
		//System.out.println(dto.getId());
		ms.insertMember(dto);
		return "member/login";
	}
	
	@GetMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
	}
	
	@PostMapping("chkUser")
	public String chkUser(MemberDTO dto, HttpServletRequest request, Model model) {
		String inputId = request.getParameter("id");
		String inputPw = request.getParameter("pw");
		
		String rtn = ms.loginChk(dto, inputId, inputPw, request, model);
		//System.out.println(model.getAttribute("msg"));
		
		return rtn;
	}
	
	@GetMapping("logout")
	public void logout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		PrintWriter out = null;
		response.setContentType("text/html; charset=utf-8");
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<script> alert('로그아웃 되었습니다');"
				+ "location.href='index'; </script>");
	}
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberView(model);
		return "member/memberInfo";
	}
	
	@GetMapping("info")
	public String info(@RequestParam String id, Model model) {
		ms.personalInfo(id, model);
		return "member/info";
	}
	
}
