package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.domain.Post;

public class PostRowMapper implements RowMapper<Post>{
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
		Post post=new Post();
		post.setPostId(rs.getInt(1));
		post.setTitle(rs.getString(2));
		post.setContent(rs.getString(3));
		post.setView(rs.getInt(4));
		post.setWriter(rs.getString(5));
		post.setImageName(rs.getString(6));
		return post;
	}

}
