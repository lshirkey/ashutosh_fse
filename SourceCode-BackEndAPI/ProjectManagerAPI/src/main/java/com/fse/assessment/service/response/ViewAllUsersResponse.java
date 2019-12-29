/**
 * 
 */
package com.fse.assessment.service.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;

/**
 * @author O3407
 *
 */

@JsonInclude(Include.NON_NULL)
public class ViewAllUsersResponse extends BaseResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private List<FSEUser> userList;


	public List<FSEUser> getUserList() {
		return userList;
	}


	public void setUserList(List<FSEUser> userList) {
		this.userList = userList;
	}
	
	
	
	
	
	
	
	
	
}
