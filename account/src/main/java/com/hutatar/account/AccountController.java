package com.hutatar.account;

import com.hutatar.account.domain.AccountFacade;
import com.hutatar.account.dto.AccountDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class AccountController {

    private AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @GetMapping("accounts")
    Page<AccountDto> getAccounts(Pageable pageable) {
        return accountFacade.findAll(pageable);
    }

    @GetMapping("accounts/{id}")
    @Cacheable("accounts")
    public AccountDto getAccount(@PathVariable Long id) {
        return accountFacade.show(id);
    }

    @PostMapping("accounts")
    AccountDto postAccount(@RequestBody AccountDto accountDto) {
        return accountFacade.add(accountDto);
    }

    @DeleteMapping("accounts/{id}")
    ResponseEntity delete(@PathVariable Long id) {
        accountFacade.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
