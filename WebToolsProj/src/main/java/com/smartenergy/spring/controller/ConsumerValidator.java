package com.smartenergy.spring.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.smartenergy.spring.pojo.Consumer;

public class ConsumerValidator implements Validator {

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Consumer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Consumer newConsumer = (Consumer) target;
		String zip=newConsumer.getZip();
		//Zip Validation 
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(zip);
		if(matcher.matches())
		{
		}
		else{
			errors.rejectValue("zip", "error.invalid.user",  
				      "Enter a valid zip"); 
		}
		
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(newConsumer.getEmail());
        if(m.matches())
        {
        	
        }else
        {
        	errors.rejectValue("email", "error.invalid.user",  
				      "Enter a valid email");	
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmpty(errors, "addressLine1", "error.invalid.user", "Address Line1 Required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.user", "State Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.user", "City Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.user", "Zip Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
		
	}


}
