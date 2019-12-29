package com.fse.assessment.test.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.assessment.entity.FSEParentTask;
import com.fse.assessment.repo.FSEParentTaskRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParentTaskRepoTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	FSEParentTaskRepo fseParentTaskRepo;
	
	@Test
	public void whenFindByName_thenReturnParentTask() {
	    // given
		FSEParentTask parentTask = new FSEParentTask();
		//parentTask.setParentTaskId(parentTaskId);
		parentTask.setParentTaskName("PARENT");
		
		
	    entityManager.persist(parentTask);
	    entityManager.flush();
	 
	    // when
	    FSEParentTask found = fseParentTaskRepo.findByParentTaskName("PARENT");
	 
	    // then
	    assert(found.getParentTaskName()).equalsIgnoreCase(parentTask.getParentTaskName());
	}
	
	@Test
	public void whenFindById_thenReturnParentTask() {
		Long id = 1L;
		
	    // given
		FSEParentTask parentTask = new FSEParentTask();
		//parentTask.setParentTaskId(parentTaskId);
		parentTask.setParentTaskName("PARENT2");
		
		
	    entityManager.persist(parentTask);
	    entityManager.flush();
	 
	    // when
	    FSEParentTask found = fseParentTaskRepo.findByParentTaskId(id);
	 
	    // then
	    assert(found.getParentTaskName()).equalsIgnoreCase(parentTask.getParentTaskName());
	}
	
}
