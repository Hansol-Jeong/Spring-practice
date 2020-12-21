package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepo;
	
/*//	@Before
	public void dataPrepare() {
		for (int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 : " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
	
//	@Test
	public void testFindByTitleContaining() {
		//page 번호는 0 부터 시작한다. 따라서 1페이지를 보고 싶으면 0
		//size 몇 건의 데이터를 가져올 것인지 지정한다.
		Pageable pageable = PageRequest.of(0, 12, Sort.Direction.DESC, "seq");
		Page<Board> pageInfo = boardRepo.findByTitleContaining("17", pageable);
		System.out.println("Page Size: " + pageInfo.getSize());
		System.out.println("Total Pages: " + pageInfo.getTotalPages());
		System.out.println("Total Count: " + pageInfo.getTotalElements());
		System.out.println("Next Page: " + pageInfo.nextPageable());
		
		List<Board> boardList = pageInfo.getContent();
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
//	@Test
//	public void testFindByTitleContaining() {
//		//page 번호는 0 부터 시작한다. 따라서 1페이지를 보고 싶으면 0
//		//size 몇 건의 데이터를 가져올 것인지 지정한다.
//		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
//		List<Board> boardList = boardRepo.findByTitleContaining("17", pageable);
//		System.out.println("검색결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
	public void testFindByContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByContentContainingOrderBySeqDesc("17");
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
//	@Test
	public void testFindByTitleContainingContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("15", "17");
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
//	@Test
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
//	@Test
	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목 : 10");
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}*/

}

//update에서도 @before주석안하면 계속 새로 데이터 넣나?








