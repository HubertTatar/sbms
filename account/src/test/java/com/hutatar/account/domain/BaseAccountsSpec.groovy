package com.hutatar.account.domain

import com.hutatar.account.dto.AccountDto
import com.hutatar.account.dto.AccountTypeDto
import spock.lang.Specification

class BaseAccountsSpec extends Specification{
    AccountFacade facade = new AccountConfigration().accountFacade()

    AccountDto free1 = createAccount(1L, 'free test', AccountTypeDto.FREE)
    AccountDto contract1 = createAccount(2L, 'contract test', AccountTypeDto.CONTRACT)
    AccountDto monthly1 = createAccount(3L, 'monthly test', AccountTypeDto.MONTHLY)

    private AccountDto createAccount(Long id, String description, AccountTypeDto type) {
        return AccountDto
                .builder()
                .description(description)
                .id(id)
                .type(type)
                .build()
    }
}
