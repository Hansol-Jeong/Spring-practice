package com.rubypaper.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			// 1. 드라이버 객체를 메모리에 로딩한다.
			Class.forName("org.h2.Driver");
			// 2. Connection 객체를 획득한다.
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Select 기능의 자원 해제
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		try {
			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if (!conn.isClosed() && conn != null)// 而ㅻ꽖�뀡�씠 �떕�엺 �긽�깭媛� �븘�땲�씪硫�
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// not select 기능의 자원 해제
	public static void close(PreparedStatement stmt, Connection conn) {
		try {
			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if (!conn.isClosed() && conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
