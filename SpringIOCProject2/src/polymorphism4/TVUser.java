package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. 스프링 IoC(Inversion of Control) 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("프리로딩이 맞는가");
		
		// 2. 스프링 IoC 컨테이너로부터 객체를 검색(Lookup)한다.
		TV tv = (TV) container.getBean("tv");
		System.out.println(tv.toString());
		tv.powerOn();
		tv.volumeDown(); 
		tv.volumeUp();		
		tv.powerOff();
		
		TV tv1 = (TV) container.getBean("tv");
		System.out.println(tv1.toString());
		
		// 3. 스프링 IoC 컨테이너를 종료한다.
		container.close();
	}
}
