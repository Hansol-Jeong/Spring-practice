package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOMyBATIS implements UserDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		System.out.println("MyBatis������� insertUser() �մϴ�.");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	public UserVO getUser(UserVO vo) {
		System.out.println("MyBatis������� getUser() �մϴ�.");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
}
