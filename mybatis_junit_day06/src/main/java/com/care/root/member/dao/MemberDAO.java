package com.care.root.member.dao;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO dto);
	//여기에 있는 이름이 memberMapper.xml의 id값으로 들어감
	//컨트롤러 -> 서비스 -> DAO -> memberMapper.xml -> DB
	public ArrayList<MemberDTO> memberView();
}
