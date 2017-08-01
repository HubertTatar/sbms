package com.hutatar.account.domain;

import com.hutatar.account.domain.AccountNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

interface AccountRepository extends Repository<Account, Long> {
    Page<Account> findAll(Pageable pageable);
    Account save(Account account);
    void delete(Long id);
    Account findOne(Long id);

    default Account findOneOrThrow(Long id){
        Account account = findOne(id);
        if (account == null){
            throw new AccountNotFoundException(id);
        }
        return account;
    }
}
