package com.smartenergy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AddConsumer.htm")
public class ConsumerController {

	ConsumerController(){
		
		System.out.println("Ho");
	}
}
