package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Board {//Id는 seq, pk, 1씩 자동증가, 전략=자동(jpa쓰겠다고)/ title / writer는 업데이트 되지않아 작성자 변경 안할거야
	// content, createDate는 insert안해, 업데이트 안해, 초깃값 줄거야
	// cnt 도 insert안하고, 업데이트 안하고, 초깃값 줄거야
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date createDate;
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;
}
