package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages= {"com.google"})//�� ����� @component��ü�鵵 �޸𸮿� ����.
public class TVConfiguration {
	@Bean(name="stv")//�ڵ����� bean�޼ҵ� ������Ѽ� �ش� ��ü�� �޸𸮿� ����.
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
