package com.fse.assessment.service;

import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSEProjectDTO;
import com.fse.assessment.service.response.ViewAllProjectsResponse;

public interface FSEProjectService {

	ViewAllProjectsResponse getAllProjects();

	BaseResponse deleteProject(String projectId);

	BaseResponse addProject(FSEProjectDTO projectDTO);

	BaseResponse updateProject(FSEProjectDTO project);

}
