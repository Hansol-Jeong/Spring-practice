package com.rubypaper.jdbc.util;

import lombok.Data;

@Data
public class JDBCConnectionManager {//enableautoconfig에 등록해서 동작을 한다
	private String driverClass;
	private String url;
	private String username;
	private String password;	
	public JDBCConnectionManager() {
		System.out.println("===> JDBCConnectionManager생성");
	}
}
