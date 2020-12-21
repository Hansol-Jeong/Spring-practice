package com.rubypaper.biz.user;

import lombok.Data;
@Data
public class UserVO {// id, password, name, role

	private String id;
	private String password;
	private String name;
	private String role;
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + "| password=" + password + "| name=" + name+ "| role=" + role + "]";
	}
}
