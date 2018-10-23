package lab3.Email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class main {
    public static void main(String[] args)
    {

        final String username = "ObiektoweMail";
        final String password = "Obiektowe1";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

    EmailMessage msg = EmailMessage.builder().setFrom("ObiektoweMail@gmail.com").setTo("obiektowe@niepodam.pl").setSubject("a").setContent("b").build();

    try
    {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(msg.getFrom()));
        for(var a: msg.getTo()) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(a));
        }
        for(var a: msg.getCc()) {
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(a));
        }
        for(var a: msg.getBcc()) {
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress(a));
        }
        message.setSubject(msg.getSubject());
        message.setText(msg.getContent());
        Transport.send(message);
        System.out.println("wyslano wiadomosc");

    }

    catch (MessagingException ex)
    {
        ex.printStackTrace();
    }

    }
}

