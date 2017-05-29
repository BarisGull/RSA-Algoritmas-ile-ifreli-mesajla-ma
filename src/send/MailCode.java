package send;





import java.util.Properties;
import javax.swing.JFrame;
 import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailCode {
  
   public String mesaj;
  // public static  String to;
   public static String from;
   public static void main(String[] args) {
	     
          
       
	   }
   
   public void sendMessage(String subject , String body,String to,String from,String password){
     
                 this.mesaj = body;
       /*          
	     String to ="nabymiri@gmail.com";//change accordingly
             String from = "bgul556@gmail.com";//change accordingly
	     final String password = "sinop50916602000";//change accordingly
      */
	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";
              final String username = "bgul556@gmail.com";//change accordingly
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setText(body);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
   }
   
}