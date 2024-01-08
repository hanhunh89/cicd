package com.springmvc.service;
// Customize UserDetailsService in Spring Security 3.1.7

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
	private com.springmvc.service.UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.springmvc.domain.User user = userService.getUser(username);
        if (user == null) {
        	System.out.println("user is null");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(user);
        
        return new org.springframework.security.core.userdetails.User(
                user.getUserId(),
                user.getPassword(),
                auths);
    }
}