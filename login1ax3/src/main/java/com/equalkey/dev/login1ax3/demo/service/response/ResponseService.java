package com.equalkey.dev.login1ax3.demo.service.response;

import com.equalkey.dev.login1ax3.demo.entity.User;
import com.equalkey.dev.login1ax3.demo.model.response.CommonResult;
import com.equalkey.dev.login1ax3.demo.model.response.ListResult;
import com.equalkey.dev.login1ax3.demo.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public enum CommonResponse {

        SUCCESS(true, 0, "성공하였습니다."),
        FAIL(false, -1, "실패하였습니다.");

        boolean success;
        int code;
        String msg;

        CommonResponse(boolean success, int code, String msg) {
            this.success = success;
            this.code = code;
            this.msg = msg;
        }

        public boolean isSuccess() {
            return success;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public <T> SingleResult<T> getSuccessSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        this.setSuccess(result);

        return result;
    }

    public <T> ListResult<T> getSuccessListResult(List<T> data) {
        ListResult<T> result = new ListResult<>();
        result.setData(data);
        this.setSuccess(result);

        return result;
    }

    public CommonResult getSuccessCommonResult() {
        CommonResult result = new CommonResult();
        this.setSuccess(result);
        return result;
    }

    public CommonResult getFailCommonResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSucceess(false);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

    public void setSuccess(CommonResult result) {
        result.setSucceess(CommonResponse.SUCCESS.isSuccess());
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }


}
