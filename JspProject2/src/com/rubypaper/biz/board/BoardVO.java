package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	// 순서, 제목, 내용, 날짜, 조회수, 암호, 검색조건, 검색 키워드
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int cnt;
	private String password;
	private String searchCondition;
	private String searchKeyword;
}
