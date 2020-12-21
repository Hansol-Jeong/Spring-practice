package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
public static void main(String[] args) {
	//스프링 컨테이너
	AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext("com.rubypaper.tv");//com.rubypaper.tv해도 되고 TVConfiguration.class해도되
	SamsungTV tv = (SamsungTV) container.getBean("stv");
	
	tv.powerOn();
	tv.poweroff();
	tv.volumUp();
	tv.volumDown();
}
}
