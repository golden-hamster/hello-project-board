package com.hello.helloprojectboard.config;

import com.hello.helloprojectboard.dto.UserAccountDto;
import com.hello.helloprojectboard.repository.UserAccountRepository;
import com.hello.helloprojectboard.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean private UserAccountRepository userAccountRepository;
    @MockBean private UserAccountService userAccountService;

    @BeforeTestMethod
    public void securitySetup() {
        given(userAccountService.searchUser(anyString()))
                .willReturn(Optional.of(createuserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(createuserAccountDto());
    }

    private UserAccountDto createuserAccountDto() {
        return UserAccountDto.of(
                "isackTest",
                "pw",
                "isack-test@email.com",
                "isack-test",
                "test memo"
        );
    }
}
