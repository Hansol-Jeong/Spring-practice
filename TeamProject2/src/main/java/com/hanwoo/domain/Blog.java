package com.hanwoo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blog {
	@Id
	private Long blog_id;
	private String title;
	private String tag;
	private Long CNT_DISPLAY_POST; 
	private String status;
	private String FILE_NAME;
}
