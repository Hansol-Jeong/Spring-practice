package sol.com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sol.com.domain.Blog_User;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;

@SpringBootTest
class TeamProject3ApplicationTests {
	@Autowired
	Blog_UserService blog_UserService;
	
	@Test
	void contextLoads() {
		Blog_User blog_User = new Blog_User();
		blog_User.setId("admin");
		blog_User.setPassword("admin");
		blog_User.setName("관리자");
		blog_User.setRole("관리자");
		blog_UserService.insertBlog_User(blog_User);
		
	}

}
