package com.letere.demo.common.config;

import com.letere.demo.common.interceptor.AuthInterceptor;
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

    private final static String[] SWAGGER_PATHS = {
            "/doc.html",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/webjars/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(SWAGGER_PATHS);
    }
}
