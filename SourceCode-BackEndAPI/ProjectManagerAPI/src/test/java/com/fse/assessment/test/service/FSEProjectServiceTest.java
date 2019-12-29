package com.fse.assessment.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.assessment.entity.FSEProject;
import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSEProjectDTO;
import com.fse.assessment.repo.FSEProjectRepo;
import com.fse.assessment.repo.FSEUserRepo;
import com.fse.assessment.service.FSEProjectService;
import com.fse.assessment.service.FSEProjectServiceImpl;
import com.fse.assessment.service.response.ViewAllProjectsResponse;

@RunWith(SpringRunner.class)
public class FSEProjectServiceTest {
	@TestConfiguration
	static class FSEProjectServiceImplContextConfiguration {

		@Bean
		public FSEProjectService projectService() {
			return new FSEProjectServiceImpl();
		}
	}

	@Autowired
	private FSEProjectService fseProjectService;

	@MockBean
	private FSEProjectRepo fseProjectRepo;

	@MockBean
	private FSEUserRepo fseUserRepo;

	// Test Cases
	@Before
	public void setUp() {
		List<FSEProject> dbProjectList = new ArrayList<FSEProject>();
		
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");
		usr.setUserId(1L);

		FSEProject project = new FSEProject();
		project.setProjectName("FSETest");
		project.setManager(usr);
		project.setPriority(15);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setProjectId(2L);
		
		dbProjectList.add(project);

		Mockito.when(fseProjectRepo.save(project)).thenReturn(project);
		Mockito.when(fseProjectRepo.findAll()).thenReturn(dbProjectList);

	}

	// Test Cases
	@Test
	public void getAllProjects_Case1() {
		ViewAllProjectsResponse response = fseProjectService.getAllProjects();
		assert (response.getProjectList().get(0) != null);

	}

	@Test
	public void saveProject_Case1() {
		//
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");

		FSEProjectDTO project = new FSEProjectDTO();
		project.setProjectName("FSETest");
		project.setUserId("1");
		project.setPriority(15);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		//
		// FSEProjectDTO project =new FSEProjectDTO();
		BaseResponse br = fseProjectService.addProject(project);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

	@Test
	public void updateProject_Case1() {
		//
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");

		FSEProjectDTO project = new FSEProjectDTO();
		project.setProjectName("FSETest");
		project.setUserId("1");
		project.setPriority(15);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		//
		// FSEProjectDTO project =new FSEProjectDTO();
		BaseResponse br = fseProjectService.updateProject(project);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

	// Test Cases

}
