package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO(Data Access Object) 클래스
public class BoardDAOMyBATIS implements BoardDAO{
	@Autowired
	private SqlSessionTemplate mybatis;//
	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 insertBoard() 기능  처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
//		mybatis.commit(); 비지니스메소드에서 트렌젝션 자동으로 관리해준다
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 updateBoard() 기능  처리");
		mybatis.update("BoardDAO.updateBoard", vo);
//		mybatis.commit();
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 deleteBoard() 기능  처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
//		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoard() 기능  처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBATIS 기반으로 getBoardList() 기능  처리");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}

}




