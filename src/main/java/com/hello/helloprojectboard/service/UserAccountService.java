package com.hello.helloprojectboard.service;

import com.hello.helloprojectboard.domain.UserAccount;
import com.hello.helloprojectboard.dto.UserAccountDto;
import com.hello.helloprojectboard.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional(readOnly = true)
    public Optional<UserAccountDto> searchUser(String username) {
        return userAccountRepository.findById(username)
                .map(UserAccountDto::from);
    }

    public UserAccountDto saveUser(String username, String password, String email, String nickname, String memo) {
        return UserAccountDto.from(
                userAccountRepository.save(UserAccount.of(username, password, email, nickname, memo, username))
        );
    }

    public UserAccountDto saveUser(UserAccountDto dto) {
        return UserAccountDto.from(
                userAccountRepository.save(UserAccount.of(dto.userId(), passwordEncoder.encode(dto.userPassword()), dto.email(), dto.nickname(), dto.memo(), dto.userId()))
        );
    }

}
