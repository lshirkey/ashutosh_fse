package com.fse.assessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.assessment.common.ApplicationException;
import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.BaseResult;
import com.fse.assessment.repo.FSEUserRepo;
import com.fse.assessment.service.response.ViewAllUsersResponse;

@Service
public class FSEUserServiceImpl implements FSEUserService{
	
	@Autowired
	FSEUserRepo fseUserRepo;

	@Override
	public ViewAllUsersResponse getAllUsers() {
		
		//Build Response
		ViewAllUsersResponse response = new ViewAllUsersResponse();
		
		try{
			List<FSEUser> dbUserList = new ArrayList<FSEUser>();
			fseUserRepo.findAll().forEach(user->dbUserList.add(user));
			if(!dbUserList.isEmpty()){
				response.setResult(new BaseResult());
				response.setUserList(dbUserList);
			}else{
				throw new ApplicationException();
			}
			
			
		}catch(ApplicationException ae){
			response.setResult(new BaseResult(ae));
		}catch(Exception e){
			response.setResult(new BaseResult(e));
		}finally{
			
		}
		
		return response;
	}

	@Override
	public BaseResponse deleteUser(String userId) {
		BaseResponse response = new BaseResponse();
		try{
			fseUserRepo.delete(Long.valueOf(userId));
			response.setResult(new BaseResult());
			
		}catch(Exception e){
			response.setResult(new BaseResult(e));
		}finally{
			
		}
		return response;
	}

	@Override
	public BaseResponse addUser(FSEUser user) {
		BaseResponse response = new BaseResponse();
		try{
			fseUserRepo.save(user);
			response.setResult(new BaseResult());
			
		}catch(Exception e){
			response.setResult(new BaseResult(e));
		}finally{
			
		}
		return response;
	}

	@Override
	public BaseResponse updateUser(FSEUser user) {
		
		BaseResponse response = new BaseResponse();
		try{
			FSEUser fseUser = fseUserRepo.findOne(Long.valueOf(user.getUserId()));
			if(fseUser==null){
				throw new ApplicationException();//TODO
			}else{
				fseUser.setEmployeeId(user.getEmployeeId());
				fseUser.setFirstName(user.getFirstName());
				fseUser.setLastName(user.getLastName());
				
				fseUserRepo.save(fseUser);
			}
			response.setResult(new BaseResult());
			
		}catch(ApplicationException ae){
			response.setResult(new BaseResult(ae));
		}catch(Exception e){
			response.setResult(new BaseResult(e));
		}finally{
			
		}
		return response;
		
	}

}
