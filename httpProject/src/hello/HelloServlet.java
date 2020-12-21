package hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 클래스 작성 규칙
//1. HttpServlet 클래스를 상속해야 한다. 그래야 서블릿 클래스라고 인식할 수 있다(서블릿 엔진이 인식하고 이 클래스를 메모리에 생성한다)
//2. public 클래스로 만들어야 한다. 서블릿 엔진이 접근할 수 있기 위해
//3. default 생성자가 있어야 한다.
//4. 요청 방식(method) 에 따라 goGet이나 doPost를 재정의(Overriding)한다.
//5. 부모 HttpServlet 클래스의 메소드를 재정의 하지 않으면 상속된다.
//이클립스가 알아서 해준다.

// HelloServlet bean = new HelloServlet(); 실행한다는 것 없고
// bean.doGet();메소드 호출안했는데 실행이 된다 -> servlet엔진이라는 놈이 실행해준다
// 서블릿 엔진이 실행될 때 web.xml을 파라미터로 받아온다
//톰캣은 자바로 구현이 되있다. 톰캣실행하면 톰캣 클래스 객체가 생성이 되고 web.xml파일을 읽어서 서블릿 엔진이라는 객체라 생성이 되야 xml에 명시한 
//대로 서블릿 엔진이 서블릿 객체를 생성하고(HelloServlet()) 실행까지 해준다(doGet자동 호출함).

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public HelloServlet() {
    	System.out.println("===> HelloServlet 객체 생성");
    }//hello.do페이지 들어오면(xml에 명시한 대로) HelloServlet을 실행한다.


    public void init(ServletConfig config) throws ServletException {
		System.out.println("===> init() 호출");
    }
    
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("===> service() 호출");
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> doGet() 호출");
	}

	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===> doPostd() 호출");    
	}

	public void destroy() {
		System.out.println("===> destroy() 호출");
	}

	
}
