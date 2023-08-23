package com.letere.demo.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger配置
 * @author gaozijie
 * @date 2023-08-09
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Simple Boot API")
                        .description("SpringBoot基础框架")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringBoot基础框架")
                        .url("http://127.0.0.1:8088"));
    }

    /**
     * 分组（仿造下面写法给接口分各种模块）
     * @return
     */
    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder().group("全部")
                .pathsToMatch("/**")
                .build();
    }
}
