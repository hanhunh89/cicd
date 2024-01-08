package com.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.domain.Post;
import com.springmvc.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;

	@Override
	public void createPost(Post post) {
		postRepository.createPost(post);
	}
	public Post getPostById(int postId) {
		return postRepository.getPostById(postId);
	}
	public List<Post> getAllPosts(){
		return postRepository.getAllPosts();
	}
	public void addPostView(Post post) {
		postRepository.addPostView(post);
	}
	public void deletePost(Post post) {
		postRepository.deletePost(post);
	}
	public void saveAttachFile(Post post) {
		postRepository.saveAttachFile(post);
	}
	public void deleteAttachFile(Post post) {
		postRepository.deleteAttachFile(post);
	}

}
