package org.gis.studybuddy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gis.studybuddy.model.Group;
import org.springframework.jdbc.core.RowMapper;

public class GroupMapper implements RowMapper<Group> {
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.id = rs.getString("groupid");
		group.subjectId = rs.getString("subjectid");
		group.groupName = rs.getString("groupname");
		group.adminId = rs.getString("admin");		
		group.locationName = rs.getString("locationname");
		group.capacity = rs.getInt("capacity");
		group.numMembers = rs.getInt("nummembers");
		group.startTimestamp = rs.getTimestamp("starttime");
		group.endTimestamp = rs.getTimestamp("endtime");
		group.latitude = rs.getDouble("latCoord");
		group.longitude = rs.getDouble("longCoord");
		return group;
	}
}
