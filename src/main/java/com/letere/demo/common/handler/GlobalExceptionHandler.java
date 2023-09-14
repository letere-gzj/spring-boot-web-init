package com.letere.demo.common.handler;

import com.letere.demo.common.bean.Result;
import com.letere.demo.common.exception.BusinessException;
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

    @ExceptionHandler(value = BusinessException.class)
    public Result<?> businessExceptionHandler(HttpServletRequest req, BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<Object> exceptionHandler(HttpServletRequest req, Exception e){
        return Result.error(e.getMessage());
    }
}
