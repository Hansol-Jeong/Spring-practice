package sol.com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	private String user_id;
	private String usesr_name;
	private String user_role;
	private String user_password;
}
