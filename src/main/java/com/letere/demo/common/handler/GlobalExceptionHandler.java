package com.letere.demo.common.handler;

import com.letere.demo.common.bean.Result;
import com.letere.demo.common.constant.ResponseCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author gaozijie
 * @date 2023-08-04
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public Result<Object> exceptionHandler(HttpServletRequest req, Exception e){
        return Result.error(ResponseCode.FAIL.getCode(), e.getMessage());
    }
}
