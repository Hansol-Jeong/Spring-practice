package com.rubypaper.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.rubypaper.biz.board.BoardService;

public class UserServiceClient {
	public static void main(String[] args) {
	GenericXmlApplicationContext container = new GenericXmlApplicationContext();
	
	UserService userService = (UserService) container.getBean("userService");
	
	UserVO vo = new UserVO();
	vo.setId("admin");
	vo.setPassword("admin");
	UserVO user = userService.getUser(vo);
	if(user != null) {
		System.out.println(user.getName() + "님 환영합니다!");
	} else {
		System.out.println("로그인 실패");
	}
	container.close();
	}
}
