package Extras;

import java.awt.HeadlessException;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;


public class SendEmail {
    String host;
    String user;
    String password;
    String to;
    String from;
    String message;
    String subject;
    
    /**
     *
     * @param to
     * @param message
     * @param subject
     * @throws javax.mail.MessagingException
     */
    public void SendEmail(String to, String message, String subject) throws MessagingException{
        this.host = "smtp.gmail.com";
        this.user = "proyectofadsi@gmail.com";
        this.password = "fadsiproject";
        this.message = message;
        this.to = to;
        this.from = "proyectofadsi@gmail.com";
        this.subject = subject;
        send();
    }

    public void send() throws MessagingException{
        try{
            String messageText = this.message;
            boolean sessionDebug = false;
            
            Properties props = System.getProperties();
            
           // props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(sessionDebug);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = new InternetAddress[1];
            address[0] =  (new InternetAddress(to));
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);
            
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(host, user, password);
                transport.sendMessage(msg, msg.getAllRecipients());
            }
            JOptionPane.showMessageDialog(null, "Enviado");
        }catch (Exception e){
        }
        
    }
    
}
