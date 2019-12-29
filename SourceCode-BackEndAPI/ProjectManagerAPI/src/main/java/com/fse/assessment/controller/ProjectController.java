package com.fse.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSEProjectDTO;
import com.fse.assessment.service.FSEProjectService;
import com.fse.assessment.service.response.ViewAllProjectsResponse;


@RestController // Helps Spring know that this is a rest controller and hence
				// while scanning registers the mappings
public class ProjectController {

	@Autowired
	FSEProjectService fseProjectServiceImpl;
	

	

	//view all
	@RequestMapping("projmanager/project/view/all")
	public ViewAllProjectsResponse getAllProjects() {
		System.out.println("Request Received for getAllProjects");
		return fseProjectServiceImpl.getAllProjects();
	}

	//Add
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/project/add")
	public BaseResponse addProject(@RequestBody FSEProjectDTO projectDTO) {
		System.out.println("Request received for addProject");
		return fseProjectServiceImpl.addProject(projectDTO);
		
	}
		
		
	//delete
	@RequestMapping("projmanager/project/delete/{projectId}")
	public BaseResponse deleteProject(@PathVariable String projectId) {
		System.out.println("Request Received for deleteProject");
		return fseProjectServiceImpl.deleteProject(projectId);
		
	}

	
	//Update
	@RequestMapping(method = RequestMethod.POST, value = "projmanager/project/update")
	public BaseResponse updateProject(@RequestBody FSEProjectDTO project) {
		System.out.println("Request received for updateProject");
		//return fseProjectServiceImpl.updateProject(project);
		return fseProjectServiceImpl.addProject(project);
		
	}

}
