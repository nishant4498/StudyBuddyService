package org.gis.studybuddy.model;

import java.sql.Timestamp;

public class Group {
	public String id;
	public String subjectId;
	public String groupName;
	public String adminId;
	public Timestamp startTimestamp;
	public Timestamp endTimestamp;
	public int capacity;
	public int numMembers;
	public String locationName;
	public double latitude;
	public double longitude;
	
	public Group(){
		super();
	}

}
