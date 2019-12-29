/**
 * 
 */
package com.fse.assessment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author O3407
 *
 */

@Entity
@Table(name = "FSE_TASK")
public class FSETask implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long taskId;
	
	private String taskName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private Integer priority;
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private FSEUser taskOwner;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "parentTaskId", referencedColumnName = "parentTaskId")
	private FSEParentTask parentTask;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "projectId", referencedColumnName = "projectId")
	private FSEProject project;


	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public FSEUser getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(FSEUser taskOwner) {
		this.taskOwner = taskOwner;
	}

	public FSEParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(FSEParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public FSEProject getProject() {
		return project;
	}

	public void setProject(FSEProject project) {
		this.project = project;
	}

	
	
	
	

}
