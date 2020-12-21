package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// DAO(Data Access Object) 클래스
//@Repository
public class UserDAOMyBATIS implements UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 insertUser() 기능 처리");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBATIS 기반으로 getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}	
}











