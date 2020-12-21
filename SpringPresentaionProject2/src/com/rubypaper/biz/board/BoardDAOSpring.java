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

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class BoardDAOSpring implements BoardDAO {
	@Autowired
	private JdbcTemplate spring;// ���� ����ԾƴϾ�. ���� bean��� ����ߵ�
	// BOARD ���̺� ���� SQL ��ɾ�
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE   = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
	
	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring ������� insertBoard() ���  ó��");
		spring.update(BOARD_INSERT,vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring ������� deleteBoard() ���  ó��");
		spring.update(BOARD_DELETE,vo.getSeq());
	}
	//�� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring ������� updateBoard() ���  ó��");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	// �� �� ��ȸ
	/*public Map<String, Object> getBoard(BoardVO vo) {
		System.out.println("===> Spring ������� getBoard() ���  ó��");
		Object[] args= {vo.getSeq()};
		return spring.queryForMap(BOARD_GET,args);
	}*/
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring ������� getBoard() ���  ó��");
		Object[] args= {vo.getSeq()};
		// queryforObject �޼ҵ�� �˻������ �ϳ��� ������ ���� �޼ҵ��.
		//���� ���� ����� �� �� �̻��̸� Exception�߻�
		return spring.queryForObject(BOARD_GET,args, new BoardRowMapper());//�� jdbc���ø��� �տ� �ΰ��� ������ �����͸���ȸ�ϸ� �������ϳ��� ���ð��ݾ�(rs��) �׷� �� �˻����
		//�� RowMapper�� �̿��ؼ� ������
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring ������� getBoardList() ���  ó��");
		Object[] args= {vo.getSearchKeyword()};
		return spring.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
	}
}




