package com.rubypaper.biz.board;

import java.util.List;

public interface BoardDAO {
	void insertBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);
	
}
