package com.hanwoo.service;

import java.util.List;

import com.hanwoo.domain.Blog;

public interface BlogService {
	void insertBlog(Blog blog);
	void deleteBlog(Blog blog);
	void updateBlog(Blog blog);
	Blog getBlog(Blog blog);
	List<Blog> getBlogList();
}
