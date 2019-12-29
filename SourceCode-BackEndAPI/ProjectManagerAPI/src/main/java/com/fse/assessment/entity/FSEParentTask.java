/**
 * 
 */
package com.fse.assessment.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author O3407
 *
 */

@Entity
@Table(name = "FSE_PARENT_TASK")
public class FSEParentTask implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long parentTaskId;
	
	private String parentTaskName;
	
	/*@OneToMany(mappedBy = "parentTask")
	private List<FSETask> taskList;*/

	public long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	/*public List<FSETask> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<FSETask> taskList) {
		this.taskList = taskList;
	}*/
	
	
	

}
