package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.user.UserService#insertUser(com.rubypaper.biz.user.UserVO)
	 */
	@Override
	public void insertUser(UserVO vo) {
			userDAO.insertUser(vo);
	}
	
	/* (non-Javadoc)
	 * @see com.rubypaper.biz.user.UserService#getUser(com.rubypaper.biz.user.UserVO)
	 */
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	

}
