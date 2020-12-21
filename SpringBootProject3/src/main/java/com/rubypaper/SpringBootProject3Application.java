package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/*@SpringBootConfiguration = Configuration ���� �޸𸮿� ����(component�����̴ϱ�, ȯ�漳���� ���ش�)
//@EnableAutoConfiguration //�˳� �߿���! commonsMultipartResolver������ xml�� bean����ϴ��� �ڵ����� ����
//Fil���ε带 �����Ϸ��� �������� boardController�� �ʿ��ϰ� �����ȸ��� commons~�� �ʿ��ϴ� �ٵ� �������� ��ü�� 
 *///restcontroller�� controller���� componentscan�� ���ؼ� �޸𸮿� ��� �� ������ ���� ������ ������ xml�� bean����� �ؾ߸� �޸𸮿� ���
//�׷��� ���������� �ǳ� ���� ��׸� ����ϴٺ��ϱ� �ڲ� �Ǽ����� ���̺귯���߰��� ��Ÿ�͸� ���ؼ� �������� ����ȭ������ xml������ ��¿�ž� ->�ڵ�����
//������ �ʳ״� �����Ͻ������� ������ -> xml�ڵ����� ���ٰ� = enableautoconfig
//enable�� commonsmultipartresolver���� ���� ������ ���� ��ü���� �޸𸮿� �ڵ����� �����ϴ� ������ �Ѵ�. ���̻� xml�� bean��� ���ص� �ȴ�.
//����� �ϴ��� �߿��ؿ� �� ������̼��� 
/*@ComponentScan*//* = �ش� Ŭ������ ��Ű���� ���̽� ��Ű���� �ش� ��Ű���� ��ĵ�ض� (com.rubypaper) = <context:component-scan base-package="com.rubypaper"/>*/
//@config, repo, service, controller, restcontroller�� �ϳ��������� ��ĵ�ȴ�.
//@ComponentScan(basePackages={"~","~"})
@SpringBootApplication
public class SpringBootProject3Application {
//	WebMvcAutoConfiguration
	public SpringBootProject3Application() {
		System.out.println("������ ����");
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootProject02Application.class, args);
	SpringApplication application = new SpringApplication(SpringBootProject3Application.class);
	application.setWebApplicationType(WebApplicationType.SERVLET); /*resources�� application �� �ܺ�������Ƽ�� �켱������ ����*/
	application.setBannerMode(Banner.Mode.OFF);
	application.run(args);
	}

}





