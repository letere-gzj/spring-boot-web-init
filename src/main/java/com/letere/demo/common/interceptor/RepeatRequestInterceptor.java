package com.letere.demo.common.interceptor;

import com.letere.demo.common.annotation.RepeatLimit;
import com.letere.demo.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 重复请求拦截器
 * @author gaozijie
 * @since 2024-03-01
 */
@Component
public class RepeatRequestInterceptor implements HandlerInterceptor {
    /**
     * 缓存（可整合redis来替代本地缓存）
     */
    Map<String, Long> cache = new ConcurrentHashMap<>(16);

    /**
     * 缓存失效时间
     */
    private final static Long CACHE_CANCEL_TIME = 3000L;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // get请求不做幂等性处理
        if (Objects.equals(RequestMethod.resolve(request.getMethod()), RequestMethod.GET)) {
            return true;
        }
        // 对没有@RepeatLimit注解的接口放行（若取消此判断则全局拦截，酌情考虑是否使用全局拦截）
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (!handlerMethod.hasMethodAnnotation(RepeatLimit.class)) {
            return true;
        }
        String key = this.getCacheKey(request);
        Long timestamp = cache.get(key);
        long nowTimestamp = System.currentTimeMillis();
        // 缓存为空 | 缓存时间差超出设置缓存取消时间，则放行
        if (Objects.isNull(timestamp) || nowTimestamp - timestamp > CACHE_CANCEL_TIME) {
            cache.put(key, nowTimestamp);
            return true;
        }
        throw new BusinessException("请勿重复提交请求");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String key = this.getCacheKey(request);
        // 请求结束后移除缓存
        cache.remove(key);
    }

    private String getCacheKey(HttpServletRequest request) {
        return request.getRequestURI() + ":" + request.getSession().getId();
    }
}
