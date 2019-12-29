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

import com.fse.assessment.entity.FSEParentTask;
import com.fse.assessment.entity.FSEProject;
import com.fse.assessment.entity.FSETask;
import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.model.FSETaskDTO;
import com.fse.assessment.repo.FSEParentTaskRepo;
import com.fse.assessment.repo.FSEProjectRepo;
import com.fse.assessment.repo.FSETaskRepo;
import com.fse.assessment.repo.FSEUserRepo;
import com.fse.assessment.service.FSETaskService;
import com.fse.assessment.service.FSETaskServiceImpl;
import com.fse.assessment.service.response.ViewAllTasksResponse;

@RunWith(SpringRunner.class)
public class FSETaskServiceTest {
	@TestConfiguration
	static class FSETaskServiceImplContextConfiguration {

		@Bean
		public FSETaskService taskService() {
			return new FSETaskServiceImpl();
		}
	}

	@Autowired
	private FSETaskService fseTaskService;

	@MockBean
	private FSETaskRepo fseTaskRepo;

	@MockBean
	private FSEParentTaskRepo fseParentTaskRepo;

	@MockBean
	private FSEUserRepo fseUserRepo;

	@MockBean
	private FSEProjectRepo fseProjectRepo;

	@Before
	public void setUp() {
		List<FSETask> dbTaskList = new ArrayList<FSETask>();
		List<FSEParentTask> dbParentTaskList = new ArrayList<FSEParentTask>();

		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");
		usr.setUserId(1L);

		FSEProject project = new FSEProject();
		project.setProjectName("FSETest");
		project.setManager(usr);
		project.setPriority(5);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setProjectId(1L);
		Mockito.when(fseProjectRepo.save(project)).thenReturn(project);

		FSETask task = new FSETask();
		task.setTaskId(1L);
		task.setPriority(5);
		task.setTaskName("TestTask");
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setTaskOwner(usr);
		task.setProject(project);
		dbTaskList.add(task);
		
		
		
		FSEParentTask pTask = new FSEParentTask();
		pTask.setParentTaskId(1L);
		pTask.setParentTaskName("TestParent");
		
		dbParentTaskList.add(pTask);
		
		Mockito.when(fseParentTaskRepo.findAll()).thenReturn(dbParentTaskList);
		Mockito.when(fseTaskRepo.findAll()).thenReturn(dbTaskList);
		Mockito.when(fseTaskRepo.findOne(1L)).thenReturn(task);
		Mockito.when(fseTaskRepo.save(task)).thenReturn(task);

	}

	// Test Cases
	@Test
	public void getAllTasks_Case1() {
		ViewAllTasksResponse response = fseTaskService.getAllTasks();
		assert (response.getTaskList().get(0) != null);

	}
	
	@Test
	public void getAllParentTasks_Case1() {
		ViewAllTasksResponse response = fseTaskService.getAllParentTasks();
		assert (response.getTaskList().get(0) != null);

	}
	

	@Test
	public void saveTask_Case1() {
		FSETaskDTO task = new FSETaskDTO();
		task.setTaskId("1L");
		task.setPriority(5);
		task.setTask("TestTask");
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		
		BaseResponse br = fseTaskService.addTask(task);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}
	
	@Test
	public void saveTask_Case2() {
		FSETaskDTO task2 = new FSETaskDTO();
		task2.setParentTaskEnabled(true);
		task2.setTask("TestParentTask");
		
		BaseResponse br = fseTaskService.addTask(task2);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}
	
	

	@Test
	public void updateTask_Case1() {
		FSETaskDTO task = new FSETaskDTO();
		task.setTaskId("1L");
		task.setPriority(5);
		task.setTask("TestTask");
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		
		BaseResponse br = fseTaskService.updateTask(task);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}
	
	@Test
	public void deleteTask_Case1() {
		BaseResponse br = fseTaskService.deleteTask("1L");
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

	// Test Cases

}
