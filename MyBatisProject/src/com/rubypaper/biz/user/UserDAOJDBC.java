package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOJDBC {


	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET    = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";


	public void insertUser(UserVO vo) {
		System.out.println("===> Mybatis ������� insertUser() ��� ó��");
	}
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis ������� getUser() ��� ó��");
		return null;
	}	
}




