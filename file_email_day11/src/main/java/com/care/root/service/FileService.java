package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	//경로는 \\로 써도 되고 /로 써도 됨
	public static final String IMG_REPO = "C:/spring/image_repo";
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getShoesImage(Model model);
}
