package org.gis.studybuddy.dao;

import java.util.List;

import org.gis.studybuddy.mapper.UserMapper;
import org.gis.studybuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> getAllUsers() {
		String query = "select * from public.user";
		List<User> userList = jdbcTemplate.query(query, new UserMapper());
		return userList;
	}

	public User getUser(String id) {
		String query = "select * from public.user where userid = " + "\'" + id + "\'";
		List<User> userList = jdbcTemplate.query(query, new UserMapper());
		return userList.get(0);
	}

	public User addUser(User user) {
		String query = "insert into public.user (userid, name, passwordhash) values (?, ?, ?)";
		System.out.println(query);
		jdbcTemplate.update(query,user.getUserId() , user.getName(), user.getPassword());
		return new User();
	}

	public void updateUser(User user) {
		// TODO Not sure what needs to be updated for a user.
	}

	public void deleteUser(String id) {
		String query = "delete from public.user where userid = " + "\'" + id + "\'";
		jdbcTemplate.execute(query);
	}
}
