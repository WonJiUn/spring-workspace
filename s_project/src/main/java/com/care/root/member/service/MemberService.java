package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public void insertMember(MemberDTO dto);
	public String loginChk(MemberDTO dto, String id, String pw, HttpServletRequest request,Model model);
	public void memberView(Model model);
	public void personalInfo(String id, Model model);
}
