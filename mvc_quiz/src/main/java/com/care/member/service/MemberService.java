package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired MemberDAO dao;
	
	public MemberService() {
		System.out.println("서비스 생성자 실행");
	}
	public int insert(String id, String pwd, String name) {
		//이 단계에서 dto객체를 생성해서 dto의 세터에 저장해서 넘겨도 됨
		dao.insert(id,pwd,name);
		return 1;
	}
	public ArrayList<MemberDTO> view() {
		ArrayList<MemberDTO> list;
		list = dao.view();
		
		return list;
	}
	/*
	public void memberList(Model model) {
		model.addAttribute("list", dao.memberList());
	}
	*/
	

}
