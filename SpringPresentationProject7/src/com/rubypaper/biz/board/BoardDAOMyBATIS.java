package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO(Data Access Object) Ŭ����
public class BoardDAOMyBATIS implements BoardDAO{
	@Autowired
	private SqlSessionTemplate mybatis;//
	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� insertBoard() ���  ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);
//		mybatis.commit(); �����Ͻ��޼ҵ忡�� Ʈ������ �ڵ����� �������ش�
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� updateBoard() ���  ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
//		mybatis.commit();
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� deleteBoard() ���  ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
//		mybatis.commit();
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoard() ���  ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardList() ���  ó��");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}

}




