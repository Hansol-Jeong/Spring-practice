package com.hanwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanwoo.domain.Blog_User;
import com.hanwoo.persistence.Blog_UserRepository;

@Service
public class Blog_UserServiceImpl implements Blog_UserService{
@Autowired
private Blog_UserRepository blog_UserRepository;

public void insertBlog_User(Blog_User blog_User) {
	blog_UserRepository.save(blog_User);
}

public void deleteBlog_User(Blog_User blog_User) {
	blog_UserRepository.deleteById(blog_User.getUser_id());
}

public void updateBlog_User(Blog_User blog_User) {
}

public Blog_User getBlog_User(Blog_User blog_User) {
	return blog_UserRepository.findById(blog_User.getUser_id()).get();
}

public List<Blog_User> getBlog_UserList(Blog_User blog_User) {
	return (List<Blog_User>) blog_UserRepository.findAll();
}

}
