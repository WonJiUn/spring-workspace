package com.care.root;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={
		"classpath:TestMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

//root-context.xml에 DB 아이디, 비밀번호도 있고 Mapper의 위치 지정도 있음
public class TestMember {
	@Autowired MemberController mc;
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	@Test
	public void testMc() {
		//System.out.println("mc : " + mc);
		//서버가 아닌 테스트로 동작할때는 servlet-context.xml가 동작하지 않기 때문에 오류가 발생함
		//리소스쪽의 TestMember.xml 하단 namespace에 context 클릭하고
		//소스에 <context:component-scan base-package="com.care.root" /> 추가
		//이 파일의 위쪽에 @ContextConfiguration(locations={"classpath:TestMember.xml"}) 추가 후 테스트하면 오류없이 객체가 잘 들어옴
		
		assertNotNull(mc); //괄호안의 값이 null이 아니면 성공
	}
	@Test
	public void testMs() {
		assertNotNull(ms); //괄호안의 값이 null이 아니면 성공
	}
	@Test
	public void testDao() {
		assertNotNull(dao);
	}
	@Test
	public void testDaoIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(111); dto.setName("홍길동");
		dao.insertMember(dto);
	}
	@Test
	public void testServiceIns() {
		MemberDTO dto = new MemberDTO();
		dto.setId(222); dto.setName("고길동");
		ms.insertMember(dto);
	}
	@Test
	public void testDaoMemberView() {
		dao.memberView();
		//insert할때는 상관없으나, select문으로 가져올때는 ResultMap이라는 추가작업을 하지 않으면 오류가 발생함
		//dto의 변수명과 DB 테이블의 컬럼이름을 매칭
		//<result property="id" column="id"/> column = DB쪽 이름 / property = dto쪽 이름
	}
}
