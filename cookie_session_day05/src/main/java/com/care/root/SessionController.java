package com.care.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	@RequestMapping("make_session")
	public String makeSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("id", "abc123");
		session.setAttribute("name", "홍길동");
		
		return "session/makeSession";
	}
	@RequestMapping("result_session")
	public String resultSession(Model model) {
		model.addAttribute("id", "모델로 저장한 아이디");
		return "session/resultSession";
	}
	@RequestMapping("del_session")
	public String delSession(HttpSession session) {
		//HttpSession이 자동으로 세션값을 넣어와줌. 이 방식을 사용하지 못하는 경우는 HttpServletRequest 사용
		//session.invalidate(); 	//모든 세션 삭제
		session.removeAttribute("id");
		return "session/delSession";
	}
}
