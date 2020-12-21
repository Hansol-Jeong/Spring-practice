package Polymorphism2;

public class LgTv implements TV{
        public LgTv() {
            System.out.println("===> LgTv 생성");
        } //


    @Override
    public void powerOn() {
        System.out.println("LgTv---전원 켠다");
    }

    @Override
    public void powerOff() {
        System.out.println("LgTv---전원 끈다");
    }
    @Override
    public void volumeUp() {
            System.out.println("LgTv---소리 올린다");
    }

    @Override
    public void volumeDown() {
            System.out.println("LgTv---소리 내린다");
    }
}
