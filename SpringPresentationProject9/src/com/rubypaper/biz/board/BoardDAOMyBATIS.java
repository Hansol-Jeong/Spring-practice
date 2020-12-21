package com.rubypaper.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDAOMyBATIS {
	@Autowired
	private SqlSessionTemplate mybatis;
	public void insertBoard(BoardVO vo) {
		System.out.println("MyBatis 기반으로 insertBoard() 합니다.");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("MyBatis 기반으로 updateBoard() 합니다.");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("MyBatis 기반으로 deleteBoard() 합니다.");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("MyBatis 기반으로 getBoard() 합니다.");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("MyBatis 기반으로 getBoardList() 합니다.");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
