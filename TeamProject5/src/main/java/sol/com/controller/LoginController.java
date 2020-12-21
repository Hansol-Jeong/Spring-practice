package sol.com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.h2.command.dml.SetSessionCharacteristics;
import org.springframework.beans.factory.annotation.Autowired;
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
import sol.com.persistence.BlogRepo;
import sol.com.persistence.CommentRepo;
import sol.com.persistence.PostRepo;
import sol.com.service.BlogService;
import sol.com.service.Blog_UserService;
import sol.com.service.CategoryService;
import sol.com.service.CommentService;
import sol.com.service.PostService;

@Controller
public class LoginController {
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

/*	@GetMapping("/")
	public void welcomeView(Model model) {
		Blog blog = new Blog();
		blog.setSearchCondition("TITLE");
		blog.setSearchKeyword(null);
		blogsystem_search(blog, model);
	}*/
	
	@GetMapping("/")
	public String welcomeView(Blog blog, Model model, HttpSession session) {// searchKeyword랑 searchCondition받은상태
		System.out.println(blog.getSearchCondition());
		System.out.println(blog.getSearchKeyword());

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
	            if(blog_User == null) {
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

	/*@PostMapping("/login.do")
	public String login(Blog_User blog_User, HttpSession session) {
		System.out.println("로그인 중입니다...!");
		System.out.println(blog_User);
		try {
			Blog_User findBlogUser = blog_UserService.getBlog_User(blog_User);
			System.out.println(findBlogUser);
			if (blog_User.getUserId().toString().equals(findBlogUser.getUserId().toString())
					&& blog_User.getUserPassword().equals(findBlogUser.getUserPassword())) {
				System.out.println("로그인이 성공한듯합니다...!");
				System.out.println("세션에 유저정보를 저장합니다...?");
				session.setAttribute("user", findBlogUser);
				System.out.println(findBlogUser);
				System.out.println(session.getAttribute("user"));
				return "redirect:" + session.getAttribute("previousPage") + ".do";
			} else {
				System.out.println("비밀번호가 틀린듯합니다...!");
				return "login";
			}
		} catch (NoSuchElementException e) {
			System.out.println("로그인 실패, 다시 돌아오는중입니다...!");
			return "login";
		}

	}*/

	@GetMapping("/blogsystem_search.do")
	public String blogsystem_search(Blog blog, Model model, HttpSession session,Principal principal) {// searchKeyword랑 searchCondition받은상태
		System.out.println(blog.getSearchCondition());
		System.out.println(blog.getSearchKeyword());

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
	            if(blog_User == null) {
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
	
	
	@GetMapping("/category.do") 
	public String category(Category category, HttpSession session, Model model) {
		System.out.println("=======!=======" + category + "==========!==========");
		System.out.println(category.getBlog());
		Blog_User blog_User = blog_UserService.findByName("gilldong");
		Blog blog = blog_User.getBlogList().get(0);
		List<Category> categoryList = blog.getCategoryList();
		System.out.println("==============" +categoryList+ "====================");
		for(Category targetCategory: categoryList) {
			if(targetCategory.getCategoryName().equals(category.getCategoryName())) {
				category = targetCategory;
				break;
			}
		}
		System.out.println("=========!=====" +category+ "==========!==========");
		List<Post> postList = category.getPostList();
		for(Post post: postList) {
			System.out.println(post.getTitle());
		}
		
		model.addAttribute("postList", postList);
		categoryList = categoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		model.addAttribute("blog", blog);
		List<String> tags=blog.getBlogTag();
		List<String> onlyThree=new ArrayList<>();
		for(int i = 0; i<3; i++) {
			if(i==tags.size())
				break;
			onlyThree.add(tags.get(i));
		}
		model.addAttribute("tagList",onlyThree);
		
//		@GetMapping("/"+category.getCategoryName()+".do")
//		public String categoryPage() {
//			
//		}
		return "blogmain_detail";
	}
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:blogsystem_search.do";
	}

	@GetMapping("/blogcreate.do")
	   public String blogcreate(Principal principal, Model model) {
	      System.out.println(principal.getName());
	      if (principal.getName() != null) {
	         if (blog_UserService.findByuserId(principal.getName()).getBlogList().size() > 0) {
	            return "redirect:blogmain_detail.do";
	         }
	      }
	      return "blogcreate";
	   }
	@PostMapping("/addBlog.do")
	public String addBlog(Blog blog, HttpSession session) {// 블로그 객체에 제목이담겨오면
		System.out.println("=============블로그 생성 시작=================");
		System.out.println("================" + blogService.findByBlogTitle(blog.getBlogTitle()) + "================");
		if (blogService.findByBlogTitle(blog.getBlogTitle()).size() == 0) {// 같은 이름이 없으면
			System.out.println("============= 새로 생성 시작 ================");
			System.out.println(session.getAttribute("user"));
			Blog newBlog = new Blog();
			newBlog.setBlogTitle(blog.getBlogTitle());
			newBlog.setBlog_User((Blog_User) session.getAttribute("user"));
			blogService.insertBlog(newBlog);
			return "blogmain_detail";
		} else {
			System.out.println("동일한 이름의 블로그가 있습니다.");
			return "blogcreate";
		}
	}

	@GetMapping("/blogadmin_basic.do")
	public String blogadmin_basic() {
		return "blogadmin_basic";
	}
	
	
	@GetMapping("/addComment.do")
	public String addComment(Comment comment, Model model, HttpSession session) {//이름이랑 컨텐츠
		System.out.println("=========!!======"+comment+"=========!!=========");
		Post post = (Post) session.getAttribute("clikedPost");
		comment.setPost(post);
		comment.setRegiDate(new Date());
		commentService.insertCommnet(comment);
//		model.addAttribute("clikedPost", post);
		return "blogmain_detail";
	}
	@GetMapping("/blogmain_detail.do")
	public String blogmain_detail(Post clikedPost, Model model,HttpSession session, Principal principal) {
			model.addAttribute("clikedPost",clikedPost);
		if(clikedPost.getPostId()==null) {
			Blog_User blog_User = blog_UserService.findByName("gilldong");
			model.addAttribute("blog_User", blog_User);
			Blog blog = blog_User.getBlogList().get(0);
			
			List<Category> categoryList = blog.getCategoryList();
			for(Category category: categoryList) {
				for(Post post: category.getPostList()) {
					System.out.println(post.getTitle());
				}
			}
			List<Post> postList = new ArrayList<>();
			System.out.println(categoryList);
			for(Category category: categoryList) {
				postList.addAll(category.getPostList());
			}
			model.addAttribute("postList", postList);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("blog", blog);

			List<String> tags=blog.getBlogTag();
			List<String> onlyThree=new ArrayList<>();
			for(int i = 0; i<3; i++) {
				if(i==tags.size())
					break;
				onlyThree.add(tags.get(i));
			}
			
			model.addAttribute("tagList",onlyThree);
		return "blogmain_detail";
		}
		else {
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
	

	@PostMapping("/updateBlog.do")
	public String updateBlog(Blog new_blog, HttpSession session) {
		// 유저당 블로그가 하나라면 쉬워지지
		if (blogService.findByBlogTitle(new_blog.getBlogTitle()).size() == 0) {
			System.out.println(new_blog);
			Blog_User blog_User = (Blog_User) session.getAttribute("user");
			Blog old_blog = blog_User.getBlogList().get(0);
			System.out.println("===================" + old_blog + "====================");
			old_blog.setBlogTitle(new_blog.getBlogTitle());
			old_blog.setBlogTag(new_blog.getBlogTag());
			blogService.insertBlog(old_blog);
			return "blogmain_detail";
		} else {
			System.out.println("블로그 이름이 중복됩니다...!");
			return "blogadmin_basic";
		}
	}
	
	

	
	
	
}
