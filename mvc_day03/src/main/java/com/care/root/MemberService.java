package com.care.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Autowired는 자료형 -> 이름 을 기준으로 넣어주기 때문에 이름이 같은쪽을 우선적으로 넣어줌
//Qualifier가 있는 경우 이름 지정 가능
@Service("mmm")
public class MemberService {
	@Autowired MemberDAO dao;
	public MemberService() {
		System.out.println("서비스 생성자 실행");
	}
	public int insert() {
		//dao = new MemberDAO();
		System.out.println("dao : " + dao);
		return dao.insert();
	}
}
