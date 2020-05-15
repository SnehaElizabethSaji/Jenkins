package com.cg.hcs;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.Doctor;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	@LocalServerPort
	int localServerPort;
	//get centers
	@Test
	public void testGetDiagnosticCenter_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getDiagnosticcenter/5";
		ResponseEntity<DiagnosticCenter> diagnosticCenter=testRestTemplate.getForEntity(url, DiagnosticCenter.class);
		Assertions.assertEquals(200,diagnosticCenter.getStatusCodeValue() );
	}
	@Test
	public void testGetDiagnosticCenter_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getDiagnosticcenter/20";
		ResponseEntity<DiagnosticCenter> diagnosticCenter=testRestTemplate.getForEntity(url, DiagnosticCenter.class);
		Assertions.assertEquals(404,diagnosticCenter.getStatusCodeValue() );
	}
/*	@Test
	public void testGetDiagnosticCenters_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getDiagnosticcenters";
		ResponseEntity<DiagnosticCenter> diagnosticCenter=testRestTemplate.getForEntity(url, DiagnosticCenter.class);
		Assertions.assertEquals(200,diagnosticCenter.getStatusCodeValue() );
	
	}*/
    //delete center
	@Test
	public void testDeleteDiagnosticCenterDetails_Positive() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"deleteDiagnosticcenter/10";
		 HttpEntity<Integer> ent = new HttpEntity<>(10);
		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testDeleteDiagnosticCenterDetails_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"deleteDiagnosticcenter/103";
		 HttpEntity<Integer> ent = new HttpEntity<>(103);
		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(500, response.getStatusCodeValue());
	}

	//delete test center
	@Test
	public void testDeleteTestCenterDetails_Positive() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"deleteTestCenter/7";
		 HttpEntity<Integer> ent = new HttpEntity<>(7);
		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testDeleteTestCenterDetails_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"deleteTestCenter/7";
		 HttpEntity<Integer> ent = new HttpEntity<>(7);
		  ResponseEntity<String> response = testRestTemplate.exchange(url,HttpMethod.DELETE,null,String.class);
		 Assertions.assertEquals(500, response.getStatusCodeValue());
	}
	//tests
	@Test
	public void testGetTests_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getTest/101";
		ResponseEntity<com.cg.hcs.dto.Test> test=testRestTemplate.getForEntity(url, com.cg.hcs.dto.Test.class);
		Assertions.assertEquals(200,test.getStatusCodeValue() );
	}
	
	@Test
	public void testGetTests_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getTest/98";
		ResponseEntity<com.cg.hcs.dto.Test> test=testRestTemplate.getForEntity(url, com.cg.hcs.dto.Test.class);
		Assertions.assertEquals(404,test.getStatusCodeValue() );
	}
	
	//doctor
	@Test
	public void testGetDoctor_Positive() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getDoctor/5";
		ResponseEntity<Doctor> doctor=testRestTemplate.getForEntity(url, Doctor.class);
		Assertions.assertEquals(200,doctor.getStatusCodeValue() );
	}
	@Test
	public void testGetDoctor_Negative() throws Exception
	{
		String url="http://localhost:"+localServerPort+"getDoctor/20";
		ResponseEntity<Doctor> doctor=testRestTemplate.getForEntity(url, Doctor.class);
		Assertions.assertEquals(404,doctor.getStatusCodeValue() );
	}
	
	

	


}
