package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.domain.User;
import com.springmvc.service.UserService;
import com.springmvc.util.GetServerIp;
import com.springmvc.util.GetUserIdFromSpringSecurity;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String createUserController_get(@ModelAttribute("newUser") User user) {
		return "join";
	}
	@RequestMapping(value="/existUserId", method=RequestMethod.GET)
	public String createUserController_existUserId(@ModelAttribute("newUser") User user, Model model) {
		// "이미 존재하는 유저입니다" 시현
		model.addAttribute("userExist","true");
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String createUserController_post(@ModelAttribute("newUser") User user, Model model) {
		// user가 존재하면 redirect
		User u = userService.getUser(user.getUserId());
		if(u!=null) {
			return "redirect:/user/existUserId";
		}
		
		//user 존재하지 않으면 생성
		userService.createUser(user);
		return "redirect:/post";
	}
	@RequestMapping(value="/delete/{userId}", method=RequestMethod.GET)
	public String deleteUserController(@PathVariable String userId) {
		userService.deleteUser(userId);
		return "redirect:/post";
	}
}

