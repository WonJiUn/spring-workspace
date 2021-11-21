package com.care.root.mybatis;


import java.util.List;

import com.care.root.dto.ShoesDTO;

public interface FileMapper {
	public void saveData(ShoesDTO dto);
	public List<ShoesDTO> getShoesImage();
	//보통 부모형태인 List로 많이 사용함
}
