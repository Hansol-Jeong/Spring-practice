package sol.com.domain;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="category")
@Entity
public class Post {//포스트 아이디, 타이틀, 컨텐츠, FK:카테고리 아이디
	@Id
	@GeneratedValue
	@Column(name="POST_ID")
	private Long postId;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content;
	@Temporal(value=TemporalType.DATE)
	private Date regiDate;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID", nullable=false)
	private Category category;
	
	@OneToMany(mappedBy="post", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT) 
	private List<Comment> commentList = new ArrayList<>();
	
}
