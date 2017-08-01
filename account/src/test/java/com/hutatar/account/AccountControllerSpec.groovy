package com.hutatar.account

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.hutatar.account.domain.AccountFacade
import com.hutatar.account.domain.AccountNotFoundException
import com.hutatar.account.domain.BaseAccountsSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.mock.DetachedMockFactory

@WebMvcTest([AccountController, AccountTestConfig])
class AccountControllerSpec extends BaseAccountsSpec {

    @TestConfiguration
    static class AccountTestConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        AccountFacade accountFacade() {
            return detachedMockFactory.Stub(AccountFacade)
        }
    }

    @Autowired
    AccountFacade accountFacade

    @Autowired
    MockMvc mockMvc

    def "non existing account should return 404"() {
        given:
            accountFacade.show(404) >> {throw new AccountNotFoundException(404)}
        expect:
        mockMvc
            .perform(get("/accounts/404"))
            .andExpect(status().isNotFound())
    }

    def "should list accounts"() {
        given:
            accountFacade.findAll(_) >> {
                Pageable pageable -> new PageImpl([free1, monthly1], pageable, 2)
            }
        when:
            ResultActions getAccounts = mockMvc.perform(get("/accounts"))
        then:
            getAccounts
                .andExpect(status().isOk())
    }
}
