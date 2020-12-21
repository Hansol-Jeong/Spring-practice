package sol.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import sol.com.domain.Blog;
import sol.com.domain.Blog_User;
import sol.com.persistence.BlogRepo;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;
@Controller
public class HomeController {
	@Autowired
	private Blog_UserService blog_UserService;// impl가져오겠지
	private BlogService blogService;

	@GetMapping("/")//초기 화면
	public String home() {
		return "blogsystem_search";
	}

	@GetMapping("/login.do")//로그인 뷰
	public String loginVIew() {
		System.out.println("로그인 화면으로 슝");
		return "login";
	}

	@PostMapping("/login.do")//로그인
	public String login(Blog_User blog_User, HttpSession session) {
		System.out.println("로그인 기능 처리중>>>");
		System.out.println(blog_User);
		Blog_User findBlog_User = blog_UserService.getBlog_User(blog_User);
		System.out.println(findBlog_User);
		if (findBlog_User != null) {
			session.setAttribute("blog_User", findBlog_User);// 세션ㅇ에 blog_User-blog_User 등록
			System.out.println("blogsystem_search로 화면 이동중");
			return "blogsystem_search";
		}

		else {
			System.out.println("다시 돌아오는중");
			return "login";
		}
	}
	@GetMapping("/logout.do")//로그아웃
	public String logout(HttpSession session) {
		session.invalidate();
		return "blogsystem_search";
	}
	@GetMapping("/blogcreate.do")//블로그 생성
	public String blogcreate(HttpSession session) {
		if(session.getAttribute("blog_User")!=null)
		return "blogcreate";
		else return "login";
	}
	@GetMapping("/blogadmin_basic.do")//내블로그 보기
	public String blogadmin_basic(HttpSession session) {
		if(session.getAttribute("blog_User") != null) {
			return "blogadmin_basic";
		}
		else 
			return "login";
	}
//	@RequestMapping("/blogsystem_search.do")
//	public String blogsystem_search(Blog blog, Model model) {//modelandview랑 똑같지만 데이터만 저장할 수 있다. modelandview는 객체 그래서 스트링타입으로 반환 못받아서 model써
//		// null check
//		if (blog.getSearchCondition() == null)
//			blog.setSearchCondition("TITLE");
//		if (blog.getSearchKeyword() == null)
//			blog.setSearchKeyword("");
////절대 검색결과는 세션에 등록하면 안된다. 검색결과는 request에 등록해야 한다.
//		//ModelAndView나 Model객체에 검색결과를 등록하면 자동으로 세션이 아닌 request에 등록해준다.
////		session.setAttribute("boardList", boardDAO.getBoardList(vo));
////		session.setAttribute("search", vo);
//		model.addAttribute("blogList", blogService.getBlogList(blog)); //model정보
//		model.addAttribute("search", blog);// model정보
//		return "getBoardList";//view리턴
//	}
	
}
