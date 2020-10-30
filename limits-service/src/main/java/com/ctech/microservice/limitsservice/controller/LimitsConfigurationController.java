package com.ctech.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctech.microservice.limitsservice.Configuration;
import com.ctech.microservice.limitsservice.model.LimitConfigurataion;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	Configuration configuration; 

	@GetMapping("/limits")
	public LimitConfigurataion retrieveLimitsFromConfiguration() {
		return new LimitConfigurataion(configuration.getMaximum(), configuration.getMinimum());
	}
}
