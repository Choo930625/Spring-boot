package com.equalkey.dev.login.controller.v1;

import com.equalkey.dev.login.service.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"1. User"} )
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    ResponseService responseService;

    @GetMapping("/user")
    @ResponseBody
    public

}
