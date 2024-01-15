package com.hello.helloprojectboard.controller;

import com.hello.helloprojectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@DisplayName("View 컨트롤러 - 인증")
@Import(SecurityConfig.class)
@WebMvcTest(AuthControllerTest.EmptyController.class)
 class AuthControllerTest {

    private final MockMvc mvc;

     AuthControllerTest(@Autowired MockMvc mockMvc) {
        this.mvc = mockMvc;
    }

    @DisplayName("[view][GET] 로그인 페이지 - 정상 호출")
    @Test
     void givenNothing_whenTryingToLogin_thenReturnLoginView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andDo(MockMvcResultHandlers.print());
    }
}
