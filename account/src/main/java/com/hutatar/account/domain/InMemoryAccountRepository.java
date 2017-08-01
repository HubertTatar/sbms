package com.hutatar.account.domain;

import static java.util.Objects.requireNonNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepository implements AccountRepository {

    private ConcurrentHashMap<Long, Account> map = new ConcurrentHashMap<>();

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    @Override
    public Account save(Account account) {
        requireNonNull(account);
        map.put(account.dto().getId(), account);
        return account;
    }

    @Override
    public void delete(Long id) {
        map.remove(id);
    }

    @Override
    public Account findOne(Long id) {
        return map.get(id);
    }

    @Override
    public Account findOneOrThrow(Long id) {
        return map.get(id);
    }
}
