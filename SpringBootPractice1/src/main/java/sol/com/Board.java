package sol.com;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Entity
@Data
public class Board {
@Id
@GeneratedValue
private Long seq;
private String title;
private String writer;
private String content;
@Temporal(value=TemporalType.TIMESTAMP)
private Date createDate;
private Long cnt;
}
