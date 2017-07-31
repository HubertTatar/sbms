package com.hutatar.account.domain;

import static java.util.Objects.requireNonNull;

import com.hutatar.account.dto.AccountDto;

class AccountCreator {
    Account from(AccountDto accountDto){
        requireNonNull(accountDto);
        return Account
                .builder()
                .id(accountDto.getId())
                .description(accountDto.getDescription())
                .accountType(AccountType.valueOf(accountDto.getType().name()))
                .build();
    }
}
