package Polymorphism3;

public class BeanFactory {//Factory디자인 패턴
    //Bean -> 객체, BeanFactory:객체 공장
    public Object getBean(String id) {
        if(id.equals("lg")) {
            return new LgTv();
        } else if(id.equals("samsung")) {
            return new SamsungTV();
        }
        else if(id.equals("Google")) {
            return new GoogleTV();
        }//분기 계속 만들어줘야해 -> Spring frame work로 간다!(자바 소스 안건드리고 유지보수가 가능하다.)
        return null;
    }
}
