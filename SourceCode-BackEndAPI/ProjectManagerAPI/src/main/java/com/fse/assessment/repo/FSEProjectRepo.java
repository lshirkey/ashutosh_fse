package com.fse.assessment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fse.assessment.entity.FSEProject;
import com.fse.assessment.entity.FSETask;

public interface FSEProjectRepo extends CrudRepository<FSEProject, Long> {

	FSEProject findByProjectId(Long projectId);

	/*List<FSEProject> findByProjectName(String projectName);
	
	List<FSEProject> findByStartDate(String startDate);
	
	List<FSEProject> findByEndDate(String endDate);
	
	List<FSEProject> findByPriority(String priority);*/

	@Query(value="SELECT * FROM FSE_TASK t WHERE t.PROJECT_ID = ?1", nativeQuery=true)
	List<FSETask> getAllTasksByProjectId(long projectId);
	
	
	
	
	

}
