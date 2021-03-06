package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//데이터를 돌려주는 기능(@ResponseBody) 전용으로 사용하는 컨트롤러
//post : 데이터를 추가할때 사용함(회원가입, 게시글 등록)
//get : 데이터를 요청할때
//put : 업데이트할때(수정할때)
//delete : 삭제할때
//실제로 수정, 삭제기능이 있는건 아님
	
	static int cnt = 0;
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();
	//DB가 연동되어 있다는 가정
	
	@PostMapping(value="membership", produces = "application/json;charset=utf-8")
	public String membership(@RequestBody Map<String, Object> member) {
		System.out.println(member.get("uId"));
		System.out.println(member.get("uName"));
		System.out.println(member.get("uAge"));
		System.out.println(member.get("uAddr"));
		System.out.println(member.get("uPhone"));
		return "{\"test\":true}";
	}
	
	@PutMapping(value="modify", produces = "application/json;charset=utf-8")
	public InfoDTO modify(@RequestBody InfoDTO dto) {
		//@RequestBody : 넘어오는 값을 받아줄때 사용
		//update member set age=? where name=?;
		DBMap.replace(dto.getName(), dto);
		return DBMap.get(dto.getName());
	}
	
	@GetMapping(value="user", produces = "application/json;charset=utf-8")
    public InfoDTO user(@RequestParam String id) {
		//select * from member where id=id;
    	return DBMap.get(id);
    }
	
	@GetMapping(value="user/{name}", produces = "application/json;charset=utf-8")
	public InfoDTO user1(@PathVariable("name") String name1) {
		//select * from member where id=id;
		return DBMap.get(name1);
	}
	
	@GetMapping(value="users", produces = "application/json;charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i = cnt; i<cnt+10; i++) {
			InfoDTO info = new InfoDTO();
			info.setName("홍길동" + i);
			info.setAge(10+i);
			list.add(info);
			DBMap.put("홍길동"+i, info);
		}
		
		cnt += 10;
		return list;
	}
	
	@GetMapping(value="rest", produces = "application/json;charset=utf-8")
	public String get() {
		return "{ \"execute\" : \"get 데이터 요청할때 사용\" }";
	}
	@PostMapping(value="rest", produces = "application/json;charset=utf-8")
	public String post() {
		return "{ \"execute\" : \"post 데이터 추가할때 사용\" }";
	}
	@PutMapping(value="rest", produces = "application/json;charset=utf-8")
	public String put() {
		return "{ \"execute\" : \"put 데이터 수정할때 사용\" }";
	}
	@DeleteMapping(value="rest", produces = "application/json;charset=utf-8")
	public String delete() {
		return "{ \"execute\" : \"delete 데이터 삭제할때 사용\" }";
	}
	
	
}
