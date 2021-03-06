package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper fm;
	
	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		
		if(file.getSize() != 0) {	// !file.isEmpty() 사용자가 선택한 파일이 존재하는 경우
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			
			String sysFileName = format.format(calendar.getTime());	//현재의 시간을 위의 형식으로 만들어줌
			sysFileName += file.getOriginalFilename();
		
			dto.setImgName(sysFileName);
			//사용자가 선택한 파일이 있는 경우에만 dto에 이미지이름 세터 추가
			
			File saveFile = new File(IMG_REPO + "/" + sysFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
			//사용자가 선택한 파일이 없는경우
		}
		fm.saveData(dto);
	}

	@Override
	public void getShoesImage(Model model) {
		model.addAttribute("list", fm.getShoesImage());
		
	}

	
	
}
