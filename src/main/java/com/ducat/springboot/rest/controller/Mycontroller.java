package com.ducat.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot.rest.model.EligibilityRequest;
import com.ducat.springboot.rest.service.RuleEngineConfig;

@RestController
public class Mycontroller {

	@Autowired
	RuleEngineConfig service;

	

	@RequestMapping(value= "/employee/add", method= RequestMethod.POST)
	public EligibilityRequest createEmployee(@RequestBody EligibilityRequest newemp) {
		System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
		return service.eligibilityCheck(newemp);
	}

	
}