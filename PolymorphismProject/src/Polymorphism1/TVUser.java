package Polymorphism1;

public class TVUser {
    public static void main(String[] args) {
        SamsungTV tv = new SamsungTV();
        tv.powerOn();
        tv.powerOff();
        tv.volumeDown();
        tv.volumeUp();
        LgTv tv2 = new LgTv();
        tv2.soundDown();
        tv2.soundUp();
        tv2.turnOff();
        tv2.turnOn(); //뭐하러 이렇게 하냐 하나하나 다 뜯어고쳐야 되잖아

    }
}
