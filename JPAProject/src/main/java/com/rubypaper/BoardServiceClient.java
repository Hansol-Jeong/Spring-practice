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
		EntityTransaction tx = em.getTransaction();
		try {
			//비영속 상태의 엔티티 객체
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("JPA 제목");
			board.setContent("JPA 내용");
			board.setCreateDate(new Date());
			board.setCnt(0L);

			// 글 등록 처리
			// tx시작 (select과정은 tx필요없어)
//			tx.begin();
			//영속 상태로 만드는 persist(JPA컨테이넣에 넣은 상태), 근데 테이블에 이 값이 없네? -> insert
//			em.persist(board);
//			board.setTitle("수정");//영속 상태로 바뀌어있는 객체의 변수값을 수정하면 내부적으로 업데이트 발생 -> update
			//writer는 updatable=false이기 때문에 업데이트안된다
			
//			Board board1 = em.find(Board.class, 1L);//지금 위에서 막생긴거야 그러니까 영속컨테이너는 비어있어 그니까db에서 select해와
//			System.out.println(board1.toString()); //insert만 실행되지 select는실행되지 않는다.(검색결과는 있는데)
			//Board 엔티티를 생성하고 seq는 자동으로 1이 증가해, 하지만 얘가 아직 비 영속상태 > perisit > 영속상태 이 때 1번 seq에 해당하는 엔티티가 db에 없으니 db에 insert를 실행해
			//근데 내가 1번 seq 엔티티를 find할 때  영속성 컨테이너에 1번을 요청하게 되고 현재 1번 엔티티가 컨텍스트에 있는상태야 -> select안하고 바로 리턴해준다(메모리에 있는).
			//그런데 중요한건 현재 2번을 select할려고 할 때 영속성 컨텍스트에는 1번밖에 없으면 db에서 select해서 영속성 컨텍스트에 추가한다(메모리에 띄운다). 근데 컨테이너새로만들어서 1번조차없어 그래도 select해
//			select기능은 tx기능이 필요없다.
			//tx 종료
//			tx.commit(); //이 때 영속상태에 있는 객체의 값을 바꾸면 자동으로 jpa컨테이너가 update를 해준다.
			//find메소드는 상세조회인데 jpa컨테이너객체를 선택하면 select가 안된다. jpa가 가지고있지 않은 객체를 db에서 가져와야 select가 실행이된다. 새로운 entity를 생성하고db에서값을받아 영속상태가된다.
			tx.begin();
			em.persist(board);
			
//			em.detach(board);//jpa컨테이너의 통제를 받지 않는다.
//			board.setTitle("준영속상태가 되면 값을 바꿔도 업데이트가 되지 않아요");
//			em.merge(board);//준영속상태가 된 entity는 merge를 통해 다시 영속상태로 되돌릴 수 있다. 근데 오류나네
//			board.setTitle("merge로 되돌렸어요.");
			em.remove(board);//삭제상태는 jpa컨테이너에서 entity를 제거하는겁니다. 삭제상태는 객체를 생성한 비 영속상태와 같습니다. 메모리에서 없어진건 아니다.
//			remove상태의 객체를 재활용하는것은 좋지않다 persist로 재활용하지말고 garbagecollection이 수거하게 냅두고 persist로 다시 생성는 편이 더 좋다.

			tx.commit();
			

			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
