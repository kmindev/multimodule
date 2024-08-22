package dev.be.module_api.exceptionhandler;

import dev.be.module_api.exception.CustomException;
import dev.be.module_api.response.CommonResponse;
import dev.be.module_common.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse<Void> handlerCustomException(CustomException e) {
        return CommonResponse.of(e.getReturnCode(), e.getReturnMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<Void> handlerException(Exception e) {
        return CommonResponse.of(CodeEnum.UNKNOWN_ERROR.getCode(), CodeEnum.UNKNOWN_ERROR.getMessage());
    }

}
