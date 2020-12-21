package com.rubypaper.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDAOMyBATIS {
	@Autowired
	private SqlSessionTemplate mybatis;
	public void insertBoard(BoardVO vo) {
		System.out.println("MyBatis ������� insertBoard() �մϴ�.");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("MyBatis ������� updateBoard() �մϴ�.");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("MyBatis ������� deleteBoard() �մϴ�.");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("MyBatis ������� getBoard() �մϴ�.");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("MyBatis ������� getBoardList() �մϴ�.");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}
