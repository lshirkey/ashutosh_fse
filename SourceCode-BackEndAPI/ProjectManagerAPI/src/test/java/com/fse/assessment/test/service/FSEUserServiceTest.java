package com.fse.assessment.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.assessment.entity.FSEUser;
import com.fse.assessment.model.BaseResponse;
import com.fse.assessment.repo.FSEUserRepo;
import com.fse.assessment.service.FSEUserService;
import com.fse.assessment.service.FSEUserServiceImpl;
import com.fse.assessment.service.response.ViewAllUsersResponse;

@RunWith(SpringRunner.class)
public class FSEUserServiceTest {

	@TestConfiguration
	static class FSEUserServiceImplContextConfiguration {

		@Bean
		public FSEUserService userService() {
			return new FSEUserServiceImpl();
		}
	}

	@Autowired
	private FSEUserService fseUserService;

	@MockBean
	private FSEUserRepo fseUserRepo;

	@Before
	public void setUp() {
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");
		usr.setUserId(1L);

		List<FSEUser> dbUserList = new ArrayList<FSEUser>();
		dbUserList.add(usr);

		Mockito.when(fseUserRepo.findAll()).thenReturn(dbUserList);

		Mockito.when(fseUserRepo.findOne(1L)).thenReturn(usr);

		Mockito.when(fseUserRepo.save(usr)).thenReturn(usr);
		

	}

	// Test Cases
	@Test
	public void getAllUsers_Case1() {
		ViewAllUsersResponse response = fseUserService.getAllUsers();
		assert (response.getUserList().get(0) != null);
		assert (response.getResult().getStatus().equalsIgnoreCase("SUCCESS"));

	}
	
	@Test
	public void getAllUsers_Case2() {
		Mockito.when(fseUserRepo.findAll()).thenReturn(new ArrayList<FSEUser>() );
		ViewAllUsersResponse response = fseUserService.getAllUsers();
		assert (response.getUserList().get(0) != null);
		assert (response.getResult().getStatus().equalsIgnoreCase("SUCCESS"));

	}

	@Test
	public void saveUser_Case1() {
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");
		usr.setUserId(1L);
		
		BaseResponse br = fseUserService.addUser(usr);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

	@Test
	public void updateUser_Case1() {
		FSEUser usr = new FSEUser();
		usr.setFirstName("TestFirstName");
		usr.setLastName("TestLastName");
		usr.setEmployeeId("Testo3400");
		usr.setUserId(1L);
		
		BaseResponse br = fseUserService.updateUser(usr);
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

	@Test
	public void deleteUser_Case1() {
		BaseResponse br = fseUserService.deleteUser("1L");
		assert (br.getResult().getStatus().equalsIgnoreCase("SUCCESS"));
	}

}