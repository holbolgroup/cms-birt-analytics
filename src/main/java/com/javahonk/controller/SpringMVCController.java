package com.javahonk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCController {
	
	@RequestMapping(value="/angularJS",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		System.out.println("Inside printWelcome controller method");
		return "angularJS";
	}
	
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String viewReports(ModelMap model) {
		System.out.println("Inside viewReports controller method");
		return "birtView";
	}
	
	
	@RequestMapping(value="/springAngularJS", 
			method=RequestMethod.GET,
			produces={"application/xml", "application/json"})
    public @ResponseBody Person  getPerson() {		
		Person person = new Person();
		person.setFirstName("Java");
		person.setLastName("Honk");
		return person;
	}
}