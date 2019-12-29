package com.fse.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSETaskDTO;
import com.fse.assessment.service.FSETaskService;
import com.fse.assessment.service.response.ViewAllTasksResponse;


@RestController // Helps Spring know that this is a rest controller and hence
				// while scanning registers the mappings
public class TaskController {

	@Autowired
	FSETaskService fseTaskServiceImpl;

	

	//view all
	@RequestMapping("projmanager/task/view/all")
	public ViewAllTasksResponse getAllTasks() {
		System.out.println("Request Received for getAllUsers");
		return fseTaskServiceImpl.getAllTasks();
	}
	
	//view all Parents
	@RequestMapping("projmanager/parenttask/view/all")
	public ViewAllTasksResponse getAllParentTasks() {
		System.out.println("Request Received for getAllParentTasks");
		return fseTaskServiceImpl.getAllParentTasks();
	}
	

	//Add
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/task/add")
	public BaseResponse addTask(@RequestBody FSETaskDTO task) {
		System.out.println("Request received for addTask");
		return fseTaskServiceImpl.addTask(task);
		
	}
		
	//delete
	@RequestMapping("projmanager/task/delete/{taskId}")
	public BaseResponse deleteTask(@PathVariable String taskId) {
		System.out.println("Request Received for deleteTask");
		return fseTaskServiceImpl.deleteTask(taskId);
		
	}

	
	//Update
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/task/update")
	public BaseResponse updateTask(@RequestBody FSETaskDTO task) {
		System.out.println("Request received for updateTask");
		return fseTaskServiceImpl.updateTask(task);
		
	}

}
