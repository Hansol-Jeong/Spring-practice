package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	public BoardController() {
		System.out.println("===> BoardController created");
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody //응답프로토콜 바디쪽에 담아서 전달하겠다.
	public String hello(String name) {
		return "hello : " + name;
	}
}
