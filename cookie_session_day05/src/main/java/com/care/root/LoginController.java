package com.care.root;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	@PostMapping("chkUser")
	public String chkUser(@RequestParam String id, @RequestParam String pwd, HttpSession session) {
		//나중에 실제로 DB가 연결되면 아이디 대조는 서비스에서 처리해줘야함
		String db_id = "1", db_pwd= "1", db_nick="홍길동구리구리";
		if(id.equals(db_id) && pwd.equals(db_pwd)) {
			session.setAttribute("loginId", db_id);
			session.setAttribute("loginNick", db_nick);
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	@RequestMapping("main")
	public String main(HttpSession session) {
		
		if(session.getAttribute("loginId") != null) {
			return "login/main";
		}
		return "redirect:login";
		//사용자가 메인을 요청했을때 로그인세션이 있으면 메인으로 보내주고 없으면 로그인페이지로 보낸다.
		//여기에서 작성해도 되고 jsp 페이지에서 작성해도 됨
	}
	
	@RequestMapping("logout")
	public void logout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		PrintWriter out = null;
		response.setContentType("text/html; charset=utf-8");
		try {
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("<script> alert('로그아웃 되었습니다111');" + "location.href='login';</script>");
		//이런식으로 쓰면 페이지 하나를 줄일 수 있다.
		//return "login/logout";
	}
}
