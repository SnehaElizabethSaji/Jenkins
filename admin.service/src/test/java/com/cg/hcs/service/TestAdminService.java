package com.cg.hcs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.Doctor;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TestAdminService
{
	@Autowired
	DiagnosticcenterService diagnosticcenterService;
	@Autowired
	DoctorService doctorService; 
	@Autowired
	TestService testService; 
    
    
    @Test
    public void testGetDiagnosticCenter_Positive() throws Exception
    {
  	    Optional<DiagnosticCenter> diagnosticCenter = diagnosticcenterService.getDiagnosticcenter(5);
  	    Assertions.assertEquals(true,diagnosticCenter.isPresent());
    }
    @Test
    public void testGetDiagnosticCenter_Negative() throws Exception
    {
  	    Optional<DiagnosticCenter> diagnosticCenter = diagnosticcenterService.getDiagnosticcenter(19);
  	    Assertions.assertEquals(false,diagnosticCenter.isPresent());
    }
    @Test
    public void testGetDoctor_Positive() throws Exception
    {
  	    Optional<Doctor> doctor = doctorService.getDoctor(8989);
  	    Assertions.assertEquals(true,doctor.isPresent());
    }
    @Test
    public void testGetDoctor_Negative() throws Exception
    {
    	Optional<Doctor> doctor = doctorService.getDoctor(190);
  	    Assertions.assertEquals(false,doctor.isPresent());
    }
    @Test
    public void testGetTest_Positive() throws Exception
    {
  	    Optional<com.cg.hcs.dto.Test> test = testService.getTest(101);
  	    Assertions.assertEquals(true,test.isPresent());
    }
    @Test
    public void testGetTest_Negative() throws Exception
    {
    	Optional<com.cg.hcs.dto.Test> test = testService.getTest(98);
  	    Assertions.assertEquals(false,test.isPresent());
    }
    
}
