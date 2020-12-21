package sol.com.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import sol.com.domain.Blog;
import sol.com.domain.Blog_User;
import sol.com.domain.Category;
import sol.com.domain.Comment;
import sol.com.domain.Post;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;
import sol.com.service.CategoryService;
import sol.com.service.CommentService;
import sol.com.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest3 extends LoginController {
	@Autowired
	private Blog_UserService blog_UserService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postservice;
	@Autowired
	private CommentService commentService;
	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void test() {
		Blog_User blog_User = new Blog_User();
		blog_User.setUserId("admin");
		blog_User.setUserPassword(encoder.encode("admin"));
		blog_User.setRole("ROLE_ADMIN");
		blog_User.setName("GillDong");
		blog_UserService.insertBlog_User(blog_User);
		

		Blog blog = new Blog();
		blog.setBlogTitle("@KKaMo@");
		blog.setBlogTag("강아지, 힐링, 보스턴테리어");
		blog.setBlogDisplayCount(20L);
		blog.setBlogFileName("kkamo");
		blog.setStatus("delete requested");
		blog.setBlog_User(blog_User);
		blogService.insertBlog(blog);
		
		Category category = new Category();
		category.setBlog(blog);
		category.setCategoryName("travel");
		category.setCategoryDescription("Stories of travel");
		category.setCategoryDisplayType("Title");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("study");
		category.setCategoryDescription("My daily study");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("dog");
		category.setCategoryDescription("Lovely dog");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(20L);
		categoryService.insertCategory(category);
		
		Post post = new Post();
		post.setTitle("Look what he's doing lol");
		post.setContent("He's getting inside my blanket he seems like cold!");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		post = new Post();
		post.setTitle("My dog speak, it's real");
		post.setContent("Truly, my dog speaked yesterday, and he said \"I love you\". I know that you can't believe but it's ture!");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		
		Comment comment = new Comment();
		comment.setContent("real kk");
		comment.setPost(post);
		comment.setName("Soviet Girl");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		comment = new Comment();
		comment.setContent("creals zz");
		comment.setPost(post);
		comment.setName("Serial");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		
		blog_User = new Blog_User();
		blog_User.setUserId("user1");
		blog_User.setUserPassword(encoder.encode("user1"));
		blog_User.setRole("ROLE_USER");
		blog_User.setName("Stich");
		blog_UserService.insertBlog_User(blog_User);
		
		blog = new Blog();
		blog.setBlogTitle("???@()@*#*#!@#!!");
		blog.setBlogTag("@#!, 1@#!, 123@!$");
		blog.setBlogDisplayCount(20L);
		blog.setBlogFileName("sti");
		blog.setStatus("");
		blog.setBlog_User(blog_User);
		blogService.insertBlog(blog);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("# RR#@V");
		category.setCategoryDescription("VR#@VRHRH%NN!!!!!");
		category.setCategoryDisplayType("Title");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("B#RRB");
		category.setCategoryDescription("Q#R#!NN");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(20L);
		categoryService.insertCategory(category);
		
		post = new Post();
		post.setTitle("QRBV#@B");
		post.setContent("R@# N#V@RN##NRM@$#R@#@NHBR@#M@@@!!!? #R!????");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		comment = new Comment();
		comment.setContent("マジやばくね?");
		comment.setPost(post);
		comment.setName("Dangerous");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		comment = new Comment();
		comment.setContent("What?");
		comment.setPost(post);
		comment.setName("extra1");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		blog_User = new Blog_User();
		blog_User.setUserId("user2");
		blog_User.setUserPassword(encoder.encode("user2"));
		blog_User.setRole("ROLE_USER");
		blog_User.setName("Dulli");
		blog_UserService.insertBlog_User(blog_User);
		
		blog = new Blog();
		blog.setBlogTitle("Crazy Dino");
		blog.setBlogTag("길동이, 또치, 마이콜");
		blog.setBlogDisplayCount(20L);
		blog.setBlogFileName("dulli");
		blog.setStatus("delete requested");
		blog.setBlog_User(blog_User);
		blogService.insertBlog(blog);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("gilldong");
		category.setCategoryDescription("dailly bullying GillDong");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		post = new Post();
		post.setTitle("How to harass him today");
		post.setContent("Behave well Gilldong!");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		comment = new Comment();
		comment.setContent("No Jam");
		comment.setPost(post);
		comment.setName("GillDong");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		comment = new Comment();
		comment.setContent("What the");
		comment.setPost(post);
		comment.setName("Michael");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("life of 4 cut");
		category.setCategoryDescription("life of 4 cut");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
//		blogService.deleteBlog(blog);
	}

}
