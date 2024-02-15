package com.hello.helloprojectboard.domain.constant;

import lombok.Getter;

public enum JoinFormStatus {
    JOIN("가입", false),
    UPDATE("수정", true);

    @Getter private final String description;
    @Getter private final Boolean update;

    JoinFormStatus(String description, Boolean update) {
        this.description = description;
        this.update = update;
    }
}
