package polymorphism3;

// 다형성 = 상속 + Overriding + 형변환
public class TVUser {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV) factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
