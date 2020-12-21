package sol.com.domain;

import java.util.ArrayList;
import java.util.List;

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
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString(exclude="blog")
@Entity
public class Category {//카테고리 아이디, 카테고리이름, 디스플레이 타입, 보이는 포스트 수 , 설명, fk블로그 아이디
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Long categoryId;
	@Column(unique=true)
	private String categoryName;
	private String categoryDisplayType;
	private Long categoryDisplayCount;
	private String categoryDescription;
	
//	public String toString() {
//	return categoryName; 	
//	}
	@ManyToOne
	@JoinColumn(name="BLOG_ID", nullable=false)
	private Blog blog;
	
	public void setBlog(Blog blog) {
		this.blog = blog;
		blog.getCategoryList().add(this);
	}
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT) 
	private List<Post> postList = new ArrayList<>();
	
}
