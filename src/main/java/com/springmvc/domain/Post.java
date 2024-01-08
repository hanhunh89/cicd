package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Post {

	private int postId;
	private String title;
	private String content;
	private String writer;
	private String imageName;
	private MultipartFile postImage;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	private int view;
	
	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	private int views;
	
	public Post() {
	}

	public MultipartFile getPostImage() {
		return postImage;
	}

	public void setPostImage(MultipartFile postImage) {
		this.postImage = postImage;
	}

	
}
