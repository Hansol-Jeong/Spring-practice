package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
public static void main(String[] args) {
	//������ �����̳�
	AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");//com.rubypaper.tv�ص� �ǰ� TVConfiguration.class�ص���
	SamsungTV tv = (SamsungTV) container.getBean("stv");
	
	tv.powerOn();
	tv.poweroff();
	tv.volumUp();
	tv.volumDown();
}
}
