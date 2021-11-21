package com.care.root;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@GetMapping("cookie")
	public String cookie(HttpServletResponse response, HttpServletRequest req,
						@CookieValue(value="myCookie", required = false) Cookie cookie) {
		//사용자가 myCookie라는 값을 가지고있다면 cookie라는 변수에 넣어줌. 
		//그러나 페이지를 최초로 요청할때는 값이 없기 때문에 오류발생하기 때문에 required = false로 최초로 null값을 넣어줌
		System.out.println("cookie : " + cookie);
		
		Cookie cook = new Cookie("myCookie","쿠키생성");
		cook.setMaxAge(5);
		
		response.addCookie(cook);
		
		for(Cookie c : req.getCookies()) {
			System.out.println(c.getName());
			//사용자가 가지고있는 모든 쿠키값을 가져옴(실제로는 우리가 만든 쿠키값만 필요하기 때문에 이런 방식은 필요없음)
		}
		
		return "cook/cookie";
	}
	@RequestMapping("popup")
	public String popup() {
		
		return "cook/popup";
	}
}
