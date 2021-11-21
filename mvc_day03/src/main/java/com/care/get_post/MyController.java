package com.care.get_post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자 실행");
	}
	@RequestMapping(value="my/index", method = RequestMethod.GET)
	public String index() {
		return "/get_post/index";
	}
	//my/index에서 get방식 요청을 하면 여기에서 받아주고 post방식으로 요청하면 아래꺼에서 받아줌
	@GetMapping("my/result")
	public String result_get(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("get방식으로 들어왔습니다");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		model.addAttribute("method", request.getMethod());
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "get_post/result";
	}
	//@PostMapping("my/result") //아래꺼와 같음
	@RequestMapping(value="my/result", method = RequestMethod.POST)
	public String result_post(HttpServletRequest request, Model model, 
								@RequestParam("name") String name,
								@RequestParam("age") String age) { 
		//"name", "age"라는 이름으로 전송해준 값을 String 변수에 넣음
		System.out.println("post방식으로 들어왔습니다");
		
		model.addAttribute("method", request.getMethod());
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "get_post/result";
	}
}
