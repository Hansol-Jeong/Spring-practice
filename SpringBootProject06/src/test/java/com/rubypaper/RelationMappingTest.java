package com.rubypaper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member1");
	}
//	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("duly");
//		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("douner");
//		memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1); // ��由ш� �깅��� 寃��� 湲�
			board.setTitle("duly : " + i);
			board.setCreateDate(new Date());
//			boardRepo.save(board);
		}
		
		memberRepo.save(member1);
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2); // ���곕��媛� �깅��� 寃��� 湲�
			board.setTitle("douner : " + i);
			board.setCreateDate(new Date());
//			boardRepo.save(board);
		}
		memberRepo.save(member2);//회원이 등록되면서 회원이 가지고있는 boardList(글목록)도 등록이 될 것이다.
	}
	
//	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("[ " + member.getName() + "媛� �깅��� 寃���湲� ��蹂� ]");
		
		List<Board> boardList = member.getBoardList();
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
//	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		System.out.println("[ " + board.getSeq() + "踰� 寃���湲� ��蹂� ]");
		System.out.println("��紐� : " + board.getTitle());
//		System.out.println("���깆�� : " + board.getMember().getName());
//		System.out.println("���깆�� ID : " + board.getMember().getId());
	}

}










