
package send;

 import java.awt.*; 
import java.sql.*; 
import java.util.*; 
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; 


public class MysqlConnection {
    
    public static void main(String[] args) {


        Connection conn = null;
        Statement stmt = null;
        ResultSet set = null;
        try {
            //String url ="jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=SenderMailDatabase;integratedSecurity=true";
            String url = "jdbc:mysql://localhost:3306/sakila";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, "root", "Mm.54006221");
            System.out.println("SUCCESS");
            stmt = conn.createStatement();
            set = stmt.executeQuery("SELECT * FROM  sendermaildatabase.mailuser");
            while(set.next()) {
               
                System.out.println(set.getString("mailUserGmailName")+"--->"+set.getString("mailUserGmailPassword"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if(set != null) try { set.close(); } catch (SQLException e2) {}
            if(stmt != null) try { stmt.close(); } catch (SQLException e3) {}
            if(conn != null) try { conn.close(); } catch (SQLException e4) {}
        }

}
}
