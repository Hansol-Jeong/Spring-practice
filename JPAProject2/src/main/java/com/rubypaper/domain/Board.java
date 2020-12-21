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
	@Id//pk����
	@GeneratedValue(strategy=GenerationType.AUTO)//1�� ����, �� �������ص� auto�� ����Ʈ��( H2�� ����ȭ�� �ĺ��ڰ� ��������(sequence)�� ����.)
	//PK�÷��� ���εǴ� ������ �ĺ��� ������� �Ѵ�.
	private Long seq;

	@Column(nullable=false, length=200)
	private String title;

}
