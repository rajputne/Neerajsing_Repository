/**
 * 
 */
package com.smartenergy.spring.controller;

/**
 * @author neera
 *
 */
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

import com.smartenergy.spring.DAO.GlobalEnergyVendorDAO;
import com.smartenergy.spring.pojo.Globalenergyvendor;



@Controller
@RequestMapping("AddGlobalEnergy.htm")
public class GlobalEnergyVendorController {
	@Autowired
	@Qualifier("globalEnergyValidator")
	GlobalEnergyValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("Globalenergyvendor") Globalenergyvendor user, BindingResult result) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("Globalss");
			return "AddGlobalEnergy";
		}
        GlobalEnergyVendorDAO gevdao=new GlobalEnergyVendorDAO();
        try{
        gevdao.create(user);
        }
        catch(Exception e)
        {
        	return "Error";
        }
		return "GevDashboard";
		
	}

	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("Globalenergyvendor") Globalenergyvendor user, BindingResult result) {
		System.out.println("Global");
        return "AddGlobalEnergy"; 
    } 

}
