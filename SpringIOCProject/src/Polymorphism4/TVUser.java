package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. ������ IoC(Inversion of Control) �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ������ IoC �����̳ʷκ��� ��ü�� �˻�(Lookup)�Ѵ�.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeDown(); 
		tv.volumeUp();		
		tv.powerOff();
		
		// 3. ������ IoC �����̳ʸ� �����Ѵ�.
		container.close();
	}
}
