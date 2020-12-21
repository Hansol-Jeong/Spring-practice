package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rubypaper.biz.common.JDBCUtil;

public class UserDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private static final String INSERT_USER = "insert into USERS values(?, ?, ?, ?)";
	private static final String USER_GET = "SELECT * FROM USERS WHERE ID = ? and password = ?";
	
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_USER);

			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);

			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());

			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
		return user;

	}
}