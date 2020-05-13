package com.cg.hcs.user.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hcs.user.dto.Users;

@SpringBootTest
class TestUserService {
	@Autowired
	UserService userService;
	@Test
    public void testGetUsers_Positive() throws Exception
    {
  	    Optional<Users> users = userService.getUserById("admin");
  	    Assertions.assertEquals(true,users.isPresent());
    }
    @Test
    public void testGetDiagnosticCenter_Negative() throws Exception
    {
    	Optional<Users> users = userService.getUserById("ismi");
  	    Assertions.assertEquals(false,users.isPresent());
    }
	

}
