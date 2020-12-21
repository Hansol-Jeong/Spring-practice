package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rubypaper.biz.common.JDBCUtil;

public class BoardDAO {
	//JDBC 관련 변수 선언
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	//BOARD 테이블 관련 SQL 명령어
	private static final String INSERT_BOARD = "insert into board(seq, title, writer, content)" 
	+ "values((select nvl(max(seq),0) + 1 from board), ?, ?, ?)";
	private static final String DELETE_BOARD = "delete board where seq = ?";
	private static final String UPDATE_BOARD = "update board set title = ?, content = ? where seq = ?";
	private static final String GET_BOARD_LIST = "select * from board order by seq desc";
	private static final String GET_BOARD = "select * from board where seq = ?";
	private static final String BOARD_LIST_TITLE = "select * from Board where title like '%' ||?|| '%' Order by seq desc";
	private static final String BOARD_LIST_CONTENT = "select * from Board where content like '%' ||?|| '%' Order by seq desc";
	// BOARD테이블 관련 CRUD 기능의 메소드
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(INSERT_BOARD);//순서, 제목, 작성자, 내용
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		try { 
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_BOARD);
			
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public void updateBoard(BoardVO vo) {// 제목, 내용, 번호
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_BOARD);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public List<BoardVO> getBoardList(BoardVO vo) {// select계열은 결과를 클라이언트가 결정할수 있도록 해야지 얘가 자료형을 결정하도록 하면 안된다
		System.out.println(vo.toString());
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_TITLE);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			}
			stmt.setNString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				//검색 결과 한 ROW당 하나의 BoardVO 객체에 매핑한다.
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				//검색 결과가 매핑된 BoardVO 객체를 리스트 컬렉션에 등록한다.
				boardList.add(board);
				System.out.println(rs.getInt("SEQ") + " : " + rs.getString("CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		//검색 결과가 저장된 리스트 컬렉션을 클라이언트로 리턴한다
		return boardList;
	}
}
