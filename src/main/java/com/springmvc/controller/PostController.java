package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.Post;
import com.springmvc.service.PostService;

import com.springmvc.util.DeletePostImage;
import com.springmvc.util.GetServerIp;
import com.springmvc.util.GetUserIdFromSpringSecurity;
@Controller

public class PostController {

	@Autowired
	private PostService postService;

	@ModelAttribute
	public void addCommonAttributes(Model model) {
		String user_id=GetUserIdFromSpringSecurity.getCurrentUsername();
		String serverIp=GetServerIp.getServerIpAddress();
		model.addAttribute("serverIp", serverIp);
		model.addAttribute("user_id", user_id);
	}	
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String listOfpage(HttpServletRequest request,Model model) {
		List<Post> postList= postService.getAllPosts();
		model.addAttribute("currentURI", request.getRequestURI());
		model.addAttribute("postList", postList);
		return "main";
	}
	
	@RequestMapping(value="/post/{postId}", method=RequestMethod.GET)
	public String getPost(@PathVariable int postId, HttpServletRequest request, Model model) {
		Post p=postService.getPostById(postId); // get post with postId;
		postService.addPostView(p);  // view=view+1
		String deleteURI=request.getContextPath()+"/post/delete/"+postId;
		String goBackURI=request.getContextPath()+"/post";
		
		model.addAttribute("deleteURI", deleteURI);
		model.addAttribute("goBackURI", goBackURI);

		model.addAttribute("post", p);
		return "PostDetail";
	}
	@RequestMapping(value="/post/addPost", method=RequestMethod.GET)
	public String getAddPostPage(@ModelAttribute("newPost") Post post) {
		return "addPost";
	}
	
	@RequestMapping(value="/post/addPost", method=RequestMethod.POST)
	public String addPost(@ModelAttribute("newPost") Post post, Model model) {        
        postService.saveAttachFile(post);        
        
		post.setWriter(GetUserIdFromSpringSecurity.getCurrentUsername());
		postService.createPost(post);		
		return "redirect:/post";
	}
	@RequestMapping(value="/post/delete/{postId}", method=RequestMethod.GET)
	public String deletePost(@PathVariable int postId) {
		Post p=postService.getPostById(postId); // get post with postId;
		String user_id=GetUserIdFromSpringSecurity.getCurrentUsername();
		if(p.getWriter().equals(user_id)) {
			postService.deleteAttachFile(p);
			postService.deletePost(p);
		}
		return "redirect:/post";			
	}	
}

