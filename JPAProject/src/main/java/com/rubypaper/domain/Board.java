package com.rubypaper.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import lombok.Data;



@Data
@Entity
@Table(name="NEW_BOARD", 
       uniqueConstraints={@UniqueConstraint(columnNames={"SEQ", "WRITER"})}) 
public class Board {
	@Id//pk설정
	@GeneratedValue(strategy=GenerationType.AUTO)//1씩 증가, 저 설정안해도 auto가 디폴트값( H2에 최적화된 식별자값 생성전략(sequence)을 쓴다.)
	//PK컬럼과 매핑되는 변수를 식별자 변수라고 한다.
	private Long seq;

	@Column(nullable=false, length=200)
	private String title;

	@Column(nullable=false, updatable=false)//이 컬럼은 업데이트에서 제외시켜라
	private String writer;

	@Column(nullable=false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)//~만 저장해라. TIMESTAMP:날짜(년월일)+시간(시분초)
	@Column(columnDefinition="date default sysdate")//타입 디폴트 값 -> 기본값
	private Date createDate = new Date();

	@Column(columnDefinition="number default 0")
	private Long cnt;
	
	@Transient//이 변수는 영속화 시키지 말라. 테이블에 이 변수에 해당하는 컬럼을 만들지마라
	private String searchCondition;

	@Transient
	private String searchKeyword;
}
