package com.ibm.registration.userregistration.service;

import org.springframework.stereotype.Service;

import com.ibm.registration.userregistration.model.GeoLocationResponse;
import com.ibm.registration.userregistration.model.UserRequest;

@Service
public interface UserRegistrationService {
	
	public GeoLocationResponse userRegistration(UserRequest userRequest);

}
