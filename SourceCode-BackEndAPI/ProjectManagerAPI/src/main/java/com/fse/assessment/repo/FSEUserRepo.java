package com.fse.assessment.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fse.assessment.entity.FSEUser;

public interface FSEUserRepo extends CrudRepository<FSEUser, Long> {

	FSEUser findByUserId(Long userId);

	List<FSEUser> findByFirstName(String firstName);
	
	List<FSEUser> findByEmployeeId(String employeeId);

}
