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
import java.math.BigDecimal;


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
																			.startBalance(new BigDecimal("123"))
																			.mutation(new BigDecimal("123"))
																			.endBalance(new BigDecimal("123"))
																			.description("Sample")
																			.build());
		RaboResponse response = customerService.processTransactions(transactions);
		assertEquals(CustomerServiceEnum.SUCCESSFUL.toString() ,response.getResult());
	}
	
	@Test
	public void testDuplicateReferenceTransactions() { 
		
		BigDecimal startBalance = new BigDecimal("123");
		BigDecimal mutationBalance = new BigDecimal("123");

		BigDecimal endBalance = new BigDecimal("123");

		
		CustomerStatement statement1 = CustomerStatement.builder()
		.reference(111l)
		.accountNumber("1212")
		.startBalance(startBalance)
		.mutation(mutationBalance)
		.endBalance(endBalance)
		.description("Duplicate Reference")
		.build();
		
		CustomerStatement statement2 = CustomerStatement.builder()
				.reference(111l)
				.accountNumber("1213")
				.startBalance(startBalance)
				.mutation(mutationBalance)
				.endBalance(endBalance)
				.description("Duplicate Reference")
				.build();
		
		
		List<CustomerStatement> transactions = new ArrayList<>();
		transactions.add(statement1);
		transactions.add(statement2);
		RaboResponse response = customerService.processTransactions(transactions);
		assertEquals(CustomerServiceEnum.DUPLICATE_REFERENCE.toString() ,response.getResult());
	}
	
	
}
