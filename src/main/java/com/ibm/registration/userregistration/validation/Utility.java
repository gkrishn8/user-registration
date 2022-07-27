package com.ibm.registration.userregistration.validation;

import java.util.regex.Pattern;

public class Utility {
	
	
	public static boolean isValid(String passwordhere) {

	    Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");

	    boolean flag=true;
	    
	    if (!specailCharPatten.matcher(passwordhere).find()) {
	        flag=false;
	    }
	    else if (!UpperCasePatten.matcher(passwordhere).find()) {
	        flag=false;
	    }
	    else if (!digitCasePatten.matcher(passwordhere).find()) {
	        flag=false;
	    }

	    return flag;

	}

}
