package com.letere.demo.common.bean;

import com.letere.demo.common.constant.ResponseCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 接口统一返回对象
 * @author gaozijie
 * @since 2023-08-04
 */
@Data
@AllArgsConstructor
public class Result<T> {
    @Schema(description = "状态码")
    private String code;

    @Schema(description = "数据")
    private T data;

    @Schema(description = "错误信息")
    private String msg;

    public static <T> Result<T> build(String code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    public static <T> Result<T> success() {
        return build(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static <T> Result<T> success(T data) {
        return build(ResponseCode.SUCCESS.getCode(), data, null);
    }

    public static <T> Result<T> error(String msg) {
        return build(ResponseCode.FAIL.getCode(), null, msg);
    }

    public static <T> Result<T> error(String code, String msg) {
        return build(code, null, msg);
    }
}
