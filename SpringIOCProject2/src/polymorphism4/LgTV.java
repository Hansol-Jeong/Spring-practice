package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean id="tv" class="polymorphism4.LgTV"></bean> : id="polymorphism4.LgTV#0"
@Component("ltv")                                 // : id="lgTV"
public class LgTV implements TV {
	
	@Autowired
	private Speaker speaker;

	public LgTV() {
		System.out.println("===> LgTV ����");
	}
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}
