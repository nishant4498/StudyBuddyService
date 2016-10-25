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
	public List<Group> searchGroups(Integer maxCapacity, Integer subjectId ,Long startTimestamp,Long endTimestamp) {
		return groupDao.searchGroups(maxCapacity, subjectId , startTimestamp , endTimestamp);
	}

//	@Transactional
//	public User getUser(String id) {
//		return groupDao.getUser(id);
//	}
//
//	@Transactional
//	public void addUser(User user) {
//		groupDao.addUser(user);
//	}
//
//	@Transactional
//	public void updateUser(User user) {
//		groupDao.updateUser(user);
//	}
//
//	@Transactional
//	public void deleteUser(String id) {
//		groupDao.deleteUser(id);
//	}
}
