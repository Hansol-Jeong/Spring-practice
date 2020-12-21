package com.rubypaper.biz.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {//Value Object 의 값들로는 순서, 타이틀, 작성자, 내용, 날짜, 조회수, 패스워드
private int seq;
private String title;
private String writer;
private String content;
private Date regDate;
private int cnt;
private String password;
}
