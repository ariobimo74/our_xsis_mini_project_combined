package com.xsis.xsis.restapi.fathan;

import com.xsis.xsis.model.fathan.EmailMessage;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * SendMailAPI
 */
@RestController
@RequestMapping(path = "api/sending")
public class SendMailAPI {
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public String sendEmail(@RequestBody EmailMessage emailmessage)
            throws AddressException, MessagingException, IOException {
        sendmail(emailmessage);

        return "Email sent successfully";
    }

    private void sendmail(EmailMessage emailmessage) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo()));
        msg.setSubject(emailmessage.getSubject());
        msg.setContent(emailmessage.getText(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailmessage.getText(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        // MimeBodyPart attachPart = new MimeBodyPart();

        // attachPart.attachFile("C:\\talk2amareswaran-downloads\\mysql2.png");

        // multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }

}