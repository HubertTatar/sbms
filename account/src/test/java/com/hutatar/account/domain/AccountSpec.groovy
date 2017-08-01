package com.hutatar.account.domain

import com.hutatar.account.dto.AccountDto
import org.junit.After
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class AccountSpec extends BaseAccountsSpec {

    @After
    def "remove"() {
        facade.delete(free1.id, monthly1.id, contract1.id)
    }

    def "add"() {
        when:
            facade.add(free1)
        then:
            facade.show(free1.id) == free1
    }

    def "list"() {
        given: "two accounts"
            facade.add(free1)
            facade.add(monthly1)
            facade.add(contract1)
        when:
            Page<AccountDto> all = facade.findAll(new PageRequest(0, 10))
        then:
            all.contains(free1)
            all.contains(monthly1)
            all.contains(contract1)
    }


}
