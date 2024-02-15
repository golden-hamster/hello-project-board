package com.hello.helloprojectboard.controller;

import com.hello.helloprojectboard.dto.UserAccountDto;
import com.hello.helloprojectboard.dto.request.UserAccountRequest;
import com.hello.helloprojectboard.dto.security.BoardPrincipal;
import com.hello.helloprojectboard.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserAccountService userAccountService;


    @GetMapping("/form")
    public String joinForm() {
        return "users/join";
    }

    @PostMapping("/form")
    public String join(UserAccountRequest userAccountRequest) {
//        BoardPrincipal boardPrincipal = BoardPrincipal.from(userJoinRequest.toDto());
        UserAccountDto userAccountDto = userAccountService.saveUser(userAccountRequest.toDto());
        BoardPrincipal.from(userAccountDto);
        return "redirect:/";
    }
}
