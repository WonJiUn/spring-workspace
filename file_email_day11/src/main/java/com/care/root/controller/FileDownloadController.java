package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.FileService;

@Controller
public class FileDownloadController {
	@GetMapping("download")
//@RequestParam("file") String fileName 에서 넘어오는 변수명과 String 뒤에 변수명이 같으면 괄호안 생략가능, 다르면 명시해줘야함
	public void download(@RequestParam("file") String fileName,
						HttpServletResponse response) throws Exception {
		//Content-disposition : 파일을 다운로드 하겠다는 의미
		//attachment : 파일을 다운로드하여 브라우저로 표현하겠다
		//fileName : 다운로드 될 파일이름 설정
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		//사용자가 파일다운 요청 -> addHeader : 응답하는 방식을 설정
		
		//System.out.println(fileName); //파일링크를 클릭했을때가 아니라 페이지에 접근했을때 페이지에 있는 모든 파일명이 다 나옴
		
		File file = new File(FileService.IMG_REPO + "/" + fileName);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, response.getOutputStream() );
		//저장소에서 자바로 파일을 가져옴 -> 사용자에게 보내줌(왼쪽에 있는 데이터를 오른쪽으로 보내줌) -> 응답하는 쪽으로 보내줌
		in.close();
	}
}
