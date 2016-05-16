package com.smartenergy.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.smartenergy.spring.pojo.Globalenergyvendor;

public class GlobalEnergyValidator implements Validator{
	
	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Globalenergyvendor.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "globalEnergyVendorName", "error.invalid.user", "Vendor Name Required");
		
	}

}
