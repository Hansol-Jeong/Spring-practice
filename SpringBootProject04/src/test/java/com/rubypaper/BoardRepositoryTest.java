package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)//테스트하기위한 설정
@SpringBootTest//junit기반의 테스트 케이스를 만드는즁, 내가 테스트하고자하는 모든 객체를 메모리에 띄워주니까 autowired로 의존성 주입 해줄 수 있음
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L); //지우기 위해서 우선 select해준다 (1차 캐시에 없을 경우)
	}
	
//	@Test
	public void testUpdateBoard() {
		Board board = boardRepo.findById(1L).get();
		board.setTitle("수정");
		boardRepo.save(board);//entity가 인자로 전달이 됬는데 테이블에 해당 entity가 있으면 update하고 실제 존재하지 않으면 insert가 실행된다.
	}
	
//	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
//	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("Boot JPA 테스트");
		
		boardRepo.save(board);// persist랑 같은 과정
	}
	
	
	
}
