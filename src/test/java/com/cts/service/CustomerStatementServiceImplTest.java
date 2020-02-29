package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.model.CustomerStatement;

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatementServiceImplTest {
	@InjectMocks
	CustomerStatementServiceImpl customerService;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void testProcessTransactions() {
		CustomerStatement cs1 = new CustomerStatement();
		List<CustomerStatement> transactions = new ArrayList<CustomerStatement>();
		transactions.add(cs1);
		customerService.processTransactions(transactions);
	}
}
