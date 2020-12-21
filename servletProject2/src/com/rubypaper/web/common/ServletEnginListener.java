package com.rubypaper.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletEnginListener implements ServletContextListener {


    public ServletEnginListener() {
    	System.out.println("===> ServletEngineListener 생성");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> 서블릿 엔진이 생성된 직후에 무조건 실행");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> 서블릿 엔진이 삭제되기 직전에 무조건 실행");
    }

	
}
