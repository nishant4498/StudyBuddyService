package org.gis.studybuddy.service;

import java.util.List;

import org.gis.studybuddy.dao.CommonDAO;
import org.gis.studybuddy.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commonService")
public class CommonService {
	@Autowired
	CommonDAO commonDao;

	@Transactional
	public List<Subject> getAllSubjects() {
		return commonDao.getAllSubjects();
	}

//	@Transactional
//	public User getUser(String id) {
//		return commonDao.getUser(id);
//	}
//
//	@Transactional
//	public void addUser(User user) {
//		commonDao.addUser(user);
//	}
//
//	@Transactional
//	public void updateUser(User user) {
//		commonDao.updateUser(user);
//	}
//
//	@Transactional
//	public void deleteUser(String id) {
//		commonDao.deleteUser(id);
//	}
}
