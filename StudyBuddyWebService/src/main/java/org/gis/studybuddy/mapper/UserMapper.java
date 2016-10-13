package org.gis.studybuddy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gis.studybuddy.model.User;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getString("id"));
		user.setUserId(rs.getString("userId"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("passwordHash"));
		return user;
	}
}
