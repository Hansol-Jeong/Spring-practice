package com.hanwoo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	private Long POST_ID;
	private Long CATEGORY_ID;
	private String TITLE; 
	private String CONTENT;
}
