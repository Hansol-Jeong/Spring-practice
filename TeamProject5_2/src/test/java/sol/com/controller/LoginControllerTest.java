package sol.com.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sol.com.domain.Blog;
import sol.com.domain.Blog_User;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
	@Autowired
	private Blog_UserService blog_UserService;
	@Autowired
	private BlogService blogService;

//	@Test
	void test() {
		Blog_User blog_User = new Blog_User();
		blog_User.setUserId("admin");
		blog_User.setUserPassword("admin");
		blog_User.setRole("admin");
		blog_User.setName("gilldong");
		blog_UserService.insertBlog_User(blog_User);

		Blog blog = new Blog();
		blog.setBlogTitle("gilldong");
		blog.getBlogTag().add("gilldong");
		blog.setBlogDisplayCount(20L);
		blog.setBlogFileName("gilldong");
		blog.setStatus("delete requested");
		blog.setBlog_User(blog_User);
		blogService.insertBlog(blog);

		blog_User = new Blog_User();
		blog_User.setUserId("user1");
		blog_User.setUserPassword("user1");
		blog_User.setRole("user");
		blog_User.setName("dulli");
		blog_UserService.insertBlog_User(blog_User);
	}

	@Test
	void test1() {
		System.out.println("테스팅");
	}

//	@Test
	void test2() {
		System.out.println(blogService.findByBlogTitle("gilldong"));
	}

//	@Test
	void test3() {
		System.out.println(blog_UserService.findByName("gilldong"));
	}

//	@Test
	void test4() {
		Blog_User blog_User = new Blog_User();
		blog_User = blog_UserService.findByName("gilldong");
		System.out.println(blog_User.getBlogList());
	}
}
