package sol.com;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
class MemberTest {
	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private ContentRepo contentRepo;
	@Autowired
	private PostRepo postRepo;

	@Test
	void test1() { //ManyToOne
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPasword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepo.save(member1);
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPasword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		memberRepo.save(member2);
		
		for(int i = 1; i<=3; i++) {
			Content content = new Content();
			content.setMember(member1);
			content.setTitle("둘리가 등록한 게시글" + i);
			content.setContent("둘리가 등록한 게시글 내용" + i);
			content.setCreateDate(new Date());
			content.setCnt(0L);
			contentRepo.save(content);
			for(int j =1; j<=3; j++) {
				Post post = new Post();
				post.setTitle("포스트제목"+j);
				post.setTag("포스트 태그"+j);
//				post.setContent(content);
				postRepo.save(post);
			}
		
		}
//		memberRepo.save(member1);
		for(int i =1; i<=3; i++) {
			Content content = new Content();
			content.setMember(member2);
			content.setTitle("도우너가 등록한 게시글" + i);
			content.setContent("도우너가 등록한 게시글 내용" + i);
			content.setCreateDate(new Date());
			content.setCnt(0L);
			contentRepo.save(content);
			for(int j =1; j<=3; j++) {
				Post post = new Post();
				post.setTitle("포스트제목"+j);
				post.setTag("포스트 태그"+j);
//				post.setContent(content);
				postRepo.save(post);
			}
		
		}
//		memberRepo.findById("member1").get().getContentList().remove(0);
//		contentRepo.delete(contentRepo.findById(5L).get());
//		memberRepo.delete(memberRepo.findById("member1").get());
		

		
		
	}
//	@Test
	void test2() {
		Content content = contentRepo.findById(605L).get();
		System.out.println("[ " + content.getSeq() + "번 게시글 정보 ]");
		System.out.println("제목: " + content.getTitle());
		System.out.println("내용: " + content.getContent());
		System.out.println("작성자: " + content.getMember().getName());
		System.out.println("작성자 권한: " + content.getMember().getRole());
	}
//	@Test
	void test3() {
		Member member = memberRepo.findById("member1").get();
		System.out.println("======================");
		System.out.println(member+"가 저장한 게시 글 목록");
		System.out.println("======================");
		List<Content> contentList = member.getContentList();
		for(Content content: contentList) {
			System.out.println(content.toString());
		}
	}
//	@Test
	void test4() {
		Content contents = contentRepo.findById(605L).get();
		System.out.println(contents);
//		Post post = new Post();
//		post.setTitle("포스트 제목");
//		post.setTag("날 좀 바라봐");
//		post.setContent(content);
//		postRepo.save(post);
	}

}















