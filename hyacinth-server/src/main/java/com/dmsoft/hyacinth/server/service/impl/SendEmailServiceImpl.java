package com.dmsoft.hyacinth.server.service.impl;


import com.dmsoft.hyacinth.server.dao.EmailDao;
import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Email;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.SendEmailService;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Properties;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private EmailDao emailDao;

//    @Autowired
//    private JavaMailSender mailSender;//spring 提供的邮件发送类
//
//    @Value("${spring.mail.username}")
//    private String From;

    @Autowired
    private StaffService staffService;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private SendEmailService sendEmailService;

    @Override
    public void sendSalaryWithAttachment(JavaMailSenderImpl mailSender, String sendEmail, String sendTo, String title, String content, File file) {
        //附件邮件发送
        MimeMessage msg = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(sendEmail);
            helper.setTo(sendTo);
            helper.setSubject(title);
            helper.setText(content);

            FileSystemResource r = new FileSystemResource(file);
            helper.addAttachment("附件.zip", r);


        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(msg);
    }

    @Override
    public void initChartData(String code) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Email email = emailDao.findById(Long.valueOf("1"));
        sendAttachmentMail(mailSender, email.getSend_email(), email.getport(), email.getPassword(), email.getHost());

        SalaryDto sa = salaryService.findByCode(code);
        StaffDto stf = staffService.findByCode(code);
        String Path = System.getProperty("user.home") + "\\Documents\\";
        String url = Path + sa.getCode() + "-" + sa.getName() + ".zip";

        File file1 = new File(url);
        String sendTo = stf.getEmail();
        String title = stf.getName() + "工资";
        String content = stf.getName() + ",您好，本月工资已发送至你的邮箱。双击附件解压，密码是您手机号后6位。";

        sendEmailService.sendSalaryWithAttachment(mailSender, email.getSend_email(), sendTo, title, content, file1);

    }

    @Override
    public void sendAttachmentMail(JavaMailSenderImpl mailSender, String sender, String port, String senderPassword, String host) {
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));
        mailSender.setUsername(sender);
        mailSender.setPassword(senderPassword);

        Properties pro = System.getProperties(); // 下面各项缺一不可
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.ssl.enable", "true");
        pro.put("spring.mail.properties.mail.smtp.stattls.required", "true");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        mailSender.setJavaMailProperties(pro);
    }

    @Override
    public boolean updateEmail(String host, String port, String send_email, String password) {
        emailDao.deleteAll();
        if ("".equals(port))
            port = "25";
        if (emailDao.insert(Long.valueOf("1"), host, port, send_email, password) == 0) {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            RecordHistory.RecordHistory(user.getLogin_name(), "邮箱服务器配置", RecordHistory.UPDATE_SYSTEM_SETTING, "失败");
            return false;
        } else return true;
    }

    @Override
    public boolean test() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            File file = new File(System.getProperty("user.home") + "\\Documents\\test.zip");
            file.createNewFile();
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            Email email = emailDao.findById(Long.valueOf("1"));
            sendAttachmentMail(mailSender, email.getSend_email(), email.getport(), email.getPassword(), email.getHost());
            String sendTo = email.getSend_email();
            String title = "测试";
            String content = "服务配置测试";
            sendEmailService.sendSalaryWithAttachment(mailSender, email.getSend_email(), sendTo, title, content, file);
            RecordHistory.RecordHistory(user.getLogin_name(), "邮箱服务器配置", RecordHistory.UPDATE_SYSTEM_SETTING, "成功");
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            RecordHistory.RecordHistory(user.getLogin_name(), "邮箱服务器配置", RecordHistory.UPDATE_SYSTEM_SETTING, "失败");
            return false;
        }

    }
}