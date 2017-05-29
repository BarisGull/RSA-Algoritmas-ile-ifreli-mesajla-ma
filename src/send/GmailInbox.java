package send;


import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import javax.mail.*;
public class GmailInbox {


        
public static void main(String[] args) {
      
    gmailInbox();
} 
    
    public static void gmailInbox(){
    
    
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "your mail adress", "your mail password");
            Folder inbox = store.getFolder("INBOX");
            
            inbox.open(Folder.READ_ONLY);
            //Message [] msgs = inbox.getMessages();
          
            for (int i=inbox.getMessageCount()-1 ; i > 0 ; i--){
            Message  msg = inbox.getMessage(i);
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
           
            Object content = msg.getContent(); 
            String contentBody = "" ;
             if (content instanceof String)  
                {  
                    contentBody = (String)content;  
                    
                }  
                else if (content instanceof Multipart)  
                {  
                   Multipart mp = (Multipart) msg.getContent();
                    BodyPart bp = mp.getBodyPart(0);
                    contentBody = bp.getContent().toString();
         }
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + contentBody);
            }
        } 
        catch (Exception mex) {
            mex.printStackTrace();
        }
    }  
    }
