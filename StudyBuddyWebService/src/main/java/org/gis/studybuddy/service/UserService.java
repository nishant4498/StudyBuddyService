package org.gis.studybuddy.service;

import java.util.List;
import org.gis.studybuddy.dao.UserDAO;
import org.gis.studybuddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
	@Autowired
	UserDAO userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}
}
