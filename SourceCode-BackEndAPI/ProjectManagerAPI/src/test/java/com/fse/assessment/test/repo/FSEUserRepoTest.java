package com.fse.assessment.test.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.repo.FSEUserRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FSEUserRepoTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	FSEUserRepo fseUserRepo;
	
	@Test
	public void findByFirstName_thenReturnFSEUser() {
	    // given
		FSEUser fseUser = new FSEUser();
		//parentTask.setParentTaskId(parentTaskId);
		fseUser.setFirstName("ASHUTOSH");
		fseUser.setLastName("MISHRA");

		
		
	    entityManager.persist(fseUser);
	    entityManager.flush();
	 
	    // when
	    List<FSEUser> found = fseUserRepo.findByFirstName("ASHUTOSH");
	 
	    // then
	    assert(found.get(0).getLastName()).equalsIgnoreCase(fseUser.getLastName());
	}
	
	@Test
	public void whenFindByEmployeeId_thenReturnFSEUser() {
		// given
		FSEUser fseUser = new FSEUser();
		//parentTask.setParentTaskId(parentTaskId);
		fseUser.setFirstName("ASHUTOSH");
		fseUser.setLastName("MISHRA");
		fseUser.setEmployeeId("o3407");
		
		
	    entityManager.persist(fseUser);
	    entityManager.flush();
	 

	    // when
	    List<FSEUser> found = fseUserRepo.findByEmployeeId("o3407");
	 
	    // then
	    assert(found.get(0).getLastName()).equalsIgnoreCase(fseUser.getLastName());
	}
	
	@Test
	public void whenFindByUserId_thenReturnFSEUaser() {
		Long id = 1L;
		
		// given
		FSEUser fseUser = new FSEUser();
		//parentTask.setParentTaskId(parentTaskId);
		fseUser.setFirstName("ASHUTOSH");
		fseUser.setLastName("MISHRA");
		fseUser.setEmployeeId("o3407");
		
		
	    entityManager.persist(fseUser);
	    entityManager.flush();
	 

	    // when
	    FSEUser found = fseUserRepo.findByUserId(id);
	 
	    // then
	    assert(found.getLastName()).equalsIgnoreCase(fseUser.getLastName());
	}
	
	
	
}
