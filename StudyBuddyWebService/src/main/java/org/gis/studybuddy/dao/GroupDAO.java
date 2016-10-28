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
		String query = "SELECT \"groupid\", \"subjectid\", \"groupname\", \"admin\", \"starttime\", \"endtime\", \"capacity\", \"nummembers\", \"locationname\",\"topic\", ST_Y(\"point\"::geometry) as latCoord, ST_X(\"point\"::geometry) as longCoord FROM public.\"group\"";
		List<Group> groupList = jdbcTemplate.query(query, new GroupMapper());
		return groupList;
	}
	
	
	public List<Group> searchGroups(Integer maxCapacity, Integer subjectId ,Long startTimestamp,Long endTimestamp) {
		String query = "SELECT \"groupid\", \"subjectid\", \"groupname\", \"admin\", \"starttime\", \"endtime\", \"capacity\", \"nummembers\", \"locationname\",\"topic\", ST_Y(\"point\"::geometry) as latCoord, ST_X(\"point\"::geometry) as longCoord FROM public.\"group\"";
		if(maxCapacity != null){
			query += " where capacity <=" + maxCapacity;
		}
		
		if(subjectId != null){
			query += " and subjectid =" + subjectId;
		}
				
		List<Group> groupList = jdbcTemplate.query(query, new GroupMapper());
		return groupList;
	}
	
	public Group createGroup(Group group) {
		String query = "insert into public.group(subjectid, groupname, admin, starttime, endtime, capacity, nummembers, locationname, point,topic)";
		query += "values (?, ?, ?, ?, ?, ?, ?, ?, ST_MakePoint(?, ?),?)";
		jdbcTemplate.update(query,Integer.valueOf(group.subjectId),group.groupName, group.adminId, group.startTimestamp, group.endTimestamp, group.capacity, group.numMembers, group.locationName,group.longitude, group.latitude,group.topic);
		return new Group();
	}
	
	public void deleteGroup(String id) {
		String query = "delete from public.group where groupid = " + "\'" + id + "\'";
		jdbcTemplate.execute(query);
	}
	

//	public User getUser(String id) {
//		String query = "select * from public.user where userid = " + "\'" + id + "\'";
//		List<User> userList = jdbcTemplate.query(query, new UserMapper());
//		return userList.get(0);
//	}
//
//	public void updateUser(User user) {
//		// TODO Not sure what needs to be updated for a user.
//	}
//

}
