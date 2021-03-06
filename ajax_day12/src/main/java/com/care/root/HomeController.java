package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("getuser")
	public String getUser() {
		return "getuser";
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}
	
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non ajax 실행!!!");
		return "non_ajax";
	}
	
	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax 실행!!!");
		return "ajax";
	}
	
	static int cnt = 0; //데이터베이스의 데이터라고 가정
	@GetMapping("ajax_result")
	@ResponseBody		//이게 없으면 jsp 페이지를 돌려주겠다는게 됨. 페이지 대신 데이터를 돌려줌
	public String ajaxResult() {
		return ++cnt + "";	//""는 return값이 String이라서 문자로 만들어주기 위해 붙음
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax01";
	}
	
	@PostMapping(value="ajax_result01", produces = "application/json; charset=utf-8")
	@ResponseBody
	//public InfoDTO ajaxResult01(@RequestBody InfoDTO dto) {
	public Map ajaxResult01(@RequestBody Map dto) {
		//form의 key이름과 dto쪽의 이름이 같으면 자동으로 dto에 주입됨
		//dto에는 addr이 없으므로 이런경우 Map의 키값으로 받을수 있음(dto와 관련없음)
		System.out.println("이름 : " + dto.get("name"));
		System.out.println("나이 : " + dto.get("age"));
		System.out.println("주소 : " + dto.get("addr"));
		//dto.setName("해당 아이디는 사용가능합니다");
		return dto;
	}
	
	
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
	
}
