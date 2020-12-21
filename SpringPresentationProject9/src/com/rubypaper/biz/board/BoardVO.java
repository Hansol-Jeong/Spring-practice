package com.rubypaper.biz.board;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {//번호, 제목, 작성자, 내용, 날짜, 조회수, 검색 컨디션, 검색 키워드
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
	@JsonIgnore
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		String uploadFileName = uploadFile.getOriginalFilename();
		System.out.println(uploadFileName + "파일이 업로드 요청되었습니다.");
		this.uploadFile = uploadFile;
	}
	

	
}
