package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.rubypaper.biz.util.SqlSessionFactoryBean;

// 2. DAO(Data Access Object) Ŭ����
public class BoardDAOMyBATIS {
	// SqlSession�� MyBatis �����ӿ�ũ ��ü��. Mybatis�� ���������� �����̳ʸ� ����Ѵ�.
	// ���� SqlSession ��ü�� MyBatis �����̳ʴ�.
	private SqlSession mybatis;
	
	public BoardDAOMyBATIS() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� insertBoard() ���  ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
	}
	
	public void insertBoardMap(Map<String, Object> vo) {
		System.out.println("===> MyBATIS ������� insertBoard() ���  ó��");
		mybatis.insert("BoardDAO.insertBoardMap", vo);
		mybatis.commit();
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� updateBoard() ���  ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� deleteBoard() ���  ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoard() ���  ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardList() ���  ó��");
		return mybatis.selectList("BoardDAO.getBoardList");
	}
	
	// �� ��� �˻�
	public List<Map<String, Object>> getBoardListMap(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getBoardListMap() ���  ó��");
		return mybatis.selectList("BoardDAO.getBoardListMap");
	}
	// �Խñ� �� �˻�
	public int getTotalCount(BoardVO vo) {
		System.out.println("===> MyBATIS ������� getTotalCount() ���  ó��");
		return (int) mybatis.selectOne("BoardDAO.getBoardTotalCount");
	}
}




