package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.CustomerStatement;
import com.cts.service.CustomerStatementService;



@RestController
public class CustomersStatementController {
	
	@Autowired
	private CustomerStatementService customerStatementService;

	/**
	 * . 
	 *
	 * @param  List<CustomerStatement>  

	 * @return  
	 */
	
	
	@PostMapping(value = "/statement")
	public ResponseEntity createCustomer(@RequestBody List<CustomerStatement> transactions) {

		customerStatementService.processTransactions(transactions);
		
		return null;
	}


}
