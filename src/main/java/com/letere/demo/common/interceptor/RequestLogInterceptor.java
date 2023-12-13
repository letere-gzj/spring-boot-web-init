package com.letere.demo.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * 请求日志拦截器
 * @author gaozijie
 * @since 2023-12-13
 */
@Component
public class RequestLogInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(RequestLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("request = [{} {} {} {}]",
                request.getMethod(),
                request.getRequestURI(),
                ObjectUtils.isEmpty(request.getQueryString()) ? "\"\"" : request.getQueryString(),
                Objects.equals(request.getRemoteAddr(), "0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddr());
        return true;
    }
}
