package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOMyBATIS implements UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// USERS ���̺� ���� CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBATIS ������� insertUser() ��� ó��");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBATIS ������� getUser() ��� ó��");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}	
}











