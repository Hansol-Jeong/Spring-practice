package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {
	@GetMapping("/")
	public void index()
	{
		System.out.println("---> index 페이지 요청입니다.");
//		return "index";
	}
	@GetMapping("/member")
	public void forMember() {
		System.out.println("---> member 페이지 요청입니다.");
//		return "member";// void 로 설정하면 요청페이지를 실행한다(member.html)
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("---> manager 페이지 요청입니다.");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("---> admin 페이지 요청입니다.");
	}
	
}
