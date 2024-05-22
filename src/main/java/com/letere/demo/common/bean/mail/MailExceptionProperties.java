package com.letere.demo.common.bean.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gaozijie
 * @since 2024-05-21
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.mail.exception")
public class MailExceptionProperties {

    /**
     * 是否开启
     */
    private boolean enable;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 接收者邮箱集合
     */
    private List<String> recMailBoxes;

}
