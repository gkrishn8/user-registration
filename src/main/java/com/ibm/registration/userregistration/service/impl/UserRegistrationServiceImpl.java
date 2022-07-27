package com.ibm.registration.userregistration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.registration.userregistration.model.GeoLocationResponse;
import com.ibm.registration.userregistration.model.UserRequest;
import com.ibm.registration.userregistration.service.UserRegistrationService;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${geo.location}")
	private String geoLocation;

	@Override
	public GeoLocationResponse userRegistration(UserRequest userRequest) {
		
		String location = geoLocation + userRequest.getIpAddress();
		ResponseEntity<GeoLocationResponse> response = restTemplate.getForEntity(location,
				GeoLocationResponse.class);
		
		GeoLocationResponse geoLocationResponse = response.getBody();
		
		return geoLocationResponse;
	}

}
