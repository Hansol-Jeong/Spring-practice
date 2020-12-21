package com.rubypaper.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory;

	static {//Ŭ������ �ε����ڸ��� ������ ����ȴ�.
		try {
			if (sessionFactory == null) {
				//mybatis �����̳� ������ ���� ȯ�漳�������� �о �����Ѵ�.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");//�Է� ��Ʈ���� ���̹�Ƽ�� ���� ȯ�漳�������� �о���δ�.
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);//�� ������ �ڵ�� �� �ѹ��� ����ȴ�. �ֳĸ� null�� ���� ó���� �� �ѹ��̴ϱ�
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public static SqlSession getSqlSessionInstance() {
		//�����̳� ���忡�� (sqlsessionfactory)���� mybatis�����̳� �ϳ��� �����Ͽ� �����Ѵ�.
		return sessionFactory.openSession();//�갡�ٷ� ���̹�Ƽ�� �����̳ʴ�.
	}
}
