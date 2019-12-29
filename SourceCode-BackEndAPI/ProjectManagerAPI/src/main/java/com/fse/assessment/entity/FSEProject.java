/**
 * 
 */
package com.fse.assessment.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author O3407
 *
 */

@Entity
@Table(name = "FSE_PROJECT")
public class FSEProject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	private String projectName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	private Integer priority;
	
	private String status;
	
	@OneToOne
	@JoinColumn(name = "managerId", referencedColumnName = "userId")
	private FSEUser manager;
	
	/*@OneToMany
	@JoinColumn(name = "projectId", referencedColumnName = "projectId")
	private List<FSETask> taskList;*/
	

	/*public List<FSETask> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<FSETask> taskList) {
		this.taskList = taskList;
	}*/

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
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

	public FSEUser getManager() {
		return manager;
	}

	public void setManager(FSEUser manager) {
		this.manager = manager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
