package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
//servlet-context.xml에 있는 경로 하위에 있는 어노테이션을 봄
//설정하는 내용에 넣어주는 어노테이션
//servlet-context.xml 파일에 작성하는걸 최소화하는 요즘 방식. Bean을 만드는 또 다른 방식이므로, 둘중 하나만 사용하면됨
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		//multipartResolver 이름을 다르게쓰면 오류발생
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(52428800);	//최대 50MB
		mr.setDefaultEncoding("utf-8");
		return mr;
	}
}
