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
	@Id//pk����
	@GeneratedValue(strategy=GenerationType.AUTO)//1�� ����, �� �������ص� auto�� ����Ʈ��( H2�� ����ȭ�� �ĺ��ڰ� ��������(sequence)�� ����.)
	//PK�÷��� ���εǴ� ������ �ĺ��� ������� �Ѵ�.
	private Long seq;

	@Column(nullable=false, length=200)
	private String title;

	@Column(nullable=false, updatable=false)//�� �÷��� ������Ʈ���� ���ܽ��Ѷ�
	private String writer;

	@Column(nullable=false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)//~�� �����ض�. TIMESTAMP:��¥(�����)+�ð�(�ú���)
	@Column(columnDefinition="date default sysdate")//Ÿ�� ����Ʈ �� -> �⺻��
	private Date createDate = new Date();

	@Column(columnDefinition="number default 0")
	private Long cnt;
	
	@Transient//�� ������ ����ȭ ��Ű�� ����. ���̺� �� ������ �ش��ϴ� �÷��� ����������
	private String searchCondition;

	@Transient
	private String searchKeyword;
}
