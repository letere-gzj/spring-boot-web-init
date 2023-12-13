package com.letere.demo.common.exception;

import com.letere.demo.common.constant.ResponseCode;
import lombok.Data;

/**
 * 业务异常类
 * @author gaozijie
 * @since 2023-09-14
 */
@Data
public class BusinessException extends RuntimeException{

    private String code;

    private String message;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResponseCode.FAIL.getCode();
        this.message = message;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
