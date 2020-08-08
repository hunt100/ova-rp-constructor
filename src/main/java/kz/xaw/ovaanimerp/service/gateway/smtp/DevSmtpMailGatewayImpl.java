package kz.xaw.ovaanimerp.service.gateway.smtp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class DevSmtpMailGatewayImpl implements SmtpMailGateway {

    private static final Logger log = LoggerFactory.getLogger(DevSmtpMailGatewayImpl.class);

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        log.info("Send mail to: {} with subject: {} and following text: {}", to, subject, text);
    }

    @Override
    public void sendMimeMessage(String to, String subject, String text) {
        log.info("Send mail to: {} with subject: {} and following text: {}", to, subject, text);
    }
}
