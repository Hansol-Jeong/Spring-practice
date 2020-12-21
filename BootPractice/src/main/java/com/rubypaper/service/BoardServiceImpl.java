package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {// autowired로  BoardService객체 하나 끌어와서 써
	@Autowired 
	private BoardRepository boardRepo; //BoardRepository 인터페이스를 상속한 객체
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	@Override
	public void deleteBoard(Board board) {	
		boardRepo.deleteById(board.getSeq());
	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		//findBoard = board;//이거 되나 어차피 업데이트 안되는 항목은 정해 놨잖아
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(board);
	}

	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public List<Board> getBoardList() {
		return (List<Board>) boardRepo.findAll();
	}

}
