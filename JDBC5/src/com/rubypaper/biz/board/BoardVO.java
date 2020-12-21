package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;
@Data
public class BoardVO {
//순서, 제목, 글쓴이, 내용, 날짜, 조회수, 비밀번호
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String password;
}
