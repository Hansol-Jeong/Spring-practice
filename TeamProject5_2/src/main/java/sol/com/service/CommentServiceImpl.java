package sol.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Comment;
import sol.com.persistence.CommentRepo;
@Service
public class CommentServiceImpl implements CommentService {
@Autowired
private CommentRepo commentRepo;
	@Override
	public void insertCommnet(Comment comment) {
		commentRepo.save(comment);
	}

}
