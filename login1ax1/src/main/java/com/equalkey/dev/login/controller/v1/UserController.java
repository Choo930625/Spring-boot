package com.equalkey.dev.login.controller.v1;

import com.equalkey.dev.login.entity.User;
import com.equalkey.dev.login.exception.CUserNotFoundException;
import com.equalkey.dev.login.model.response.CommonResult;
import com.equalkey.dev.login.model.response.ListResult;
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
        return responseService.getSingledResult(userService.findById(msrl));
    }

    @ApiOperation(value = "회원 리스트 조회", notes="모든 회원을 조회한다")
    @GetMapping("/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userService.findAll());
    }

    @ApiOperation(value = "회원 수정", notes = "회원 정보 수정")
    @PutMapping("/user")
    public SingleResult<User> modify(@ApiParam(value = "회원 번호 : ", required = true) @RequestParam
    Long msrl,
            @ApiParam(value = "회원 아이디: ", required = true) @RequestParam String uid,
                                     @ApiParam(value = "회원 이름 : ", required = true) @RequestParam
                                     String name) {
        return responseService.getSingledResult(userService.update(msrl, uid, name));
    }

    @ApiOperation(value = "회원 삭제", notes = "회원 번호로 회원 정보 삭제")
    @DeleteMapping("/user")
    public CommonResult delete(@ApiParam(value = "회원 번호: ", required = true) @RequestParam Long msrl) {
        userService.delete(msrl);
        return responseService.getSuccessResult();
    }
}
