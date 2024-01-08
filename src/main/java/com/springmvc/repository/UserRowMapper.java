package com.springmvc.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.domain.User;

public class UserRowMapper implements RowMapper<User>{ 
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User user=new User();
		user.setUserId(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setCreatedAt(rs.getTimestamp(3));
		user.setAuth(rs.getString(4));
		return user;
	}
}


