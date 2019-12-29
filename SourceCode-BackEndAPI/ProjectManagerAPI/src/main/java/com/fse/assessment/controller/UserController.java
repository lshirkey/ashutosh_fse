package com.fse.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.service.FSEUserService;
import com.fse.assessment.service.response.ViewAllUsersResponse;


@RestController // Helps Spring know that this is a rest controller and hence
				// while scanning registers the mappings
public class UserController {

	@Autowired
	FSEUserService fseUserServiceImpl;

	@RequestMapping("projmanager/hello")
	public String sayHello() {
		return "Hello from FSE Project Manager!!";
	}

	//view all
	@RequestMapping("projmanager/user/view/all")
	public ViewAllUsersResponse getAllUsers() {
		System.out.println("Request Received for getAllUsers");
		return fseUserServiceImpl.getAllUsers();
	}

	
	//Add
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/user/add")
	public BaseResponse addUser(@RequestBody FSEUser user) {
		System.out.println("Request received for addUser");
		return fseUserServiceImpl.addUser(user);
		
	}
	
	
	//delete
	@RequestMapping("projmanager/user/delete/{userId}")
	public BaseResponse deleteUser(@PathVariable String userId) {
		System.out.println("Request Received for deleteUser");
		return fseUserServiceImpl.deleteUser(userId);
		
	}

	
	
	//Update
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/user/update")
	public BaseResponse updateUser(@RequestBody FSEUser user) {
		System.out.println("Request received for updateUser");
		return fseUserServiceImpl.updateUser(user);
		
	}

}
