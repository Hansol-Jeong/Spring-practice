package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {
	@GetMapping("/")
	public void index()
	{
		System.out.println("---> index ������ ��û�Դϴ�.");
//		return "index";
	}
	@GetMapping("/member")
	public void forMember() {
		System.out.println("---> member ������ ��û�Դϴ�.");
//		return "member";// void �� �����ϸ� ��û�������� �����Ѵ�(member.html)
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("---> manager ������ ��û�Դϴ�.");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("---> admin ������ ��û�Դϴ�.");
	}
	
}
