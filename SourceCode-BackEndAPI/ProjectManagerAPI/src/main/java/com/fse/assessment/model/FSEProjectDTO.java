/**
 * 
 */
package com.fse.assessment.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author O3407
 *
 */

public class FSEProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String projectId;
	private String projectName;
	private Date startDate;
	private Date endDate;
	private Integer priority;
	private String userId;
	private String status;
	private Integer noOfTasks;
	private Integer completedTaskCount;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getNoOfTasks() {
		return noOfTasks;
	}
	public void setNoOfTasks(Integer noOfTasks) {
		this.noOfTasks = noOfTasks;
	}
	public Integer getCompletedTaskCount() {
		return completedTaskCount;
	}
	public void setCompletedTaskCount(Integer completedTaskCount) {
		this.completedTaskCount = completedTaskCount;
	}
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
	
	

}
