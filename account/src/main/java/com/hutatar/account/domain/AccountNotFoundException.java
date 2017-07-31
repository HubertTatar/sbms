package com.hutatar.account.domain;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super(String.format("No account with id: %s", id), null, Boolean.FALSE, Boolean.FALSE);
    }
}
