package com.hutatar.account.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountConfigration {

    AccountFacade accountFacade(){
        InMemoryAccountRepository repo = new InMemoryAccountRepository();
        AccountCreator creator = new AccountCreator();
        return new AccountFacade(repo, creator);
    }

    @Bean
    AccountFacade accountFacade(AccountRepository accountRepository) {
        AccountCreator accountCreator = new AccountCreator();
        return new AccountFacade(accountRepository, accountCreator);
    }

}
