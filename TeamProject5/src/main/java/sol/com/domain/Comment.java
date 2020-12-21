package sol.com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude= "post")
@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long commentId;
	private String name;
	private String content;
	@Temporal(value=TemporalType.DATE)
	private Date regiDate;
	
	
	@ManyToOne
	@JoinColumn(name="POST_ID", nullable=false)
	private Post post;
	
}
