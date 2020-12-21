package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubypaper.biz.util.SqlSessionFactoryBean;

public class BoardDAOMyBATIS {	
	//sqlsession이 mybatis프레임워크 객체다. mybatis도 내부적으로 컨테이너를 운용한다.
	//따라서sqlsession객체는 mybatis컨테이너다
	private SqlSession mybatis;//지금은 인터페이스야
	public BoardDAOMyBATIS() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();//sql세션 객체하나가 튀어나온다.
	}

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 insertBoard() 기능  처리");
		mybatis.insert("BoardDAO.insertBoard", vo);//id가 insertBoard인 sql을 실행해 파라미터로 BoardVO객체 넘겨줄게
		mybatis.commit();
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 updateBoard() 기능  처리");
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 deleteBoard() 기능  처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 getBoard() 기능  처리");
		
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);//리턴타입 object
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis 기반으로 getBoardList() 기능  처리");
		
		return mybatis.selectList("BoardDAO.getBoardList");
	}
}




