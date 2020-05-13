package com.cg.hcs.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.hcs.user.dto.Users;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	@LocalServerPort
	int localServerPort;

    //users
	@Test
	public void testGetUsers_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"/login/admin/admin";
		ResponseEntity<Users> users=testRestTemplate.getForEntity(url, Users.class);
		Assertions.assertEquals(200,users.getStatusCodeValue() );
	}
	@Test
	public void testGetUsers_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"/login/ismi/ismi";
		ResponseEntity<Users> users=testRestTemplate.getForEntity(url, Users.class);
		Assertions.assertEquals(404,users.getStatusCodeValue() );
	}

}
