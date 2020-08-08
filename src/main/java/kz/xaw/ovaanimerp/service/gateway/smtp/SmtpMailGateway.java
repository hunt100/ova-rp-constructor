package kz.xaw.ovaanimerp.service.gateway.smtp;

public interface SmtpMailGateway {

    void sendSimpleMessage(String to, String subject, String text);

    void sendMimeMessage(String to, String subject, String text);
}
