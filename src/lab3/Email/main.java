package lab3.Email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class main {
    public static void main(String[] args)
    {
        Properties prop = new Properties();
        prop.put("mail.transport.protocol","smtp");
        prop.put("mail.smtp.host","smtp.poczta.onet.pl");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth","false");

        Authenticator auth = new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("filip.jachura@onet.eu","filip12");
            }
        };

        Session session = Session.getDefaultInstance(prop,auth);

    EmailMessage msg = EmailMessage.builder().setFrom("filip.jachura@onet.eu").setTo("filjac5882@op.pl").setSubject("a").setContent("b").build();

    try
    {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(msg.getFrom()));
        for(var a: msg.getTo()) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(a));
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

