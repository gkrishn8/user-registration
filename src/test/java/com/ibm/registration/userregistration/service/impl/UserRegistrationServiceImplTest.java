package com.ibm.registration.userregistration.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ibm.registration.userregistration.model.GeoLocationResponse;
import com.ibm.registration.userregistration.model.UserRequest;

@SpringBootTest
public class UserRegistrationServiceImplTest {
	
	
	@InjectMocks
	UserRegistrationServiceImpl userRegistrationServiceImpl;
	
	@Mock
	RestTemplate restTemplate;
	
	
	@Test
	public void testUserRegistration() {
		
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("test");
		userRequest.setPassword("testuser123");
		userRequest.setIpAddress("10.24.63.44");
		
		GeoLocationResponse geoLocationResponse = new GeoLocationResponse();
		geoLocationResponse.setCountry("Canada");
		geoLocationResponse.setCity("Montreal");
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(geoLocationResponse, HttpStatus.OK);
		
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(),
				Mockito.any())).thenReturn(response);
		
	GeoLocationResponse responsedata	= userRegistrationServiceImpl.userRegistration(userRequest);
	
	assertEquals("Canada", responsedata.getCountry());
		
	}

}
