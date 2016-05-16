package com.smartenergy.spring.controller;



import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartenergy.spring.DAO.ConsumerDAO;
import com.smartenergy.spring.pojo.Consumer;



@Controller
@RequestMapping("/AddConsumer.htm")
public class ConsumerController {

	@Autowired
	@Qualifier("consumerValidator")
	ConsumerValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("Consumer") Consumer user, BindingResult result,HttpServletRequest request,HttpServletResponse response) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println("Useeeeee");
			return "AddConsumer";
		}
		System.out.println(user.getAddressLine1());
		ConsumerDAO cdao = new ConsumerDAO();
		try{
		cdao.create(user);
		}catch(Exception e)
		{
			return "Error";
		}
		return "ConsumerDashBoard"; 
	}

	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("Consumer")Consumer user, BindingResult result) { 
        return "AddConsumer"; 
    } 
}
