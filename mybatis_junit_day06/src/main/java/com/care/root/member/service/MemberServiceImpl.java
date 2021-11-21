package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberDAO mapper;
	//DAO는 interface라서 연산을 할 수 없고 연결만 해주는 역할이라서 보통 MemberMapper라는 이름을 많이 쓴다
	
	@Override
	public void insertMember(MemberDTO dto) {
		mapper.insertMember(dto);
	}

	@Override
	public void memberView(Model model) {
		model.addAttribute("list", mapper.memberView());
		
	}

}
