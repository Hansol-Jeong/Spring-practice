package sol.com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Data
@Entity
public class Blog_User {//아이디, 비밀번호, 역할, 이름
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(nullable=false)
	private String userPassword;
	private String role;
	private String name;
	private boolean enabled;//시큐리티에서 해당 계정이 활성화 되있는지 아닌지
	
	@OneToMany(mappedBy="blog_User", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SELECT) 
	private List<Blog> blogList = new ArrayList<>();

}
