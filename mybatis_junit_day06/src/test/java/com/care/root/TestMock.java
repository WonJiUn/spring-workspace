package com.care.root;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations={
		"classpath:TestMember.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	//컨트롤러의 값을 mock에 넣어줌. before에서 초기화 필요
	
	@Before 
	public void setUp() {
		System.out.println("test 실행전-----");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	@Test
	public void testIndex() throws Exception {
		System.out.println("----- test코드 실행");
		mock.perform(get("/index")) //경로 앞에 무조건 / 가 들어가야 함
		.andDo(print())				//세미콜론 지웠음
		.andExpect(status().isOk())	//status가 200이면 JUnit에서 성공처리
		.andExpect(forwardedUrl("member/index")); //return 경로가 member/index가 맞으면 성공
	}
	@Test
	@Transactional(transactionManager = "txMgr")	//root-context.xml 에 넣었던 bean 이름. 테스트 후 저장데이터 롤백
	public void testInsert() throws Exception{
		mock.perform(post("/insert").param("id", "1234").param("name", "111이"))
		.andDo(print())
		.andExpect(status().is3xxRedirection());	//리다이렉트(300번대)가 제대로 작동하는지
	}
	@Test
	public void testMemberview() throws Exception {
	   mock.perform(get("/memberview")).andDo(print())
	   .andExpect(status().isOk())
	   .andExpect(forwardedUrl("member/memberview"))
	   .andExpect(model().attributeExists("list"));	//model에 list값이 잘 들어가있는지
	}
}
