package com.smartenergy.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.smartenergy.spring.pojo.Localenergyvendor;
import com.smartenergy.spring.pojo.Useraccount;

public class LocalVendorValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println("LocalEnergy Validator");
		return clazz.equals(Localenergyvendor.class);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "localEnergyVendorName", "error.invalid.user", "Vendor Name Required");

		
	}

	

}
