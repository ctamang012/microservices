package com.ctech.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ctech.microservice.currencyexchangeservice.model.ExchangeValue;
import com.ctech.microservice.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepository repository;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		
		ExchangeValue findByFromAndTo = repository.findByFromAndTo(from, to);
		
		
		findByFromAndTo.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return findByFromAndTo;
	}
}
