package com.equalkey.dev.login.controller.v1;

import com.equalkey.dev.login.entity.User;
import com.equalkey.dev.login.model.response.SingleResult;
import com.equalkey.dev.login.service.ResponseService;
import com.equalkey.dev.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags={"1. User"} )
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    ResponseService responseService;

    @Autowired
    UserService userService;



    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다")
    @PostMapping("/user")
    public SingleResult<User> save(@ApiParam(value = "회원아이디", required = true)
                                   @RequestParam String uid,
                                   @ApiParam(value = "회원이름", required = true)
                                   @RequestParam String name) {
        User user;
        user = userService.save(uid, name);

        return responseService.getSingledResult(user);
    }

    @ApiOperation(value = "회원 단건 조회", notes = "userId로 회원을 조회한다")
    @GetMapping(value = "/user/{msrl}")
    public SingleResult<User> findUserById(@ApiParam(value = "회원ID", required = true) @PathVariable long msrl, @ApiParam(value = "언어", defaultValue = "ko") @RequestParam String lang) {
        // 결과데이터가 단일건인경우 getBasicResult를 이용해서 결과를 출력한다.
        return responseService.getSingleResult(userJpaRepo.findById(msrl).orElseThrow(CUserNotFoundException::new));
    }

}
