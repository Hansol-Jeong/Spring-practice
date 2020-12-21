package com.rubypaper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.DynamicBoardRepository;
import com.rubypaper.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDslTest {

	@Autowired
	private DynamicBoardRepository boardRepo;

	@Test
	public void testDynamicQuery() {
		//검색 관련 정보 설정
		String condition = "TITLE";
		String keyword = "douner";
		
		BooleanBuilder builder = new BooleanBuilder();//다이나믹 쿼리를 만드는 객체
		QBoard qboard = QBoard.board;
		
		if(condition.equals("TITLE")) {
			//쿼리를 동적으로 생성한다
			builder.and(qboard.title.like("%" + keyword + "%"));
		} else if(condition.equals("CONTENT")) {
			//쿼리를 동적으로 생성한다.
			builder.and(qboard.content.like("%" + keyword + "%"));
		}
		
		//모든 글 목록을 검색한다.
		Pageable pageable = PageRequest.of(0, 5);
		Page<Board> boardList = boardRepo.findAll(builder, pageable);            

		System.out.println("검색 결과");
		 for (Board board : boardList.getContent()) {//실제 검색 결과만 받으러면 getContnet()
			 System.out.println("---> " + board.toString());
		 }
	}

}










