package com.hanwoo.service;

import java.util.List;

import com.hanwoo.domain.Blog;
import com.hanwoo.domain.Blog_User;
import com.hanwoo.persistence.BlogRepository;

public class BlogServiceImpl implements BlogService {

	private BlogRepository blogRepository;
	public void insertBlog(Blog blog) {
		blogRepository.save(blog);
	}

	public void deleteBlog(Blog blog) {
		blogRepository.deleteById(blog.getBlog_id());
	}

	public void updateBlog(Blog blog) {
		Blog findBlog = blogRepository.findById(blog.getBlog_id()).get();
		findBlog.setTitle(blog.getTitle());
		findBlog.setTag(blog.getTag());
		findBlog.setStatus(blog.getStatus());
		blogRepository.save(findBlog);
	}

	public Blog getBlog(Blog blog) {
		return blogRepository.findById(blog.getBlog_id()).get();
	}

	public List<Blog> getBlogList() {
		return (List<Blog>) blogRepository.findAll();
	}

}
