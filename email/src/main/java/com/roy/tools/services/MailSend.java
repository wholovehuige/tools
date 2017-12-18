package com.roy.tools.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;

/**
 * Created by roy on 2017/12/18.
 */
@Service
public class MailSend {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String fromUser,String toUser) {
        MimeMessage mimeMessage = null;

        try {
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
            messageHelper.setFrom(fromUser);
            messageHelper.setTo(toUser);
            messageHelper.setSubject("标题：发送html内容");   //title
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题</h1>")
                    .append("<p style='color=#F00'>红颜色</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            messageHelper.setText(sb.toString(),true);      //content
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            mailSender.send(mimeMessage);
        }
    }
}
