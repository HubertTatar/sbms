package com.hutatar.account.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class AccountDto {
    private Long id;
    private String description;
    private AccountTypeDto type;
}
