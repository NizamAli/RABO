package com.cts.controller;

import java.util.List;

import com.cts.dto.RaboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.CustomerStatement;
import com.cts.model.ErrorRecord;
import com.cts.service.CustomerStatementService;
import com.cts.util.*;import lombok.Builder;

import java.util.*;

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
		RaboResponse response = null;
		if(transactions.isEmpty()) {
			response = new RaboResponse();
			response.setResult(CustomerServiceEnum.BAD_REQUEST.toString());
			response.setErrorRecords(new ArrayList<ErrorRecord>());
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

		}
        response = customerStatementService.processTransactions(transactions);
        return new ResponseEntity(response, HttpStatus.OK);
	}




}
