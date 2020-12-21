package sol.com.service;

import sol.com.domain.Post;

public interface PostService {
	void insertPost(Post post);
	Post findById(Long id);
}
