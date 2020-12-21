package Polymorphism2;

//다형성 = 상속 + Overriding + 형변환
public class TVUser {
    public static void main(String[] args) {
        TV tv = new SamsungTV();
        tv.powerOn();
        tv.powerOff();
        tv.volumeDown();
        tv.volumeUp();
        TV tv2 = new LgTv();
        tv2.powerOn();
        tv2.powerOff();
        tv2.volumeDown();
        tv2.volumeUp(); //뭐하러 이렇게 하냐 하나하나 다 뜯어고쳐야 되잖아
// Polymorhpism: one interface multiful implementation.
        //어떻게 하면 클라이언트를 아예 안바꾸고 수정할 수 있을까 -> 디자인 패턴
    }
}
