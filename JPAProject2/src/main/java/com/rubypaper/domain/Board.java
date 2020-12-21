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
@Table(name="NEW_BOARD") 
public class Board {
	@Id//pk설정
	@GeneratedValue(strategy=GenerationType.AUTO)//1씩 증가, 저 설정안해도 auto가 디폴트값( H2에 최적화된 식별자값 생성전략(sequence)을 쓴다.)
	//PK컬럼과 매핑되는 변수를 식별자 변수라고 한다.
	private Long seq;

	@Column(nullable=false, length=200)
	private String title;

}
