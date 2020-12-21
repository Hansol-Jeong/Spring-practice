package com.rubypaper.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;
import java.lang.String;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
	/*List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByContentContaining(String searchKeyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	List<Board> findByContentContainingOrderBySeqDesc(String searchKeyword);
	
//	List<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	// @Query 어노테이션을 이용한 JPQL 등록
		// JPQL은 검색대상이 테이블이 아니라 영속 상태에 있는 엔티티 객체들이다.
		//그리고 colum이 사용되는 것이 아니라 변수 이름이 사용이 된다.(Select, where, order by, group by)
		// 테이블에 있는 데이터를 다 셀렉트 해버리기 떄문에(where 절 없으면) 1차 캐시안에 entity가 다올라가버려서 메모리사용량이 많다.
		//jpql로 작성해도 jpql은 sql로 변환이 되서 동작한다.
//		@Query("SELECT b FROM Board AS b WHERE b.title like %?1% ORDER BY b.seq DESC")//from 뒤에 테이블이 아니라 entity클래스 이름이옴, as생략 가능
//	List<Board> queryAnnotationTest1(String searchKeyword);
	@Query("SELECT b FROM Board AS b WHERE b.title like %:keyword% ORDER BY b.seq DESC")	
	List<Board> queryAnnotationTest1(@Param("keyword")String keyword);
	
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board AS b WHERE b.title like %:keyword% ORDER BY b.seq DESC")	
	List<Object[]> queryAnnotationTest2(@Param("keyword")String keyword);
	
	@Query("SELECT b FROM Board AS b ORDER BY b.seq DESC")	
	List<Board> queryAnnotationTest3(Pageable pageable);*/
	
}









