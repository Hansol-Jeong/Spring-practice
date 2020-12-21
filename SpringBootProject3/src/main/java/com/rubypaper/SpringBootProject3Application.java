package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/*@SpringBootConfiguration = Configuration 먼저 메모리에 띄운다(component포함이니까, 환경설정도 해준다)
//@EnableAutoConfiguration //쫀나 중요해! commonsMultipartResolver일일히 xml에 bean등록하던걸 자동으로 해줌
//Fil업로드를 구현하려면 내가만든 boardController가 필요하고 내가안만든 commons~가 필요하다 근데 내가만든 객체는 
 *///restcontroller나 controller같이 componentscan을 통해서 메모리에 띄울 수 있지만 내가 만들지 않은건 xml에 bean등록을 해야만 메모리에 뜬다
//그런데 뭐가문제가 되냐 내가 얘네를 등록하다보니까 자꾸 실수를해 라이브러리추가는 스타터를 통해서 복잡함을 간소화했지만 xml설정은 어쩔거야 ->자동으로
//개발자 너네는 비지니스로직만 집중해 -> xml자동으로 해줄게 = enableautoconfig
//enable은 commonsmultipartresolver같은 내가 만들지 않은 객체들을 메모리에 자동으로 생성하는 역할을 한다. 더이상 xml에 bean등록 안해도 된다.
//어떤일을 하느냐 중요해요 이 어노테이션이 
/*@ComponentScan*//* = 해당 클래스의 패키지를 베이스 패키지로 해당 패키지를 스캔해라 (com.rubypaper) = <context:component-scan base-package="com.rubypaper"/>*/
//@config, repo, service, controller, restcontroller중 하나라도있으며 스캔된다.
//@ComponentScan(basePackages={"~","~"})
@SpringBootApplication
public class SpringBootProject3Application {
//	WebMvcAutoConfiguration
	public SpringBootProject3Application() {
		System.out.println("스프링 시작");
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootProject02Application.class, args);
	SpringApplication application = new SpringApplication(SpringBootProject3Application.class);
	application.setWebApplicationType(WebApplicationType.SERVLET); /*resources에 application 의 외부프로퍼티의 우선순위가 상위*/
	application.setBannerMode(Banner.Mode.OFF);
	application.run(args);
	}

}





