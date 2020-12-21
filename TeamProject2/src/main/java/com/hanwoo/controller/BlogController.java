package com.hanwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hanwoo.persistence.BlogRepository;
import com.hanwoo.persistence.Blog_UserRepository;
import com.hanwoo.persistence.CategoryRepository;
import com.hanwoo.persistence.PostRepository;

public class BlogController {
@Autowired
private Blog_UserRepository blog_UserRepository;
private BlogRepository blogRepository;
private CategoryRepository categoryRepository;
private PostRepository postRepository;

//블로그들록, 내블로그 가는거, 검색
//@RequestMapping("/")


}
