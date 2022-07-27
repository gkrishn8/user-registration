package com.ibm.registration.userregistration.validation;

import java.util.regex.Pattern;

public class Utility {

	public static boolean isValid(String password) {

		boolean flag = true;

		Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#@$?]).{8,}$");

		if (!passwordPattern.matcher(password).find()) {
			flag = false;
		}

		return flag;

	}


}
