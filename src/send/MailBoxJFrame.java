


package send;


 import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.swing.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import send.Send;



public class MailBoxJFrame extends javax.swing.JFrame {
   
    public String inboxMessage;
   
    
    public MailBoxJFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        lblGondericiMailAdres = new javax.swing.JLabel();
        lblGondericiParola = new javax.swing.JLabel();
        txtGondericiMailAdres = new javax.swing.JTextField();
        txtGondericiParola = new javax.swing.JTextField();
        lblAliciMailAdres = new javax.swing.JLabel();
        txtAliciMailAdres = new javax.swing.JTextField();
        lblGidenMesajlar = new javax.swing.JLabel();
        lblGelenMesajlar = new javax.swing.JLabel();
        btnGonder = new javax.swing.JButton();
        btnMetinOku = new javax.swing.JButton();
        chckboxSifreGoster = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaGelenMesaj = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaGidenMesaj = new javax.swing.JTextArea();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sohbet Paneli");
        setBounds(new java.awt.Rectangle(300, 50, 0, 0));
        setName("Sohbet "); // NOI18N
        setResizable(false);

        lblGondericiMailAdres.setText("Gönderici Mail Adresi :");

        lblGondericiParola.setText("Gönderici Parola :");

        txtGondericiMailAdres.setText("@gmail.com");
        txtGondericiMailAdres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGondericiMailAdresActionPerformed(evt);
            }
        });

        lblAliciMailAdres.setText("Alıcı Mail Adres :");

        txtAliciMailAdres.setText("@gmail.com");

        lblGidenMesajlar.setText("Giden Mesajlar");

        lblGelenMesajlar.setText("Gelen Mesajlar");

        btnGonder.setText("Gönder");
        btnGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGonderActionPerformed(evt);
            }
        });

        btnMetinOku.setText("Metin Oku");

        chckboxSifreGoster.setText("Şifre Göster");

        txtAreaGelenMesaj.setColumns(20);
        txtAreaGelenMesaj.setRows(5);
        jScrollPane3.setViewportView(txtAreaGelenMesaj);

        txtAreaGidenMesaj.setColumns(20);
        txtAreaGidenMesaj.setRows(5);
        jScrollPane4.setViewportView(txtAreaGidenMesaj);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGonder, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnMetinOku)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAliciMailAdres)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblGondericiMailAdres)
                                        .addGap(152, 152, 152))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGondericiMailAdres)
                                        .addGap(102, 102, 102)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGondericiParola, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chckboxSifreGoster))
                                    .addComponent(lblGondericiParola)))
                            .addComponent(txtAliciMailAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblGidenMesajlar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGelenMesajlar)
                .addGap(257, 257, 257))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblGondericiMailAdres)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGondericiParola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGondericiMailAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGondericiParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chckboxSifreGoster, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblAliciMailAdres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAliciMailAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGidenMesajlar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGelenMesajlar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGonder)
                    .addComponent(btnMetinOku))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGonderActionPerformed
       
        MailCode mailcode =new MailCode();
        String from=txtGondericiMailAdres.getText();
        String to =txtAliciMailAdres.getText();
        String sendMesaj = txtAreaGidenMesaj.getText();
        String password = txtGondericiParola.getText();
       
        
        Encryption enc =new Encryption();
        enc.text = sendMesaj;
        Encryption.Sifremain01();
        String subject =Encryption.sifrelenmis_metin;
        mailcode.sendMessage("test" , subject,to,from,password);
                                         
    }//GEN-LAST:event_btnGonderActionPerformed

    private void txtGondericiMailAdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGondericiMailAdresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGondericiMailAdresActionPerformed

   
    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailBoxJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGonder;
    private javax.swing.JButton btnMetinOku;
    private javax.swing.JCheckBox chckboxSifreGoster;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAliciMailAdres;
    private javax.swing.JLabel lblGelenMesajlar;
    private javax.swing.JLabel lblGidenMesajlar;
    private javax.swing.JLabel lblGondericiMailAdres;
    private javax.swing.JLabel lblGondericiParola;
    private javax.swing.JTextField txtAliciMailAdres;
    private javax.swing.JTextArea txtAreaGelenMesaj;
    private javax.swing.JTextArea txtAreaGidenMesaj;
    private javax.swing.JTextField txtGondericiMailAdres;
    private javax.swing.JTextField txtGondericiParola;
    // End of variables declaration//GEN-END:variables
}