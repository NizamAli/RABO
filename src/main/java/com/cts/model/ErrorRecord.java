package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorRecord {
    private Long reference;
    private String accountNumber;

    public ErrorRecord(CustomerStatement cs) {
        this.reference = cs.getReference();
        this.accountNumber = cs.getAccountNumber();
    }
}
