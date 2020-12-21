package com.rubypaper.biz.user;

public interface UserDAO {

	void insertUser(UserVO vo);

	UserVO getUser(UserVO vo);

}
