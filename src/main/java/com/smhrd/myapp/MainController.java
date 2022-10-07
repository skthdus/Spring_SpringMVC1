package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//컨트롤러 지정, Model 객체(데이터 저장) 만들기 + View 반환(String)
@Controller
public class MainController {

	//요청과 특정메서드 매핑
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainPage() {
		return "main";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinPage() {
		return "join";
	}
}
