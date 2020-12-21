package com.rubypaper.biz.board;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {//��ȣ, ����, �ۼ���, ����, ��¥, ��ȸ��, �˻� �����, �˻� Ű����
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
		System.out.println(uploadFileName + "������ ���ε� ��û�Ǿ����ϴ�.");
		this.uploadFile = uploadFile;
	}
	

	
}
