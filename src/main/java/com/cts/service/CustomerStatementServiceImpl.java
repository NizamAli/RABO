package com.cts.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cts.dto.RaboResponse;
import com.cts.model.CustomerStatement;
import com.cts.model.ErrorRecord;
import com.cts.util.CustomerServiceEnum;
import org.springframework.stereotype.Service;

@Service
public class CustomerStatementServiceImpl implements CustomerStatementService {

	@Override
	public RaboResponse processTransactions(List<CustomerStatement> transactions) {
		RaboResponse response = new RaboResponse();
		Set<Long> references = new HashSet<>();
		List<ErrorRecord> inCorrectBalanceRecords = transactions.stream().filter(cs -> cs.validEndBalance())
				.map(ErrorRecord::new)
				.collect(Collectors.toList());
		List<ErrorRecord> duplicateRefereces = transactions.stream().filter(cs -> !references.add(cs.getReference()))
				.map(ErrorRecord::new)
				.collect(Collectors.toList());
		boolean isDuplicatePresent = false;
		if (!duplicateRefereces.isEmpty()) {
			isDuplicatePresent = true;
			response.getErrorRecords().addAll(duplicateRefereces);
			response.setResult(CustomerServiceEnum.DUPLICATE_REFERENCE.toString());
		}
		if (!inCorrectBalanceRecords.isEmpty()) {
			response.getErrorRecords().addAll(inCorrectBalanceRecords);
			response.setResult(isDuplicatePresent? CustomerServiceEnum.DUPLICATE_REFERENCE_INCORRECT_END_BALANCE.toString(): CustomerServiceEnum.INCORRECT_END_BALANCE.toString());
		}

		return response;
	}

}
