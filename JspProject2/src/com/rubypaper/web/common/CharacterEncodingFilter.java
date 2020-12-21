package com.rubypaper.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharacterEncodingFilter implements Filter {

    private String encoding;
    private String name;


	public CharacterEncodingFilter() {
    	System.out.println("===> CharacterEncodingFilter 생성");
    }


	public void init(FilterConfig fConfig) throws ServletException {//서블릿 엔진이 fconfig 값을 채워서 넘겨줍니다.
	//web.xml 파일에 설정된 로컬 파라미터 정보 추출
		encoding = fConfig.getInitParameter("encoding");
		name = fConfig.getInitParameter("name");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(name + "님의 인코딩 필터가 동작중");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}
	public void destroy() {}
	
}
