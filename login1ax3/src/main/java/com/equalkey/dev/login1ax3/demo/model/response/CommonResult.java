package com.equalkey.dev.login1ax3.demo.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "응답 성공 여부 : true/false")
    private boolean succeess;
    
    @ApiModelProperty(value = "응답 성공 코드 : >=0 성공, <0 실패")
    private int code;
    
    @ApiModelProperty(value = "응답 메세지")
    private String msg;
}
