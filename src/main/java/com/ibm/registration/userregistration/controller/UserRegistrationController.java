package com.ibm.registration.userregistration.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.registration.userregistration.model.GeoLocationResponse;
import com.ibm.registration.userregistration.model.UserRequest;
import com.ibm.registration.userregistration.service.UserRegistrationService;
import com.ibm.registration.userregistration.validation.Utility;

import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/v1")
@RestController
@Tag(name = " User Registration")
public class UserRegistrationController {
	
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	
	@PostMapping("/registration")
	public String createUser(@Valid @RequestBody UserRequest userRequest) {
		
		boolean isPwdValid = Utility.isValid(userRequest.getPassword());
		
		if(!isPwdValid) {
			return "password is invalid";
		}
		
		System.out.print("userRequest : "+userRequest);
		
		  GeoLocationResponse geolocation = userRegistrationService.userRegistration(userRequest);
		  
		 if (geolocation != null && geolocation.getCountry()!= null && 
				 geolocation.getCountry().equalsIgnoreCase("Canada")) {
			 
			 return "Welcome "+ userRequest.getUserName() + ", you have registered from "+ 
			 geolocation.getCity() + " city and your registraion Id is: "+ UUID.randomUUID();
			 
		 }else {
			 
			 return "User is not eligible to register!";
		 }
		 
		
	}

}
