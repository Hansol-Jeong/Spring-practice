package sol.com.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlogTest {

	@Test
	void test() {
		Blog blog = new Blog();
		blog.setBlogTag("오리");
		blog.setBlogTag("매");
		blog.setBlogTag("개");
//		System.out.println(blog.blogTag);
		System.out.println(blog.getBlogTag());
	}

}
