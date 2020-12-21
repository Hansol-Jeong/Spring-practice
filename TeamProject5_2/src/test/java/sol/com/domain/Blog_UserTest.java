package sol.com.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sol.com.persistence.BlogRepo;
import sol.com.persistence.Blog_UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Blog_UserTest {
	@Autowired
	Blog_UserRepo blog_userRepo;
	@Autowired
	BlogRepo blogRepo;

	@Test
	public void test1() {
		Blog_User blog_User = new Blog_User();
		blog_User.setUserId("admin1");
		blog_User.setUserPassword("admin1");
		blog_User.setName("또치");
		blog_User.setRole("닭");
		blog_userRepo.save(blog_User);

		for (int i = 1; i < 5; i++) {
			Blog blog = new Blog();
			blog.setBlogDisplayCount(20L);
			blog.setBlogTag("오늘 식단");
//			blog.setBlogFileName("아진짜");
			blog.setBlogTitle("또치꺼" + i);
			blog.setBlog_User(blog_User);
			blogRepo.save(blog);
		}
//		
		blog_User = new Blog_User();
		blog_User.setUserId("admin2");
		blog_User.setUserPassword("admin2");
		blog_User.setName("둘리");
		blog_User.setRole("폐급");
		blog_userRepo.save(blog_User);

		for (int i = 1; i < 5; i++) {
			Blog blog = new Blog();
			blog.setBlogDisplayCount(20L);
			blog.setBlogTag("오늘 식단");
//			blog.setBlogFileName("아진짜");
			blog.setBlogTitle("둘리새끼" + i);
			blog.setBlog_User(blog_User);
			blogRepo.save(blog);
		}

		blog_User = new Blog_User();
		blog_User.setUserId("admin");
		blog_User.setUserPassword("admin");
		blog_User.setName("마이콜");
		blog_User.setRole("성인군자");
		blog_userRepo.save(blog_User);

		for (int i = 1; i < 5; i++) {
			Blog blog = new Blog();
			blog.setBlogDisplayCount(20L);
			blog.setBlogTag("오늘 식단");
//			blog.setBlogFileName("아진짜");
			blog.setBlogTitle("마이콜" + i);
			blog.setBlog_User(blog_User);
			blogRepo.save(blog);
		}
		Blog_User delete_target = blog_userRepo.findById("admin1").get();
		blog_userRepo.delete(delete_target);
		
		delete_target = blog_userRepo.findById("admin2").get();
		blog_userRepo.delete(delete_target);

//		Blog_User findTarget = blog_userRepo.findById("admin").get();
//		System.out.println("====================================");
//		System.out.println(findTarget.getBlogList().toString());
//		System.out.println("====================================");

		Blog delete_target2 = blogRepo.findById(11L).get();
		System.out.println("====================================");
		System.out.println(delete_target2.toString());
		System.out.println("====================================");
		blogRepo.deleteById(11L);

//		System.out.println();

	}

}
