package sol.com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sol.com.domain.Blog;
import sol.com.domain.Blog_User;
import sol.com.domain.Category;
import sol.com.domain.Comment;
import sol.com.domain.Post;
import sol.com.persistence.Blog_UserRepo;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;
import sol.com.service.CategoryService;
import sol.com.service.CommentService;
import sol.com.service.PostService;

@Controller
public class LoginController{
	@Autowired
	private Blog_UserService blog_UserService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/")
	public String welcomeView(Blog blog, Model model, HttpSession session) {// searchKeyword랑 searchCondition받은상태
		if (blog.getSearchKeyword() == null)
			blog.setSearchKeyword("");
		if (blog.getSearchCondition() == null)
			blog.setSearchCondition("TITLE");

		if (blog.getSearchCondition().equals("TITLE")) {
			System.out.println("Title로 검색중입니다...!");
			if (blog.getSearchKeyword() != "")
				model.addAttribute("blogList", blogService.findByBlogTitle(blog.getSearchKeyword()));
			else
				model.addAttribute("blogList", blogService.findAll());
		}
		if (blog.getSearchCondition().equals("BLOGGER")) {
			System.out.println("BLOGGER로 검색중입니다...!");
			if (blog.getSearchKeyword() != "") {
				Blog_User blog_User = blog_UserService.findByName(blog.getSearchKeyword());
				if (blog_User == null) {
					model.addAttribute("blogList", null);
				} else {
					List<Blog> blogList = blog_User.getBlogList();
					model.addAttribute("blogList", blogList);
				}
			} else
				model.addAttribute("blogList", blogService.findAll());
		}
		if (blog.getSearchCondition().equals("TAG")) {
			System.out.println("TAG로 검색중입니다...!");
			if (blog.getSearchKeyword() != "") {
				List<Blog> blogList = blogService.findByTag(blog.getSearchKeyword());
				model.addAttribute("blogList", blogList);
			} else
				model.addAttribute("blogList", blogService.findAll());
		}

		return "blogsystem_search";
	}

	@RequestMapping("/login")
	public String loginView() {
		if (request.getUserPrincipal() != null)
			return "redirect:blogsystem_search.do";
		return "login";
	}

	@GetMapping("/blogsystem_search.do")
	public String blogsystem_search(Blog blog, Model model, HttpSession session, Principal principal) throws NullPointerException
	{// searchKeyword랑 searchCondition받은상태
		if (blog.getSearchKeyword() == null)
			blog.setSearchKeyword("");
		if (blog.getSearchCondition() == null)
			blog.setSearchCondition("TITLE");

		if (blog.getSearchCondition().equals("TITLE")) {
			System.out.println("Title로 검색중입니다...!");
			if (blog.getSearchKeyword() != "")
				model.addAttribute("blogList", blogService.findByBlogTitle(blog.getSearchKeyword()));
			else
				model.addAttribute("blogList", blogService.findAll());
		}
		if (blog.getSearchCondition().equals("BLOGGER")) {
			System.out.println("BLOGGER로 검색중입니다...!");
			if (blog.getSearchKeyword() != "") {
				Blog_User blog_User = blog_UserService.findByName(blog.getSearchKeyword());
				if (blog_User == null) {
					model.addAttribute("blogList", null);
				} else {
					List<Blog> blogList = blog_User.getBlogList();
					model.addAttribute("blogList", blogList);
				}
			} else
				model.addAttribute("blogList", blogService.findAll());
		}
		if (blog.getSearchCondition().equals("TAG")) {
			System.out.println("TAG로 검색중입니다...!");
			if (blog.getSearchKeyword() != "") {
				List<Blog> blogList = blogService.findByTag(blog.getSearchKeyword());
				model.addAttribute("blogList", blogList);
			} else
				model.addAttribute("blogList", blogService.findAll());
		}
		session.setAttribute("previousPage", "blogsystem_seach");
		
		 try { model.addAttribute("loginUser", blog_UserService.findByuserId(principal.getName()).getUserId());}
		 catch (NullPointerException e) {
			e.printStackTrace();
		}
		  try {Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
	      model.addAttribute("blogUser", blog_User.getUserId());
		  }catch (NullPointerException e) {
			e.printStackTrace();
		}
		return "blogsystem_search";
	}

	@GetMapping("/category.do")
	public String category(Category category, HttpSession session, Model model, Principal principal) {
		System.out.println("=======!=======" + category + "==========!==========");
		System.out.println(category.getBlog());
		category = categoryService.findByName(category.getCategoryName());
		
		Blog blog = category.getBlog();
		List<Category> categoryList = blog.getCategoryList();
		System.out.println("==============" + categoryList + "====================");
		System.out.println("===!====!==!=====" + category.getCategoryName() + "===!======!========!===");
		for (Category targetCategory : categoryList) {
			if (targetCategory.getCategoryName().equals(category.getCategoryName())) {
				category = targetCategory;
				break;
			}
		}
		System.out.println("=========!=====" + category + "==========!==========");
		List<Post> postList = category.getPostList();
		for (Post post : postList) {
			System.out.println(post.getTitle());
		}

		model.addAttribute("postList", postList);
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("blog", blog);
		List<String> tags = blog.getBlogTag();
		List<String> onlyThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (i == tags.size())
				break;
			onlyThree.add(tags.get(i));
		}
		model.addAttribute("tagList", onlyThree);

//		@GetMapping("/"+category.getCategoryName()+".do")
//		public String categoryPage() {
//			
//		}
		return "blogmain_detail";
	}

	@GetMapping("/blogcreate.do")
	public String blogcreate(Principal principal, Model model) {
		System.out.println(principal.getName());
		if (principal.getName() != null) {
			if (blog_UserService.findByuserId(principal.getName()).getBlogList().size() > 0) {
				model.addAttribute("msg", "이미 생성된 블로그가 있습니다.\\n해당 블로그로 이동합니다.");
				model.addAttribute("url", "/blogmain_detail.do");
				return "redirect";
			}
		}
		return "blogcreate";
	}

	@PostMapping("/addBlog.do")
	public String addBlog(Blog blog, HttpSession session, Model model, Principal principal) {
		if (blog.getBlogTitle() == "") {
			model.addAttribute("msg", "블로그 제목을 입력해주세요.");
			model.addAttribute("url", "/blogcreate.do");
			return "redirect";
		} else if (blogService.findByBlogCorrectly(blog.getBlogTitle()) != null) {
			model.addAttribute("msg", "이미 해당 제목으로 블로그가 존재합니다.");
			model.addAttribute("url", "/blogcreate.do");
			return "redirect";
		} else if (blog.getBlogTitle().length() > 15) {
			model.addAttribute("msg", "입력하신 블로그 제목의 길이가 깁니다.\\n15글자 이내로 입력해주세요.");
			model.addAttribute("url", "/blogcreate.do");
			return "redirect";
		} else {
			Blog newBlog = new Blog();
			Blog_User findUser = blog_UserService.findByuserId(principal.getName());
			newBlog.setBlogTitle(blog.getBlogTitle());
			newBlog.setBlog_User(findUser);
			newBlog.setBlogDisplayCount(0L);
			newBlog.setBlogTag("");
			blogService.insertBlog(newBlog);
			model.addAttribute("msg", "블로그가 생성되었습니다.");
			model.addAttribute("url", "/blogmain_detail.do");
			return "redirect";
		}
	}

	@GetMapping("/addComment.do")
	public String addComment(Comment comment, Model model, HttpSession session) {// 이름이랑 컨텐츠
		System.out.println("=========!!======" + comment + "=========!!=========");
		Post post = (Post) session.getAttribute("clikedPost");
		comment.setPost(post);
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
		return "blogmain_detail";
	}

	@GetMapping("/blogmain_detail.do")
	public String blogmain_detail(Post clikedPost, Model model, HttpSession session, Principal principal) {
		if(blog_UserService.findByuserId(principal.getName()).getBlogList().size()==0) {
			model.addAttribute("msg", "내블로그가 없어요! 만들러가볼까요?");
			model.addAttribute("url", "/blogcreate.do");
			return "redirect";
		}
		System.out.println("==============" + "blogmain_detail진행중" + "===================");
		Blog_User blog_user = blog_UserService.findByuserId(principal.getName());
		if (blog_user.getBlogList().size() == 0) {
			System.out.println("존재하는 블로그가 없습니다!");
			return "redirect:blogsystem_search.do";
		} else {
			model.addAttribute("clikedPost", clikedPost);
			if (clikedPost.getPostId() == null) {
				model.addAttribute("blog_User", blog_user);
				Blog blog = blog_user.getBlogList().get(0);

				List<Category> categoryList = blog.getCategoryList();
				for (Category category : categoryList) {
					for (Post post : category.getPostList()) {
						System.out.println(post.getTitle());
					}
				}
				List<Post> postList = new ArrayList<>();
				System.out.println(categoryList);
				for (Category category : categoryList) {
					postList.addAll(category.getPostList());
				}
				model.addAttribute("postList", postList);
				model.addAttribute("categoryList", categoryList);
				model.addAttribute("blog", blog);

				List<String> tags = blog.getBlogTag();
				List<String> onlyThree = new ArrayList<>();
				for (int i = 0; i < 3; i++) {
					if (i == tags.size())
						break;
					onlyThree.add(tags.get(i));
				}

				model.addAttribute("tagList", onlyThree);
				return "blogmain_detail";
			} else {
				clikedPost = postService.findById(clikedPost.getPostId());
				Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
				Blog blog = blog_User.getBlogList().get(0);
				List<Category> categoryList = blog.getCategoryList();

				model.addAttribute("clikedPost", clikedPost);
				model.addAttribute("blog_User", blog_User);
				model.addAttribute("blog", blog);
				model.addAttribute("categoryList", categoryList);
				model.addAttribute("postList", clikedPost);
				System.out.println("==============" + "실행은 됫는데" + "===================");

				session.setAttribute("clikedPost", clikedPost);

				return "blogmain_detail";
			}
		}

	}

	@GetMapping("/blogmain_detail2.do")
	public String blogmain_detail2(Post clikedPost, Model model, HttpSession session, Blog_User blog_User,
			Principal principal) {
		System.out.println(blog_User);
		
		blog_User = blog_UserService.findByuserId(blog_User.getUserId());

		model.addAttribute("blog_User", blog_User);
		Blog blog = blog_User.getBlogList().get(0);

		List<Category> categoryList = blog.getCategoryList();
		for (Category category : categoryList) {
			for (Post post : category.getPostList()) {
				System.out.println(post.getTitle());
			}
		}
		List<Post> postList = new ArrayList<>();
		System.out.println("======================"+categoryList+"===========================");
		for (Category category : categoryList) {
			postList.addAll(category.getPostList());
		}
		System.out.println("======================"+postList+"===========================");
		model.addAttribute("postList", postList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("blog", blog);
		try {
		model.addAttribute("loginUser", blog_UserService.findByuserId(principal.getName()).getUserId());
		} catch (NullPointerException e) {
			model.addAttribute("loginUser", "none");
		}
		model.addAttribute("blogUser", blog_User.getUserId());

		List<String> tags = blog.getBlogTag();
		List<String> onlyThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (i == tags.size())
				break;
			onlyThree.add(tags.get(i));
		}

		model.addAttribute("tagList", onlyThree);
		return "blogmain_detail";

	}

	@RequestMapping("/blogadmin_basic.do") 
	public String blogadmin_basic(Principal principal, Model model, Blog new_blog) throws NullPointerException{
		if(blog_UserService.findByuserId(principal.getName()).getBlogList().size()==0) {
			model.addAttribute("msg", "내블로그가 없어서 시스템을 관리할 수가 없어요! 만들러가볼까요?");
			model.addAttribute("url", "/blogcreate.do");
			return "redirect";
		}
		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		Blog blog = blog_User.getBlogList().get(0);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + blog_User + "!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + blog + "!!!!!!!!!!!!!!!!!!!!");

		List<String> tags = blog.getBlogTag();
		List<String> onlyThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (i == tags.size())
				break;
			onlyThree.add(tags.get(i));
		}
		model.addAttribute("blog_User", blog_User);
		model.addAttribute("blog", blog);
		model.addAttribute("tagList", onlyThree);

		return "blogadmin_basic";
	}

	@RequestMapping("/updateBlog.do")
	public String updateBlog(Principal principal, Model model, Blog new_blog) {
		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		Blog old_blog = blog_User.getBlogList().get(0);
		System.out.println(old_blog);
		System.out.println(new_blog);

		Long old_blog_id = old_blog.getBlogId();
		String old_status = old_blog.getStatus();
		List<Category> old_categoryList = old_blog.getCategoryList();

		new_blog.setBlogId(old_blog_id);
		new_blog.setStatus(old_status);
		new_blog.setCategoryList(old_categoryList);
		new_blog.setBlog_User(blog_User);

		System.out.println(new_blog);

		blogService.insertBlog(new_blog); // 업데이트로되겟지?
		return "redirect:blogmain_detail.do";
	}

	@RequestMapping("/blogadmin_category.do")
	public String blogadmin_category(Principal principal, Model model) {

		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		Blog blog = blog_User.getBlogList().get(0);

		List<String> tags = blog.getBlogTag();
		List<String> onlyThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (i == tags.size())
				break;
			onlyThree.add(tags.get(i));
		}
		List<Category> categoryList = blog.getCategoryList();

		model.addAttribute("blog_User", blog_User);
		model.addAttribute("blog", blog);
		model.addAttribute("tagList", onlyThree);
		model.addAttribute("categoryList", categoryList);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + categoryList + "!!!!!!!!!!!!!!!!!!!!");

		return "blogadmin_category";
	}

	@RequestMapping("/updateCategory.do")
	public String updateCategory(Principal principal, Category new_category) {
		System.out.println("========!=======!====="+new_category+"=======!=======!=========");
		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		System.out.println("===================="+blog_User+"=======================");
		Blog blog = blog_User.getBlogList().get(0);
		System.out.println("===================="+blog+"=======================");
		Category old_Category = null;
		List<Category> categoryList = blog.getCategoryList();
		System.out.println("===================="+categoryList+"=======================");
		for (Category targetCategory : categoryList) {
			if (targetCategory.getCategoryName().equals(new_category.getCategoryName())) {
				old_Category = targetCategory;
				break;
			}
		}
		System.out.println("===================="+old_Category+"=======================");
		old_Category.setCategoryDisplayType(new_category.getCategoryDisplayType());
		old_Category.setCategoryDisplayCount(new_category.getCategoryDisplayCount());
		old_Category.setCategoryDescription(new_category.getCategoryDescription());
		categoryService.insertCategory(old_Category);

		return "redirect:blogadmin_category.do";
	}

	@RequestMapping("/addCategory.do")
	public String addCategory(Principal principal, Category new_category) {
		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		Blog blog = blog_User.getBlogList().get(0);

		new_category.setBlog(blog);
		categoryService.insertCategory(new_category);

		return "redirect:blogadmin_category.do";
	}

	@RequestMapping("/blogadmin_write.do")
	public String blogadmin_write(Principal principal, Model model, Blog new_Blog) {

		Blog_User blog_User = blog_UserService.findByuserId(principal.getName());
		Blog blog = blog_User.getBlogList().get(0);

		List<String> tags = blog.getBlogTag();
		List<String> onlyThree = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (i == tags.size())
				break;
			onlyThree.add(tags.get(i));
		}
		List<Category> categoryList = blog.getCategoryList();

		model.addAttribute("blog_User", blog_User);
		model.addAttribute("blog", blog);
		model.addAttribute("tagList", onlyThree);
		model.addAttribute("categoryList", categoryList);

		return "blogadmin_write";
	}

	@PostMapping("/addPost.do")
	public String addPost(Principal principal, Model model, Post post, Category category) {
		Category findCategory = categoryService.findByName(category.getCategoryName());
		post.setRegiDate(new Date());
		post.setCategory(findCategory);
		postService.insertPost(post);
		return "redirect:blogmain_detail.do";
	}

	@RequestMapping("/blogadmin_request_remove.do")
	public String blogadmin_request_remove(Principal principal, Model model) {

		return "blogadmin_request_remove";
	}
	
	@RequestMapping("/createUser.do")
	public String createUser() {
		return "createUser";
	}
	
	@RequestMapping("/createdUser.do")
	public String createdUser(Blog_User blog_User, Model model) {
		if(blog_UserService.findByuserId(blog_User.getUserId()) == null) {
		blog_User.setRole("ROLE_USER");
		System.out.println(blog_User);
		blog_User.setUserPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(blog_User.getUserPassword()));
		blog_UserService.insertBlog_User(blog_User);
		String msg="회원가입이 완료되었어요!";
		model.addAttribute("msg", msg);
		model.addAttribute("url", "/blogsystem_search.do");
		return "redirect";
		}
		else {
			String msg = "안돼요 안돼! 똑같은 아이디가 있어요! 다시 해볼까요 파스칼?";
			model.addAttribute("msg", msg);
			model.addAttribute("url", "/createUser.do");
			return "redirect";
		}
	}
	@RequestMapping("/deleteUser.do")
	public String deleteUser() {
		return "deleteUser";
	}
	@RequestMapping("/deletedUser.do")
	public String deletedUser(Blog_User blog_user, Principal principal, Model model) {
		String inputedId = blog_user.getUserId();
		String inputedPassword = blog_user.getUserPassword();


		
		Blog_User blog_User2 = blog_UserService.findByuserId(principal.getName());
		String id = blog_User2.getUserId();
		String password = blog_User2.getUserPassword();

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(inputedId==id && encoder.matches(inputedPassword, password));
		String msg = "회원탈퇴가 완료되었어요... 다시돌아와주실거죠?";
		blog_UserService.deleteBlog_User(blog_User2);
		model.addAttribute("msg", msg);
		model.addAttribute("url", "logout");
		return "redirect";
	}

}
