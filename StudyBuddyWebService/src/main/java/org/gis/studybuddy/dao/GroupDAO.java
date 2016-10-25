package org.gis.studybuddy.dao;

import java.util.List;

import org.gis.studybuddy.mapper.GroupMapper;
import org.gis.studybuddy.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Group> getAllGroups() {
		String query = "SELECT \"groupid\", \"subjectid\", \"groupname\", \"admin\", \"starttime\", \"endtime\", \"capacity\", \"nummembers\", \"locationname\", ST_Y(\"point\"::geometry) as latCoord, ST_X(\"point\"::geometry) as longCoord FROM public.\"group\"";
		List<Group> groupList = jdbcTemplate.query(query, new GroupMapper());
		return groupList;
	}
	
	
	public List<Group> searchGroups(Integer maxCapacity, Integer subjectId ,Long startTimestamp,Long endTimestamp) {
		String query = "SELECT \"groupid\", \"subjectid\", \"groupname\", \"admin\", \"starttime\", \"endtime\", \"capacity\", \"nummembers\", \"locationname\", ST_Y(\"point\"::geometry) as latCoord, ST_X(\"point\"::geometry) as longCoord FROM public.\"group\"";
		if(maxCapacity != null){
			query += " where capacity <=" + maxCapacity;
		}
		
		if(subjectId != null){
			query += " and subjectid =" + subjectId;
		}
				
		List<Group> groupList = jdbcTemplate.query(query, new GroupMapper());
		return groupList;
	}
	

//	public User getUser(String id) {
//		String query = "select * from public.user where userid = " + "\'" + id + "\'";
//		List<User> userList = jdbcTemplate.query(query, new UserMapper());
//		return userList.get(0);
//	}
//
//	public User addUser(User user) {
//		String query = "insert into public.user (userid, name, passwordhash) values (?, ?, ?)";
//		System.out.println(query);
//		jdbcTemplate.update(query,user.getUserId() , user.getName(), user.getPassword());
//		return new User();
//	}
//
//	public void updateUser(User user) {
//		// TODO Not sure what needs to be updated for a user.
//	}
//
//	public void deleteUser(String id) {
//		String query = "delete from public.user where userid = " + "\'" + id + "\'";
//		jdbcTemplate.execute(query);
//	}
}
