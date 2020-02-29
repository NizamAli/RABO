package com.cts.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStatement {
    private Long reference;
    private String accountNumber;
    private String description;
    private BigDecimal startBalance;
    private BigDecimal mutation;
    private BigDecimal endBalance;

    public boolean validEndBalance() {
        System.out.println(this.getEndBalance() +" - " + this.getStartBalance() +" !="+ this.getMutation());
        System.out.println(this.getEndBalance().subtract(this.getStartBalance()));
        System.out.println(this.getEndBalance().subtract(this.getStartBalance()).compareTo(this.getMutation()));
        return this.getEndBalance().subtract(this.getStartBalance()).compareTo(this.getMutation()) != 0;
    }

}
