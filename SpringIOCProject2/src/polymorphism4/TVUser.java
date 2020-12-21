package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// 1. ������ IoC(Inversion of Control) �����̳ʸ� ����(����)�Ѵ�.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("�����ε��� �´°�");
		
		// 2. ������ IoC �����̳ʷκ��� ��ü�� �˻�(Lookup)�Ѵ�.
		TV tv = (TV) container.getBean("tv");
		System.out.println(tv.toString());
		tv.powerOn();
		tv.volumeDown(); 
		tv.volumeUp();		
		tv.powerOff();
		
		TV tv1 = (TV) container.getBean("tv");
		System.out.println(tv1.toString());
		
		// 3. ������ IoC �����̳ʸ� �����Ѵ�.
		container.close();
	}
}
