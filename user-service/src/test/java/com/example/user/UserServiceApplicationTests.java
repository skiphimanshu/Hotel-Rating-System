package com.example.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.entities.User;
import com.example.user.service.UserService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void testCreate() {
		
		User user  = new  User();
		user.setName("Tree");
		user.setEmail("ks@gmail.com");
		user.setAbout("Ahhs");
		userService.saveUser(user);
		assertNotNull(user);
		
	}

}
