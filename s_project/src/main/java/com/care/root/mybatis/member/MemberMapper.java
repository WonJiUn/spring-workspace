package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public void insertMember(MemberDTO dto);
	public ArrayList<MemberDTO> memberView();
	public MemberDTO loginChk(MemberDTO dto);
	public MemberDTO personalInfo(String id);
}
