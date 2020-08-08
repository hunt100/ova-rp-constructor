package kz.xaw.ovaanimerp.service.gateway.smtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
@Profile("prod")
public class SmtpMailGatewayImpl implements SmtpMailGateway{

    private static final Logger log = LoggerFactory.getLogger(SmtpMailGatewayImpl.class);
    private final JavaMailSender mailSender;

    @Autowired
    public SmtpMailGatewayImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public void sendSimpleMessage(String to, String subject, String text) {
        log.info("Send mail to: {} with subject: {} and following text: {}", to, subject, text);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    @Async
    public void sendMimeMessage(String to, String subject, String text) {
        log.info("Send mail to: {} with subject: {} and following text: {}", to, subject, text);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            helper.setText(text, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("mail");
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
