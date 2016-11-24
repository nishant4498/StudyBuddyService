package org.gis.studybuddy.service;

import java.util.List;

import org.gis.studybuddy.dao.GroupDAO;
import org.gis.studybuddy.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("groupService")
public class GroupService {
	@Autowired
	GroupDAO groupDao;

	@Transactional
	public List<Group> getAllGroups() {
		return groupDao.getAllGroups();
	}
	
	@Transactional
	public List<Group> searchGroups(Integer maxCapacity, Integer subjectId ,Long startTimestamp,Long endTimestamp, Double latitude, Double longitude ,Integer k, Integer range) {
		return groupDao.searchGroups(maxCapacity, subjectId , startTimestamp , endTimestamp, latitude, longitude, k, range);
	}
	
	@Transactional
	public void createGroup(Group group) {
		groupDao.createGroup(group);
	}
	
	@Transactional
	public void deleteGroup(String id) {
		groupDao.deleteGroup(id);
	}

	@Transactional
	public void joinGroup(Integer groupId, String userId) {
		groupDao.joinGroup(groupId, userId);
	}
	
	@Transactional
	public void addFavourite(Integer groupId, String userId) {
		groupDao.addFavourite(groupId, userId);
	}
	
	@Transactional
	public List<Integer> getAllJoinedGroups(String userId) {
		return groupDao.getAllJoinedGroups(userId);
	}
	
	@Transactional
	public List<Integer> getUpcomingGroup(String userId) {
		return groupDao.getUpcomingGroup(userId);
	}
	
	
	
	@Transactional
	public List<Integer> getAllFavouriteGroups(String userId) {
		return groupDao.getAllFavouriteGroups(userId);
	}

}
