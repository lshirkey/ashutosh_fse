package com.fse.assessment.repo;

import org.springframework.data.repository.CrudRepository;

import com.fse.assessment.entity.FSEParentTask;

public interface FSEParentTaskRepo extends CrudRepository<FSEParentTask, Long> {

	FSEParentTask findByParentTaskId(Long parentTaskIdId);

	FSEParentTask findByParentTaskName(String parentTaskName);
	
	
	
}
