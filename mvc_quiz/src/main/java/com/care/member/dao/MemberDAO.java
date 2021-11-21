package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	public void insert(String id, String pwd, String name) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		
		list.add(dto);
	}
	public ArrayList<MemberDTO> view() {
		return list;
	}
	/*
	public ArrayList<MemberDTO> memberList() {
		return list;
	}
	*/
}
