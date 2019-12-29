/**
 * 
 */
package com.fse.assessment.model;

import java.io.Serializable;

/**
 * @author O3407
 *
 */

public class FSEUserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String employeeId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	
	
	
}
