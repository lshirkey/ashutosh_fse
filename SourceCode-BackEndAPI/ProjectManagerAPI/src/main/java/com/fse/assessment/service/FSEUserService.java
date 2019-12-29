package com.fse.assessment.service;

import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.service.response.ViewAllUsersResponse;

public interface FSEUserService {

	ViewAllUsersResponse getAllUsers();

	BaseResponse deleteUser(String userId);

	BaseResponse addUser(FSEUser user);

	BaseResponse updateUser(FSEUser user);

}
