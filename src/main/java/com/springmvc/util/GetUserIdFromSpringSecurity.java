package com.springmvc.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GetUserIdFromSpringSecurity {
	public static String getCurrentUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || !authentication.isAuthenticated()) {
	    	return null; // 현재 사용자가 인증되지 않은 경우 또는 사용자가 없는 경우
	    }
	    Object principal = authentication.getPrincipal();
	    if (principal instanceof UserDetails) {
	     	return ((UserDetails) principal).getUsername();
	    } else {
	        return principal.toString();
	    }
	}
}