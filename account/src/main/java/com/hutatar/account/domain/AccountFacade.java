package com.hutatar.account.domain;

import static java.util.Objects.requireNonNull;

import com.hutatar.account.dto.AccountDto;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

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

    public AccountDto show(Long id) {
        requireNonNull(id);
        Account account = accountRepository.findOneOrThrow(id);
        return account.dto();
    }

    public void delete(Long... ids) {
        requireNonNull(ids);
        Arrays.stream(ids).forEach(accountRepository::delete);
    }

    public Page<AccountDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return accountRepository
                .findAll(pageable)
                .map(account -> account.dto());
    }
}
