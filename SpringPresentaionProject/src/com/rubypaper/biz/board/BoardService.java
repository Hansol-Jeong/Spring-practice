package com.rubypaper.biz.board;

import java.util.List;
import java.util.Map;

// 3. Service �������̽�
public interface BoardService {

	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ��ȸ
//	Map<String, Object> getBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);

	// �� ��� �˻�
	List<BoardVO> getBoardList(BoardVO vo);

}