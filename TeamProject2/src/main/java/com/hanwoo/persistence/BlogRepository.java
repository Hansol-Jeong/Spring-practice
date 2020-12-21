package com.hanwoo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hanwoo.domain.Blog;
import com.hanwoo.domain.Blog_User;

public interface BlogRepository extends CrudRepository<Blog, Long>{

}
