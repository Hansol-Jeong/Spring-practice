package com.rubypaper.biz.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserVO> {
	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user = new UserVO();
		user.setId(rs.getString("ID"));//1
		user.setPassword(rs.getString("PASSWORD"));//2
		user.setName(rs.getString("NAME"));//3
		user.setRole(rs.getString("ROLE"));//4로 대체할 수 있음 따옴표를
		return user;
	}
}
