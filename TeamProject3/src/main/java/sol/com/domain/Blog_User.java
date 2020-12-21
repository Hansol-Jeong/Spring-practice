package sol.com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Blog_User {//id, name, role, password
@Id
@GeneratedValue
@Column(length=10)
private String id;
@Column(length=100,nullable=false)
private String name;
@Column(length=32,nullable=false)
private String role;
private String password;
@OneToMany(mappedBy = "blog_User" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<Blog> blogList = new ArrayList<>();
}
