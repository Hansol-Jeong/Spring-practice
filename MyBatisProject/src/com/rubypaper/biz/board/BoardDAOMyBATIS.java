package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rubypaper.biz.util.SqlSessionFactoryBean;

public class BoardDAOMyBATIS {	
	//sqlsession�� mybatis�����ӿ�ũ ��ü��. mybatis�� ���������� �����̳ʸ� ����Ѵ�.
	//����sqlsession��ü�� mybatis�����̳ʴ�
	private SqlSession mybatis;//������ �������̽���
	public BoardDAOMyBATIS() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();//sql���� ��ü�ϳ��� Ƣ��´�.
	}

	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� insertBoard() ���  ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);//id�� insertBoard�� sql�� ������ �Ķ���ͷ� BoardVO��ü �Ѱ��ٰ�
		mybatis.commit();
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� updateBoard() ���  ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� deleteBoard() ���  ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis ������� getBoard() ���  ó��");
		
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);//����Ÿ�� object
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis ������� getBoardList() ���  ó��");
		
		return mybatis.selectList("BoardDAO.getBoardList");
	}
}




