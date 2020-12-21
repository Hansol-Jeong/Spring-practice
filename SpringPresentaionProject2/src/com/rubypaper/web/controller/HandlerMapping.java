package com.rubypaper.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.rubypaper.web.controller.board.DeleteBoardController;
import com.rubypaper.web.controller.board.GetBoardController;
import com.rubypaper.web.controller.board.GetBoardListController;
import com.rubypaper.web.controller.board.InsertBoardController;
import com.rubypaper.web.controller.board.LogoutController;
import com.rubypaper.web.controller.board.UpdateBoardController;
import com.rubypaper.web.controller.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	
	
	public HandlerMapping() {
		//��� ��Ʈ�ѷ� ��ü�� Map�� ����Ѵ�
		mappings = new HashMap<String, Controller>();
		//USER���� ��Ʈ�ѷ� ���
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		
		//BOARD���� ��Ʈ�ѷ� ���
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
	}



	public Controller getController(String path) {
		//�Ű������� ���� path�� �ش��ϴ� ��Ʈ�ѷ� ��ü�� �˻��Ͽ� �����Ѵ�.
		return mappings.get(path);
	}

}
