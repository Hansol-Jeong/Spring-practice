package com.hanwoo.service;

import java.util.List;

import com.hanwoo.domain.Post;

public interface PostService {
	void insertPost(Post post);
	void deletePost(Post post);
	void updatePost(Post post);
	Post getPost(Post post);
	List<Post> getPostList(Post post);
}
