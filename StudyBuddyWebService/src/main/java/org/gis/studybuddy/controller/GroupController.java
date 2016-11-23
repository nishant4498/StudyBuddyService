package org.gis.studybuddy.controller;

import java.util.List;

import org.gis.studybuddy.model.Group;
import org.gis.studybuddy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Group> getCountries() {
		List<Group> groupList = groupService.getAllGroups();
		return groupList;
	}
	
	@RequestMapping(value = "/searchGroups", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Group> searchGroups(@RequestParam(value = "maxCapacity", required = false) Integer maxCapacity,
			@RequestParam(value = "subjectId", required = false) Integer subjectID,
			@RequestParam(value = "startTimestamp", required = false) Long startTimestamp,
			@RequestParam(value = "endTimestamp", required = false) Long endTimestamp) {
		return groupService.searchGroups(maxCapacity , subjectID , startTimestamp, endTimestamp);
	}
	
	@RequestMapping(value = "/getKNearestGroups", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Group> getKNNGroups(@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "longitude", required = true) Double longitude,
			@RequestParam(value = "k", required = true) Integer k ) {
		return groupService.getKNNGroups(latitude, longitude, k);
	}
	
	@RequestMapping(value = "/createGroup", method = RequestMethod.POST, headers = "Accept=application/json")
	public void createGroup(@RequestBody Group group) {
		groupService.createGroup(group);
	}
	
	@RequestMapping(value = "/joinGroup", method = RequestMethod.GET, headers = "Accept=application/json")
	public void joinGroup(@RequestParam(value = "groupId", required = false) Integer groupId,
			@RequestParam(value = "userId", required = false) String userId) {
		groupService.joinGroup(groupId, userId);
	}
	
	@RequestMapping(value = "/deleteGroup/{groupid}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteGroup(@PathVariable("groupid") String id) {
		groupService.deleteGroup(id);
	}
	
	@RequestMapping(value = "/getJoinedGroups/{userid}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Integer> getAllJoinedGroups(@PathVariable("userid") String userId) {
		List<Integer> groupList = groupService.getAllJoinedGroups(userId);
		return groupList;
	}

}
