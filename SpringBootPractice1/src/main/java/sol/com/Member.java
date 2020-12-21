package sol.com;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String pasword;
	private String name;
	private String role;
	
	@OneToMany (mappedBy="member", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Content> contentList = new ArrayList<>();
//	
//	@OneToMany (mappedBy="member", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
//	private List<Post> postList = new ArrayList<>();
//	
}
