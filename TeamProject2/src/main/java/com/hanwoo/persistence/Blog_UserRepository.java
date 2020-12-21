package com.hanwoo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.hanwoo.domain.Blog_User;

public interface Blog_UserRepository extends CrudRepository<Blog_User, String> {

}
