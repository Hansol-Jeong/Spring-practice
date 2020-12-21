package sol.com;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude= "content")
public class Post {
	@Id
	@GeneratedValue
	private Long seq;
	private String tag;
	private String title;
	
	@ManyToOne
	@JoinColumn(name="CONTENT_ID")
	private Content content;
	
//	@ManyToOne
//	@JoinColumn(name="MEMBER_ID")
//	private Member member;
}
