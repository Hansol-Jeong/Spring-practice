package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages= {"com.google"})//이 경로의 @component객체들도 메모리에 띄운다.
public class TVConfiguration {
	@Bean(name="stv")//자동으로 bean메소드 실행시켜서 해당 객체를 메모리에 띄운다.
	public SamsungTV tv() {
		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
		return new SamsungTV();
	}
	@Bean
	public  AppleSpeaker speaker() {
		return new AppleSpeaker();
	}
}
