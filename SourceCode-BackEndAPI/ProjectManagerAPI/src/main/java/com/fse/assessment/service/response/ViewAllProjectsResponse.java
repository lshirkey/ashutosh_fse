/**
 * 
 */
package com.fse.assessment.service.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSEProjectDTO;

/**
 * @author O3407
 *
 */

@JsonInclude(Include.NON_NULL)
public class ViewAllProjectsResponse extends BaseResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<FSEProjectDTO> projectList;


	public List<FSEProjectDTO> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<FSEProjectDTO> projectList) {
		this.projectList = projectList;
	}
	
	
	
	
}
