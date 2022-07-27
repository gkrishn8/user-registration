package com.ibm.registration.userregistration.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.registration.userregistration.model.GeoLocationResponse;
import com.ibm.registration.userregistration.model.UserRequest;
import com.ibm.registration.userregistration.service.UserRegistrationService;

@SpringBootTest
public class UserRegistrationControllerTest {

	@InjectMocks
	UserRegistrationController userRegistrationController;

	@Mock
	UserRegistrationService userRegistrationService;

	@Test
	public void testCreateUser() {

		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("John");
		userRequest.setPassword("testuser123");
		userRequest.setIpAddress("10.24.63.44");

		GeoLocationResponse geoLocationResponse = new GeoLocationResponse();
		geoLocationResponse.setCountry("Canada");
		geoLocationResponse.setCity("Montreal");

		Mockito.when(userRegistrationService.userRegistration(userRequest)).thenReturn(geoLocationResponse);

		String responsedata = userRegistrationController.createUser(userRequest);

		assertNotNull(responsedata);

	}

}
