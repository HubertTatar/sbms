package com.hutatar.account.domain;

import static java.util.Objects.requireNonNull;

import com.hutatar.account.dto.AccountDto;
import lombok.extern.java.Log;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Log
public class AccountFacade {
    private AccountRepository accountRepository;
    private AccountCreator accountCreator;

    public AccountFacade(AccountRepository accountRepository, AccountCreator accountCreator) {
        this.accountRepository = accountRepository;
        this.accountCreator = accountCreator;
    }

    public AccountDto add(AccountDto accountDto) {
        requireNonNull(accountDto);
        Account account = accountCreator.from(accountDto);
        account = accountRepository.save(account);
        return account.dto();
    }
}
