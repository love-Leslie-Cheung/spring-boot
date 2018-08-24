package com.dmsoft.hyacinth.server.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.File;

public interface SendEmailService {
    void sendSalaryWithAttachment(JavaMailSenderImpl mailSender,String sendEmail, String to, String title, String content, File file);

    void initChartData(String code);

    boolean updateEmail(String host,String port,String send_email,String password);

    void sendAttachmentMail(JavaMailSenderImpl mailSender,String sender,String port,String senderPassword, String host);

    boolean test();
}
