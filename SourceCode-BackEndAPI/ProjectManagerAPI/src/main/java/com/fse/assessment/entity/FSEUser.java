/**
 * 
 */
package com.fse.assessment.entity;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "FSE_USER")
public class FSEUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String employeeId;
	
	/*@OneToMany(mappedBy = "manager")
	//@JoinColumn(name = "managerId")
	private List<FSEProject> projectsList;
	
	@OneToMany(mappedBy = "taskOwner")
	private List<FSETask> taskList;*/
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/*public List<FSEProject> getProjectsList() {
		return projectsList;
	}
	public void setProjectsList(List<FSEProject> projectsList) {
		this.projectsList = projectsList;
	}*/
	

}
