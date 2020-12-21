package Polymorphism3;

//다형성 = 상속 + Overriding + 형변환
public class TVUser3 {
    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();

        TV tv = (TV) factory.getBean(args[0]);
        tv.powerOff();
        tv.powerOn();
        tv.volumeDown();
        tv.volumeUp();
    }
}
