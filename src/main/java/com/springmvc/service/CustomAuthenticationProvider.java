package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class CustomAuthenticationProvider implements AuthenticationProvider 
{
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
  
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException 
    {
        String user_id = (String)authentication.getPrincipal();    
        String user_pw = (String)authentication.getCredentials();
         
        
        User user = (User) userService.loadUserByUsername(user_id);

      if(! passwordEncoder.matches(user_pw, user.getPassword())){
        	throw new BadCredentialsException("Bad credentials");
        }      
        return new UsernamePasswordAuthenticationToken(user_id, user_pw, user.getAuthorities());
    }
    
    @Override
    public boolean supports(Class<?> authentication) 
    {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}