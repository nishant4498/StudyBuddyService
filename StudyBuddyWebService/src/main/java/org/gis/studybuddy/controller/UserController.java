package org.gis.studybuddy.controller;

import java.util.List;

import org.gis.studybuddy.model.User;
import org.gis.studybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<User> getCountries() {
		List<User> listOfCountries = userService.getAllUsers();
		return listOfCountries;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getCountryById(@PathVariable("id") String id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/deleteUser/{userid}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("userid") String id) {
		userService.deleteUser(id);
	}
}
