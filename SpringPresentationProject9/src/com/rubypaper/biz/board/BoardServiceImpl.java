package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.board.BoardService#insertBoard(com.rubypaper.biz.board.BoardVO)
	 */
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}
	
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.board.BoardService#deleteBoard(com.rubypaper.biz.board.BoardVO)
	 */
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.board.BoardService#updateBoard(com.rubypaper.biz.board.BoardVO)
	 */
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.board.BoardService#getBoard(com.rubypaper.biz.board.BoardVO)
	 */
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.board.BoardService#getBoardList(com.rubypaper.biz.board.BoardVO)
	 */
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
}
