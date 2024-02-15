package com.hello.helloprojectboard.dto.request;

import com.hello.helloprojectboard.dto.UserAccountDto;

public record UserAccountRequest(
        String userId,
        String userPassword,
        String email,
        String nickname
) {

    public static UserAccountRequest of(String userId, String userPassword, String email, String nickname) {return new UserAccountRequest(userId, userPassword, email, nickname);}


    public UserAccountDto toDto() {
        return UserAccountDto.of(
                this.userId,
                this.userPassword,
                this.email,
                this.nickname,
                null
        );
    }


}
