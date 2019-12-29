package com.fse.assessment.test.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.assessment.entity.FSEProject;
import com.fse.assessment.repo.FSEProjectRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FSEProjectRepoTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	FSEProjectRepo fseProjectRepo;
	
	@Test
	public void whenFindByProjectId_thenReturnFSEProject() {
		Long id = 1L;
		
		// given
		FSEProject fseProject = new FSEProject();
		//parentTask.setParentTaskId(parentTaskId);
		fseProject.setProjectName("FSE");
		fseProject.setPriority(15);
		
	    entityManager.persist(fseProject);
	    entityManager.flush();
	 

	    // when
	    FSEProject found = fseProjectRepo.findByProjectId(id);
	 
	    // then
	    assert(found.getPriority()==fseProject.getPriority());
	}
	
	
	
}
