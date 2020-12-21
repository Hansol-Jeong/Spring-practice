package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rubypaper.biz.common.JDBCUtil;

public class BoardDAO {// Board Data Access Object
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	private static final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
			+ "values((select nvl(max(seq),0) +" + "1 from board), ?, ?, ?)";
	private static final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private static final String BOARD_DELETE = "delete board where seq = ?";
	private static final String BOARD_GET = "select * from board where seq = ?";
	private static final String BOARD_LIST = "select * from board order by seq desc";
	private static final String BOARD_UPDATE_CNT = "update board set cnt = cnt +1 where seq = ?";

	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);

			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}

	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("SEQ"));
				vo.setCnt(rs.getInt("CNT"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setRegDate(rs.getDate("REGDATE"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriter(rs.getString("WRITER"));

				list.add(vo);
				System.out.println(rs.getInt("SEQ") + " : " + rs.getString("CONTENT"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
		return list;
	}

	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);

			stmt.setInt(1, vo.getSeq());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);

			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setCnt(rs.getInt("CNT"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setRegDate(rs.getDate("REGDATE"));
				vo.setSeq(rs.getInt("SEQ"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriter(rs.getString("WRITER"));

				System.out.println(vo.getSeq() + "번의 글의 조회수 :" + vo.getCnt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, conn, stmt);
		}
		return vo;
	}

}
