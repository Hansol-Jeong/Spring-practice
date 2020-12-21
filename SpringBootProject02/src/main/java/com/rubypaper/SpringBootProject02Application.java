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
	application.setWebApplicationType(WebApplicationType.SERVLET); /*resources에 application 의 외부프로퍼티의 우선순위가 상위*/
	application.setBannerMode(Banner.Mode.OFF);
	application.run(args);
	}

}





