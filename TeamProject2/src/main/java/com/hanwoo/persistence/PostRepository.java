package com.hanwoo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hanwoo.domain.Blog_User;
import com.hanwoo.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long>{

}
