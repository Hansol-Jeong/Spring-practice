package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class BoardServiceClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();// jpa컨테이너
	
		try {
			EntityTransaction tx1 = em.getTransaction();
			tx1.begin();
			//비영속 상태의 엔티티 객체
			Board board = new Board();
			board.setTitle("JPA 제목");
			//글 등록 처리
			em.persist(board);
			
			Board findBoard1 = em.find(Board.class, 1L); //select 이루어지지 않습니다. 검색은 이때 이루어지고
			Board findBoard2 = em.find(Board.class, 1L); //이 두개가 참조하는 메모리 주소는 똑같다.
			System.out.println(findBoard1.toString());
			tx1.commit();//insert는 이 때 이루어집니다.
//			tx1.commit();
			
//			EntityTransaction tx2 = em.getTransaction();
//			tx2.begin();
//			//준 영속 상태로 전환시킨다.
//			em.detach(board);
//			board.setTitle("수정된 제목");
//			//영속 상태
//			em.merge(board);//1차 캐쉬로
//			tx2.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
