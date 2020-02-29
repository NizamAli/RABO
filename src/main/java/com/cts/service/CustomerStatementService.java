package com.cts.service;

import java.util.List;

import com.cts.dto.RaboResponse;
import com.cts.model.CustomerStatement;

public interface CustomerStatementService {

	RaboResponse processTransactions(List<CustomerStatement> transactions);

}
