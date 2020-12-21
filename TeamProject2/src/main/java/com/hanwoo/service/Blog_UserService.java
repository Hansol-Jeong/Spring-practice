package com.hanwoo.service;

import java.util.List;

import com.hanwoo.domain.Blog_User;

public interface Blog_UserService {
	void insertBlog_User(Blog_User blog_User);
	void deleteBlog_User(Blog_User blog_User);
	void updateBlog_User(Blog_User blog_User);
	Blog_User getBlog_User(Blog_User blog_User);
	List<Blog_User> getBlog_UserList(Blog_User blog_User);
}
