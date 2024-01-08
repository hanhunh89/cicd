package com.springmvc.service;

import java.util.List;
import com.springmvc.domain.Post;

public interface PostService {
	void createPost(Post post);
	Post getPostById(int postId);
	List<Post> getAllPosts();
	void addPostView(Post post);
	void deletePost(Post post);
	void saveAttachFile(Post post);
	void deleteAttachFile(Post post);
}
