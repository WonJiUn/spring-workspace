package com.care.root.testboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.common.MemberSessionName;

public class BoardTestInterceptor extends HandlerInterceptorAdapter implements MemberSessionName {
	//또 다른 사람이 다른기능을 만들었는데, 거기에서도 로그인하지 않으면 접근하지 못하게 하는 기능을 써야할때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) == null) {
			//response.sendRedirect("login");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인 해라!!!');"
					+ " location.href='" + request.getContextPath() + "/member/login'; </script>");
			return false;
			//true면 사용자가 요청한 경로 그대로 들어가고, false면 해당하는 경로로 연결하지 않겠다는 뜻
		}
		return true;
	}

}
