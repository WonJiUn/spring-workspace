package com.care.root;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	@RequestMapping("quiz_cookie")
	public String myCookie(HttpServletResponse response, Model model, 
			@CookieValue(value="myCookie", required=false) Cookie cook, HttpServletRequest request) {
		/*
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies)
				System.out.println(c.getName() + " : " + c.getValue());
		}
		*/
		if(cook != null) {
			model.addAttribute("cook", cook.getValue());
		}
		
		return "cookie_session_quiz/cookie";
	}
	@RequestMapping("quiz_popup")
	public String popup() {
		return "cookie_session_quiz/popup";
	}
	@RequestMapping("quiz_cookieChk")
	public void cookieChk(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie", "나의쿠키");
		cook.setMaxAge(10);
		//cook.setPath("/");	//어느 위치든 쿠키값을 가져오겠다는 의미로 최상위경로를 넣어줌
		response.addCookie(cook);
	}
	@RequestMapping("quiz_login")
	public String login() {
		return "cookie_session_quiz/login";
	}
	
	@RequestMapping("quiz_chkUser")
	public String chkUser(HttpServletRequest request) {
		String id = "qwer", pwd= "1234", nickName="홍길동";
		String reqId = request.getParameter("id");
		String reqPwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		if((id.equals(reqId) && pwd.equals(reqPwd)) || session.getAttribute("loginUser") != null){
			session.setAttribute("loginUser", nickName);
			return "cookie_session_quiz/main";
		}
		return "redirect:quiz_login";
	}
	
	@RequestMapping("quiz_logout")
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
				+ "location.href='quiz_login'; </script>");
	}
	@RequestMapping("quiz_main")
	public String main(HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			return "cookie_session_quiz/main";
		}
		return "redirect:quiz_login";
	}
}
