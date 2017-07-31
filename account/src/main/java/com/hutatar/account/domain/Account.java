package com.hutatar.account.domain;

import com.hutatar.account.dto.AccountDto;
import com.hutatar.account.dto.AccountTypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private AccountType accountType;
    private String description;

    AccountDto dto() {
        return AccountDto
                .builder()
                .id(id)
                .type(AccountTypeDto.valueOf(accountType.name()))
                .description(description)
                .build();
    }

}
