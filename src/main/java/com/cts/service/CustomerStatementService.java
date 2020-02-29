package com.cts.service;

import java.util.List;

import com.cts.model.CustomerStatement;

public interface CustomerStatementService {

	void processTransactions(List<CustomerStatement> transactions);

}
