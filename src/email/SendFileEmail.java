package email;

import java.io.File;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class SendFileEmail {

    public static void sendEmail(String to, String subject, String messageText, String email) throws Exception {

        String from = "asuspro5001@gmail.com";
        String password = "xdhmaqxxfflvhxpg";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.connectiontimeout", "10000");
        properties.put("mail.smtp.timeout", "10000");
        properties.put("mail.smtp.writetimeout", "10000");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        // Construct the file path for the attachment
        String filePath = "C:\\Users\\ASUS™\\Desktop\\QR\\" + email + ".png";
        File attachmentFile = new File(filePath);

        if (!attachmentFile.exists()) {
            throw new Exception("Attachment file not found");
        }

        // Create email message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);

        // Add email content
        Multipart multipart = new MimeMultipart();

        // Text body part
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText(messageText);
        multipart.addBodyPart(textBodyPart);

        // Attachment part
        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource(filePath);
        attachmentPart.setDataHandler(new DataHandler(dataSource));
        attachmentPart.setFileName(attachmentFile.getName());
        multipart.addBodyPart(attachmentPart);

        // Combine and send
        message.setContent(multipart);
        Transport.send(message);
    }
}
