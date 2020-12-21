package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProject02Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootProject02Application.class, args);
	SpringApplication application = new SpringApplication(SpringBootProject02Application.class);
	application.setWebApplicationType(WebApplicationType.SERVLET); /*resources�� application �� �ܺ�������Ƽ�� �켱������ ����*/
	application.setBannerMode(Banner.Mode.OFF);
	application.run(args);
	}

}





