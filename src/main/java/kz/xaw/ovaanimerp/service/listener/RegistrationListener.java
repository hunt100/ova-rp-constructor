package kz.xaw.ovaanimerp.service.listener;

import kz.xaw.ovaanimerp.security.AppUser;
import kz.xaw.ovaanimerp.service.TokenService;
import kz.xaw.ovaanimerp.service.gateway.smtp.SmtpMailGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    private static final Logger log = LoggerFactory.getLogger(RegistrationListener.class);
    private final MessageSource messages;
    private final SmtpMailGateway gateway;
    private final TokenService tokenService;

    @Value("${application.base.url}")
    private String baseUrl;

    @Autowired
    public RegistrationListener(MessageSource messages, SmtpMailGateway gateway, TokenService tokenService) {
        this.messages = messages;
        this.gateway = gateway;
        this.tokenService = tokenService;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        AppUser appUser = event.getAppUser();
        String token = UUID.randomUUID().toString();
        tokenService.createVerificationToken(appUser, token);

        String recipientAddress = appUser.getLogin();
        String subject = "Подтверждение регистрации";
        String confirmationUrl = event.getAppUrl() + "/registration/registrationConfirm?token=" + token;
        String message = messages.getMessage("messages.regSucc", new Object[] {baseUrl + confirmationUrl}, event.getLocale());
        log.info("Registration listener locale: {}  and message -> {}", event.getLocale(), message);
        gateway.sendSimpleMessage(recipientAddress, subject, message);
    }
}
