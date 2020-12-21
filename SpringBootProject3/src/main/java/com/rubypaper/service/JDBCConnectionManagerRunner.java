package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner {
@Autowired
private JDBCConnectionManager manager;
	public JDBCConnectionManagerRunner() {
		System.out.println("===> JDBCConnectionManagerRunner ����");
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Ŀ�ؼ� �Ŵ���: " + manager.toString());
		
	}

}
