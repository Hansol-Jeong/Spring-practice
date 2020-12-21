package sol.com.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString(exclude="blog_User")
public class Blog {//블로그 아이디, 제목, 태그, 디스플레이 포스트 수, 파일이름, FK블로그 유저
	@Id
	@GeneratedValue
	@Column(name="BLOG_ID")
	private Long blogId;
	@Column(nullable=false)
	private String blogTitle;
	@Column(name="blog_tag", nullable=true)
	private String blogTag="";
	private Long blogDisplayCount;
	private String status;
	private String blogFileName;
	private String searchCondition;
	private String searchKeyword;
	

	public void setBlogTag(String tag) {
		blogTag="";
		blogTag=blogTag+","+tag;
	}
	public void setBlogTag(List<String> tags) {
		blogTag = "";
		for(String tag: tags) {
			blogTag=blogTag+","+tag;
		}
	}
	public List<String> getBlogTag() {
		List<String> tags = new ArrayList<>();
		try {
		StringTokenizer stk = new StringTokenizer(blogTag,",");
		while(stk.hasMoreTokens()) {
			tags.add(stk.nextToken());
		}
		return tags;
		} catch (NullPointerException e) {
			tags.add("");
			return tags;
		}
	}
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private Blog_User blog_User;
	
	@OneToMany(mappedBy="blog", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT) 
	private List<Category> categoryList = new ArrayList<>();
	
}
