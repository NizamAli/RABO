package com.cts.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class CustomerStatement {
    private Long reference;
    private String accountNumber;
    private String description;
    private Double startBalance;
    private Double mutation;
    private Double endBalance;

    public boolean validEndBalance() {
        return this.getEndBalance() - this.getStartBalance() != this.getMutation();
    }

}
