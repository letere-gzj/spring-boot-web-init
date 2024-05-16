package com.letere.demo.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 请求日志拦截器
 * @author gaozijie
 * @since 2023-12-13
 */
@Component
public class RequestLogInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(RequestLogInterceptor.class);

    /**
     * 起始时间Local
     */
    private static final ThreadLocal<Long> START_TIME_LOCAL = new ThreadLocal<>();

    private static final BigDecimal THOUSAND = BigDecimal.valueOf(1000L);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        START_TIME_LOCAL.set(System.currentTimeMillis());
        logger.info("Before request = [{} {} {} {}]",
                request.getMethod(),
                request.getRequestURI(),
                ObjectUtils.isEmpty(request.getQueryString()) ? "\"\"" : request.getQueryString(),
                Objects.equals(request.getRemoteAddr(), "0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddr());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        double costTime = BigDecimal.valueOf(System.currentTimeMillis() - START_TIME_LOCAL.get()).divide(THOUSAND, 3, RoundingMode.DOWN).doubleValue();
        START_TIME_LOCAL.remove();
        logger.info("After request = [{} {} 耗时:{}s]",
                request.getMethod(),
                request.getRequestURI(),
                costTime);
    }
}
