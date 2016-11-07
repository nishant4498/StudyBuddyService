package org.gis.studybuddy.dao;

import java.sql.Timestamp;
import java.util.List;

import org.gis.studybuddy.mapper.GroupMapper;
import org.gis.studybuddy.mapper.IntegerMapper;
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
		int count = 0;
		if(maxCapacity != null){
			query += " where capacity <=" + maxCapacity;
			count++;
		}
		
		if(subjectId != null){
			if(count > 0){
				query += " and subjectid =" + subjectId;
			}else{
				query += "where subjectid =" + subjectId;
			}
			count++;
		}
		
		if(startTimestamp != null){
			if(count > 0){
				query += " and starttime > (TIMESTAMP " + "\'" + new Timestamp(startTimestamp) + "\')";
			}else{
				query += " where starttime > (TIMESTAMP " + "\'" + new Timestamp(startTimestamp)  + "\')";
			}
			count++;
		}
		
		if(endTimestamp != null){
			if(count > 0){
				query += " and endtime < " + "\"" + new Timestamp(endTimestamp) + "\"";
			}else{
				query += " where endtime < " + "\"" + new Timestamp(endTimestamp) + "\"";
			}
			count++;
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
		String deleteGroupQuery = "delete from public.group where groupid = " + "\'" + id + "\'";
		jdbcTemplate.execute(deleteGroupQuery);
		
		String deleteMembersQuery = "delete from public.groupmembers where groupid = " + "\'" + id + "\'";
		jdbcTemplate.execute(deleteMembersQuery);
		
	}
	
	public void joinGroup(Integer groupId, String userId) {
		String query = "SELECT \"groupid\", \"subjectid\", \"groupname\", \"admin\", \"starttime\", \"endtime\", \"capacity\", \"nummembers\", \"locationname\",\"topic\", ST_Y(\"point\"::geometry) as latCoord, ST_X(\"point\"::geometry) as longCoord FROM public.\"group\"";
		query += " where groupid =" + groupId;	
		
		List<Group> groupList = jdbcTemplate.query(query, new GroupMapper());
		if(!groupList.isEmpty()){
			Group grp = groupList.get(0);
			int maxCap = grp.capacity;
			int currCap = grp.numMembers;
			//TODO Send an error message that either the group is empty.
			if(maxCap == currCap){
				return;
			}
			
			String updateCapacityQuery = "update public.group set nummembers = " + (currCap + 1) + "where groupid = " + groupId;
			jdbcTemplate.execute(updateCapacityQuery);
			
			String updateGroupInfoQuery = "insert into public.groupmembers (groupid, userid) values (?, ?)";
			jdbcTemplate.update(updateGroupInfoQuery,groupId , userId);			
		}
		
	}
	
	public List<Integer> getAllJoinedGroups(String userId) {
		String query = "SELECT groupid FROM public.groupmembers where userid = " + "\'" + userId + "\'";
		List<Integer> groupList = jdbcTemplate.query(query, new IntegerMapper());
		return groupList;
	}
}
