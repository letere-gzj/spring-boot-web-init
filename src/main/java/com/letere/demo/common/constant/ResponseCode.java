package com.letere.demo.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码
 * @author gaozijie
 * @date 2023-08-04
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS("200", "成功"),
    /**
     * 失败
     */
    FAIL("400", "失败");

    private final String code;

    private final String desc;
}
