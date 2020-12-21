package Polymorphism3;

public class GoogleTV implements TV {
    public GoogleTV() {
        System.out.println("===> GoogleTV 생성");
    } //
    @Override
    public void powerOn() {
        System.out.println("GoogleTV---전원 켠다");
    }
    @Override
    public void powerOff() {
        System.out.println("GoogleTV---전원 끈다");
    }
    @Override
    public void volumeUp() {
        System.out.println("GoogleTV---소리 올린다");
    }
    @Override
    public void volumeDown() {
        System.out.println("GoogleTV---소리 내린다");
    }
}
