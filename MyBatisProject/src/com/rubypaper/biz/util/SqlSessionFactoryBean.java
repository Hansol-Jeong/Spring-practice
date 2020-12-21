package com.rubypaper.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory;

	static {//클래스가 로딩되자마자 무조건 실행된다.
		try {
			if (sessionFactory == null) {
				//mybatis 컨테이너 공장을 메인 환경설정파일을 읽어서 생성한다.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");//입력 스트림이 마이바티스 메인 환경설정파일을 읽어들인다.
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);//이 두줄의 코드는 단 한번만 실행된다. 왜냐면 null인 경우는 처음에 딱 한번이니까
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static SqlSession getSqlSessionInstance() {
		//컨테이너 공장에서 (sqlsessionfactory)에서 mybatis컨테이너 하나를 생성하여 리턴한다.
		return sessionFactory.openSession();//얘가바로 마이바티스 컨테이너다.
	}
}
