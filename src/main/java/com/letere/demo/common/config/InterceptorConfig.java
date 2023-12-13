package com.letere.demo.common.config;

import com.letere.demo.common.interceptor.AuthInterceptor;
import com.letere.demo.common.interceptor.RequestLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * @author gaozijie
 * @date 2023-08-21
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final static String[] EXCLUDE_PATHS = {
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/webjars/**"
    };

    @Autowired
    private RequestLogInterceptor requestLogInterceptor;
    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATHS);
    }
}
