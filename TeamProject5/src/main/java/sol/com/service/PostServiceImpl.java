package sol.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.com.domain.Post;
import sol.com.persistence.PostRepo;

@Service
public class PostServiceImpl implements PostService{
@Autowired
private PostRepo postRepo;

@Override
public void insertPost(Post post) {
	postRepo.save(post);
}

@Override
public Post findById(Long id) {
	return postRepo.findBypostId(id);
}

}
