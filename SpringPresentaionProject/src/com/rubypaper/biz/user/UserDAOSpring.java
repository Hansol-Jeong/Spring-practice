package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//@Repository
public class UserDAOSpring implements UserDAO {
	@Autowired
	private JdbcTemplate spring;

	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 insertUser() 기능 처리");
		Object[] args = { USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole() };
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUser() 기능 처리");
		Object[] args = { vo.getId(), vo.getPassword() };

		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}

}
