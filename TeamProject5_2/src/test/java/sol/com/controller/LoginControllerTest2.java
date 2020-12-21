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
public class LoginControllerTest2 extends LoginController {
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
		blog_User.setName("gilldong");
		blog_UserService.insertBlog_User(blog_User);
		

		Blog blog = new Blog();
		blog.setBlogTitle("gilldong");
		blog.setBlogTag("gilldong");
		blog.setBlogTag("gilldong2");
		blog.setBlogDisplayCount(20L);
		blog.setBlogFileName("gilldong");
		blog.setStatus("delete requested");
		blog.setBlog_User(blog_User);
		blogService.insertBlog(blog);
		
		Category category = new Category();
		category.setBlog(blog);
		category.setCategoryName("Java");
		category.setCategoryDescription("explaining>>>");
		category.setCategoryDisplayType("Title");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("React");
		category.setCategoryDescription("explaining>>>");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(10L);
		categoryService.insertCategory(category);
		
		category = new Category();
		category.setBlog(blog);
		category.setCategoryName("Vue");
		category.setCategoryDescription("explaining>>>");
		category.setCategoryDisplayType("Text");
		category.setCategoryDisplayCount(20L);
		categoryService.insertCategory(category);
		
		Post post = new Post();
		post.setTitle("testing post1");
		post.setContent("now testing post1>>>");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		post = new Post();
		post.setTitle("testing post2");
		post.setContent("now testing post2>>>");
		post.setCategory(category);
		post.setRegiDate(new Date());
		postservice.insertPost(post);
		
		
		Comment comment = new Comment();
		comment.setContent("this is new commnet");
		comment.setPost(post);
		comment.setName("colaGuy");
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		
		

		blog_User = new Blog_User();
		blog_User.setUserId("user1");
		blog_User.setUserPassword(encoder.encode("user1"));
		blog_User.setRole("ROLE_USER");
		blog_User.setName("dulli");
		blog_UserService.insertBlog_User(blog_User);
		
		Category findCategory = categoryService.findByName("Java");
		categoryService.deleteCategory(findCategory);
		
		
		
	}

}
