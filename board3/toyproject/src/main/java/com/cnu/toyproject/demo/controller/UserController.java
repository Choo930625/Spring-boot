package com.cnu.toyproject.demo.controller;

import com.cnu.toyproject.demo.domain.entity.UserEntity;
import com.cnu.toyproject.demo.domain.repository.UserRepo;
import com.cnu.toyproject.demo.dto.UserDto;
import com.cnu.toyproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    // 메인 페이지
    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin() {
        return "/login";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(UserDto userDto) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^컨트롤러");
        userService.joinUser(userDto);

        return "redirect:/user/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }


}
