package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOMyBATIS implements UserDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		System.out.println("MyBatis기반으로 insertUser() 합니다.");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	public UserVO getUser(UserVO vo) {
		System.out.println("MyBatis기반으로 getUser() 합니다.");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
}
