package com.hanwoo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {
	@Id
	private Long CATEGORY_ID;
	private Long blog_id;
	private String CATEGORY_NAME; 
	private String DISPLAY_TYPE;
	private Long CNT_DISPLAY_POS;
	private String DESCRIPTION;
	private Date CREATED_DATE;
	private Date MODIFIED_DATE;
}
