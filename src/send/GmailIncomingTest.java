

package send;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;

public class GmailIncomingTest {

    public static void main(String[] args) {
        try {
            String username = "your mail address";
            String password = "your mail password";

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

           
            
            
       
            
            
            Session session = Session.getDefaultInstance(properties, new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
           
            IMAPStore store = (IMAPStore) session.getStore("imaps");
            store.connect("smtp.gmail.com", username, password);

            IMAPFolder inbox = (IMAPFolder) store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            System.out.println(inbox.getMessageCount());
             
               int mesajSayisi =inbox.getMessageCount();
               GmailInbox gml =new GmailInbox();
               
               while(mesajSayisi <=inbox.getMessageCount()){
                   
                   gml.gmailInbox();
                  
                   if(mesajSayisi == inbox.getMessageCount()){
                       mesajSayisi++;
                       
                   }
                   else
                       mesajSayisi =inbox.getMessageCount();
               }
               
                
            
          
       
                inbox.addMessageCountListener(new MessageCountListener() {

                @Override
                public void messagesRemoved(MessageCountEvent event) {

                }

                @Override
                public void messagesAdded(MessageCountEvent event) {
                    Message[] messages = event.getMessages();
                  
                    
                    for (Message message : messages) {
                        try {
                            
                            System.out.println("Mail Subject:- " + message.getSubject());
                            System.out.println("sfasf : - "+ message.getSentDate());//
                            MimeMultipart mm = (MimeMultipart)message.getContent();//*
                            for(int i=0; i < 1/*TODO 1 ne olacak*/; ++i) {//----
                                
                                //base64 encoding araştır...
            //                    bp = mm.getBodyPart(i);//
                                //TODO nasıl
                            }
                        } catch (MessagingException e) {
                            e.printStackTrace();
                              System.out.println("Messagingexception + :"+e.getMessage());
                        } catch (IOException ex) {
                              System.out.println("Messagingexception + :"+ex.getMessage());
                        }
                    }
                }
            });

            new Thread(new Runnable() {
                private static final long KEEP_ALIVE_FREQ = 10000;

                @Override
                public void run() {
                    while (!Thread.interrupted()) {
                        try {
                            inbox.idle();
                            Thread.sleep(KEEP_ALIVE_FREQ);                                  
                        } catch (InterruptedException e) {
                            System.out.println("interrupt : "+e.getMessage());
                        } catch (MessagingException e) {
                               System.out.println("Messaging :"+e.getMessage());
                        }
                    }
                }
            }).start();                 
        } catch (Exception e) {
            e.printStackTrace();
              System.out.println("Exception :"+e.getMessage());
        }
    
    
    }
}