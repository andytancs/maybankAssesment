package com.maybank.maybankassesment.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserProfileSavingWithdrawDto {

    private String name;
    private String password;
    private BigDecimal amount;
}
