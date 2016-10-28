package org.gis.studybuddy.controller;

import java.util.List;

import org.gis.studybuddy.model.Subject;
import org.gis.studybuddy.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
	@Autowired
	CommonService commonService;

	@RequestMapping(value = "/getAllSubjects", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Subject> getSubjects() {
		List<Subject> listOfSubjects = commonService.getAllSubjects();
		return listOfSubjects;
	}

//	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
//	public User getCountryById(@PathVariable("id") String id) {
//		return commonService.getUser(id);
//	}
//
//	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
//	public void addUser(@RequestBody User user) {
//		commonService.addUser(user);
//	}
//
//	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, headers = "Accept=application/json")
//	public void updateUser(@RequestBody User user) {
//		commonService.updateUser(user);
//	}
//
//	@RequestMapping(value = "/deleteUser/{userid}", method = RequestMethod.DELETE, headers = "Accept=application/json")
//	public void deleteUser(@PathVariable("userid") String id) {
//		commonService.deleteUser(id);
//	}
}
