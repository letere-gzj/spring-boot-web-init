package com.letere.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gaozijie
 * @date 2023-08-04
 */
@SpringBootApplication
@MapperScan("com.letere.demo.mapper")
public class Run {
    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
