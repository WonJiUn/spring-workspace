package com.care.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.member.dto.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("re/index")
	public String index() {
		return "re/index";
	}
	
	@RequestMapping("re/result")
	public String result(HttpServletRequest request,Model model, RedirectAttributes rs) {
		String id = request.getParameter("id");
		
		if(id.equals("abc")) {
			//model.addAttribute("result", "로그인 성공하였음!!!");
			//이런 방식으로 하면 rsOK까지 값이 전달이 안됨.
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			rs.addFlashAttribute("test",dto);
			
			rs.addFlashAttribute("result", "리다이렉트의 값 전달");
			return "redirect:rsOK";
		}else {
			return "redirect:rsNO";
		}
		
	}
	
	@RequestMapping("re/rsOK")
	public String rsOK() {
		return "re/rsOK";
	}
	@RequestMapping("re/rsNO")
	public String rsNO() {
		return "re/rsNO";
	}
	
}
