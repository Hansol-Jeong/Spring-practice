package sol.com.domain;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Blog {
	@Id
	@GeneratedValue
	@Column(length=10)
	private Long blogId;
	@Column(nullable=false, length=100)
	private String blogTitle;
	@Column(length=500)
	private String blogTag;
	private Long blogCntDisplayPost;
	@Column(length=20)
	private String status;
	@Column(length=20)
	private File blogFileName;
	
	private String searchCondition;
	private String searchKeyword;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Blog_User blog_User;
	
	public void setBlog_User(Blog_User blog_User) {
		this.blog_User = blog_User;
		blog_User.getBlogList().add(this);
	}
}
