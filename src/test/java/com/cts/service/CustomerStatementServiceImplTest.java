package com.cts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.dto.RaboResponse;
import com.cts.model.CustomerStatement;
import com.cts.util.CustomerServiceEnum;

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatementServiceImplTest {
	@InjectMocks
	CustomerStatementServiceImpl customerService;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void testSuccessProcessTransactions() { 
		List<CustomerStatement> transactions = Arrays.asList(CustomerStatement.builder()
																			.reference(111l)
																			.accountNumber("1212")
																			.startBalance(10d)
																			.mutation(-5d)
																			.endBalance(5d)
																			.description("Sample")
																			.build());
		RaboResponse response = customerService.processTransactions(transactions);
		assertEquals(CustomerServiceEnum.SUCCESSFUL.toString() ,response.getResult());
	}
	
	@Test
	public void testDuplicateReferenceTransactions() { 
		
		CustomerStatement statement1 = CustomerStatement.builder()
		.reference(111l)
		.accountNumber("1212")
		.startBalance(10d)
		.mutation(-5d)
		.endBalance(5d)
		.description("Duplicate Reference")
		.build();
		
		CustomerStatement statement2 = CustomerStatement.builder()
				.reference(111l)
				.accountNumber("1213")
				.startBalance(10d)
				.mutation(-5d)
				.endBalance(5d)
				.description("Duplicate Reference")
				.build();
		
		
		List<CustomerStatement> transactions = new ArrayList<>();
		transactions.add(statement1);
		transactions.add(statement2);
		RaboResponse response = customerService.processTransactions(transactions);
		assertEquals(CustomerServiceEnum.DUPLICATE_REFERENCE.toString() ,response.getResult());
	}
}
