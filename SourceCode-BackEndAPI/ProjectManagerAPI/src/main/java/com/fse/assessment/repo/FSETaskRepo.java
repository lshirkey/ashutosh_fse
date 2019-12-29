package com.fse.assessment.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fse.assessment.entity.FSETask;
import com.fse.assessment.entity.FSEUser;

public interface FSETaskRepo extends CrudRepository<FSETask, Long> {

	List<FSEUser> findByTaskId(String userId);

	List<FSEUser> findByTaskName(String taskName);
	
	List<FSEUser> findByStartDate(String startDate);
	
	List<FSEUser> findByEndDate(String endDate);
	
	List<FSEUser> findByPriority(String priority);
	
	List<FSEUser> findByStatus(String status);
	
}
