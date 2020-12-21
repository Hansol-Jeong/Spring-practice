package sol.com;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepoTest {
	@Autowired
	BoardRepo boardRepo; 

	@Test
	public void test() {
		Board board = new Board();
		board.setTitle("첫 번째 게시글");
		board.setWriter("첫 번째 게시자");
		board.setContent("잘 등록 됩니까");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		boardRepo.save(board);
	}
//	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board);
	}
//	@Test
	public void testUpdateBoard() {
		System.out.println("1번 게시글 조회");
		Board board = boardRepo.findById(1L).get();
		System.out.println("1번 게시글 제목 수정");
		board.setTitle("제목 수정");
		boardRepo.save(board);
	}

}
