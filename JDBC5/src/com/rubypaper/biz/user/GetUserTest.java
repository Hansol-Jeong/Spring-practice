package com.rubypaper.biz.user;

public class GetUserTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();

		vo.setId("abcd");
		vo.setName("efgh");
		vo.setPassword("hijk");
		vo.setRole("asdfw");
		dao.insertUser(vo);

		UserVO user = dao.getUser(vo);
		if (user != null)
			System.out.println(user.getName() + "님 환영합니다!");
		else
			System.out.println(vo.getId() + "로그인 실패");
	}
}
