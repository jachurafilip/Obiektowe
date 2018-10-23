package lab3.Email;

import java.util.LinkedList;
import javax.mail.internet.*;

public class EmailMessage {

    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    protected EmailMessage(String from,
                           LinkedList<String> to,
                           String subject,
                           String content,
                           String mimeType,
                           LinkedList<String> cc,
                           LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }

    public static Builder builder()
    {
        return new EmailMessage.Builder();
    }

    public static class Builder
    {
        private String from;
        private LinkedList<String> to = new LinkedList();
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc = new LinkedList();
        private LinkedList<String> bcc = new LinkedList();

        public Builder setFrom(String from) {
            if(isValidEmail(from)) {
                this.from = from;
            }
            return this;
        }

        public Builder setTo(String to) {
            if(isValidEmail(to)) {
                this.to.add(to);
            }
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;

        }

        public Builder setContent(String content) {
            this.content = content;
            return this;

        }

        public Builder setMimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;

        }

        public Builder setCc(String cc) {
            if(isValidEmail(cc))
            {
                this.cc.add(cc);
            }
            return this;

        }

        public Builder setBcc(String bcc) {
            if(isValidEmail(bcc))
            {
                this.bcc.add(bcc);
            }
            return this;

        }

        public EmailMessage build()
        {
            return new EmailMessage(from,to,subject,content,mimeType,cc,bcc);
        }

    }
    public static boolean isValidEmail(String email)
    {
        boolean result = true;
        try{
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex)
        {
            result = false;
        }
        return result;
    }


}
