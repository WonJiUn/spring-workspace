package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;
	
	@Override
	public void insertMember(MemberDTO dto) {
		//System.out.println(dto.getId());
		mapper.insertMember(dto);
		
	}

	@Override
	public String loginChk(MemberDTO dto, String inputId, String inputPw, HttpServletRequest request, Model model) {
		
		String rtn="";
		
		if(mapper.loginChk(dto) == null) {
			//System.out.println("없는 아이디입니다");
			model.addAttribute("msg", "없는 아이디입니다");
			rtn = "member/login";
		}else {
		
		String id = mapper.loginChk(dto).getId();
		String pw = mapper.loginChk(dto).getPw();
		
			if(id.equals(inputId) && pw.equals(inputPw)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", id);
				rtn = "redirect:successLogin";
			}else {
				//System.out.println("비밀번호가 틀렸습니다");
				model.addAttribute("msg", "비밀번호가 틀렸습니다");
				rtn = "member/login";
			}
		}
		//System.out.println("DBID : " + id);
		//System.out.println("DBPW : " + pw);
		//System.out.println("InputID : " + inputId);
		//System.out.println("InputPW : " + inputPw);

		return rtn;
	}

	@Override
	public void memberView(Model model) {
		model.addAttribute("list", mapper.memberView());
		
	}

	@Override
	public void personalInfo(String id, Model model) {
		model.addAttribute("personal", mapper.personalInfo(id));
		
	}
	
}
