package com.smartenergy.spring.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartenergy.spring.DAO.LocalEnergyVendorDAO;
import com.smartenergy.spring.pojo.Localenergyvendor;

@Controller
@RequestMapping("/CreateLocalVendor.htm")
public class LocalVendorController {
	@Autowired
	@Qualifier("localVendorValidator")
	LocalVendorValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("Localenergyvendor") Localenergyvendor lev, BindingResult result) throws Exception {
		validator.validate(lev, result);
		if (result.hasErrors()) {
			System.out.println("LocalVendor");
			 
			return "CreateLocalVendor";
		}
	
      
        String levname=lev.getLocalEnergyVendorName();
        String levdesc=lev.getLocalEnergyVendorDescription();
        LocalEnergyVendorDAO levDAO=new LocalEnergyVendorDAO();
        try{
        levDAO.create(levname, levdesc);
        }
        catch(Exception e)
        {
        	return "Error";
        }
		System.out.println(lev.getLocalEnergyVendorName());
		
		return "LevDashboard";
	}

	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("Localenergyvendor")Localenergyvendor user, BindingResult result) { 
		System.out.println("Hiiii");
        return "CreateLocalVendor"; 
    } 
}
