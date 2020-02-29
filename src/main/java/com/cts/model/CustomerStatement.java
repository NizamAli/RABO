package com.cts.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerStatement {
    private Long reference;
    private String accountNumber;
    private String description;
    private Double startBalance;
    private Double mutation;
    private Double endBalance;

    public boolean validEndBalance() {
        System.out.println(this.getEndBalance() +" - " + this.getStartBalance() +" !="+ this.getMutation());
        System.out.println(this.getEndBalance() - this.getStartBalance());
        return this.getEndBalance() - this.getStartBalance() != this.getMutation();
    }

}
