package com.letere.demo.common.handler;

import com.letere.demo.common.bean.Result;
import com.letere.demo.common.bean.mail.Mail;
import com.letere.demo.common.bean.mail.MailExceptionProperties;
import com.letere.demo.common.client.MailClient;
import com.letere.demo.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/**
 * 全局异常处理
 * @author gaozijie
 * @since 2023-08-04
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MailExceptionProperties mailExceptionProperties;

    @Autowired
    private MailClient mailClient;

    @ExceptionHandler(value = BusinessException.class)
    public Result<?> businessExceptionHandler(HttpServletRequest req, BusinessException e) {
        e.printStackTrace();
        // 业务异常不发送通知邮件
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        // 异常发送通知邮件
        this.sendExceptionMail(e);
        return Result.error(e.getMessage());
    }

    /**
     * 发送异常通知邮件
     * @param e 异常
     */
    private void sendExceptionMail(Exception e) {
        if (!mailExceptionProperties.isEnable()) {
            return;
        }
        Mail mail = new Mail();
        mail.setSubject(mailExceptionProperties.getSubject());
        mail.setRecMailBoxes(mailExceptionProperties.getRecMailBoxes());
        // 写入异常Stack
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        mail.setText(sw.toString());
        mailClient.sendMail(mail);
    }
}
