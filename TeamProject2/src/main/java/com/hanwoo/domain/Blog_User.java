package com.hanwoo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blog_User {
	@Id
	private String user_id;
	private String user_name;
	private String role;
	private String password;
}
