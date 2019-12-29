/**
 * 
 */
package com.fse.assessment.service.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSETaskDTO;

/**
 * @author O3407
 *
 */

@JsonInclude(Include.NON_NULL)
public class ViewAllTasksResponse extends BaseResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<FSETaskDTO> taskList;


	public List<FSETaskDTO> getTaskList() {
		return taskList;
	}


	public void setTaskList(List<FSETaskDTO> taskList) {
		this.taskList = taskList;
	}
	
	
	
	
}
