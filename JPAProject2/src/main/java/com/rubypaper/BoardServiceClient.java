package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class BoardServiceClient {
	public static void main(String[] args) {
		// EntityManager ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();// jpa�����̳�
	
		try {
			EntityTransaction tx1 = em.getTransaction();
			tx1.begin();
			//�񿵼� ������ ��ƼƼ ��ü
			Board board = new Board();
			board.setTitle("JPA ����");
			//�� ��� ó��
			em.persist(board);
			
			Board findBoard1 = em.find(Board.class, 1L); //select �̷������ �ʽ��ϴ�. �˻��� �̶� �̷������
			Board findBoard2 = em.find(Board.class, 1L); //�� �ΰ��� �����ϴ� �޸� �ּҴ� �Ȱ���.
			System.out.println(findBoard1.toString());
			tx1.commit();//insert�� �� �� �̷�����ϴ�.
//			tx1.commit();
			
//			EntityTransaction tx2 = em.getTransaction();
//			tx2.begin();
//			//�� ���� ���·� ��ȯ��Ų��.
//			em.detach(board);
//			board.setTitle("������ ����");
//			//���� ����
//			em.merge(board);//1�� ĳ����
//			tx2.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
