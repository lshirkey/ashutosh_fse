package com.fse.assessment.service;

import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSETaskDTO;
import com.fse.assessment.service.response.ViewAllTasksResponse;

public interface FSETaskService {

	ViewAllTasksResponse getAllTasks();

	BaseResponse addTask(FSETaskDTO task);

	BaseResponse updateTask(FSETaskDTO task);

	BaseResponse deleteTask(String taskId);

	ViewAllTasksResponse getAllParentTasks();

}
