package com.springmvc.repository;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private JdbcTemplate template;
	@Autowired
	public void setJdbctemplate(DataSource dataSource) {
		this.template=new JdbcTemplate(dataSource);
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Override
	public void createUser(User user) {
		String hashedPassword=passwordEncoder.encode(user.getPassword());
		
		String SQL="INSERT INTO user (userId, password) VALUES (?,?)";
		template.update(SQL, user.getUserId(), hashedPassword);
	}
	public User getUser(String userId) {
		User user=null;
		String SQL="SELECT count(*) FROM user where userId=?";
		int rowCount=template.queryForObject(SQL, Integer.class, userId);
		if(rowCount !=0) {
			SQL="SELECT * FROM user where userId=?";
			user=template.queryForObject(SQL,  new Object[] {userId}, new UserRowMapper());
		}
		if(user==null) {
			return null;
//			throw new IllegalArgumentException("userId가 "+userId+"인 user를 찾을 수 없다.");
		}
		return user;
	}
	public void deleteUser(String userId) {
		String SQL="DELETE FROM user WHERE userId=?";
		template.update(SQL, userId);
	}
}