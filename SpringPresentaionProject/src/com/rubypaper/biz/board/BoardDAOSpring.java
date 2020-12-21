package com.rubypaper.biz.board;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rubypaper.biz.common.JDBCUtil;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class BoardDAOSpring implements BoardDAO {
	@Autowired
	private JdbcTemplate spring;// 내가 만든게아니야. 직접 bean등록 해줘야돼
	// BOARD 테이블 관련 SQL 명령어
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE   = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
	
	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 insertBoard() 기능  처리");
		spring.update(BOARD_INSERT,vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 deleteBoard() 기능  처리");
		spring.update(BOARD_DELETE,vo.getSeq());
	}
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 updateBoard() 기능  처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	// 글 상세 조회
	/*public Map<String, Object> getBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoard() 기능  처리");
		Object[] args= {vo.getSeq()};
		return spring.queryForMap(BOARD_GET,args);
	}*/
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoard() 기능  처리");
		Object[] args= {vo.getSeq()};
		// queryforObject 메소드는 검색결과가 하나인 쿼리를 위한 메소드다.
		//만약 실행 결과가 두 건 이상이면 Exception발생
		return spring.queryForObject(BOARD_GET,args, new BoardRowMapper());//야 jdbc템플릿아 앞에 두개를 가지고 데이터를조회하면 데이터하나가 나올거잖아(rs에) 그럼 그 검색결과
		//를 RowMapper를 이용해서 매핑해
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoardList() 기능  처리");
		Object[] args= {vo.getSearchKeyword()};
		return spring.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
	}
}




