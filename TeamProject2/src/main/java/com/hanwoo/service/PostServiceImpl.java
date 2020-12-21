package com.hanwoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hanwoo.domain.Post;
import com.hanwoo.persistence.PostRepository;

public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;

	public void insertPost(Post post) {
		postRepository.save(post);
	}

	public void deletePost(Post post) {
		postRepository.deleteById(post.getPOST_ID());
	}

	public void updatePost(Post post) {
		Post findPost = postRepository.findById(post.getPOST_ID()).get();
		findPost.setTITLE(post.getTITLE());
		findPost.setCONTENT(post.getCONTENT());
		findPost.setCATEGORY_ID(post.getCATEGORY_ID());
		postRepository.save(findPost);
	}

	public Post getPost(Post post) {
		return postRepository.findById(post.getPOST_ID()).get();
	}

	public List<Post> getPostList(Post post) {
		return (List<Post>) postRepository.findAll();
	}


	

}
