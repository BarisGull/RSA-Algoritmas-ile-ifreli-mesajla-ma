package send;




import java.math.BigInteger;
import java.util.Scanner;



public class Encryption {
    
       public static String text ;
       public static  String metin;
       public static String sifrelenmis_metin;
    	
       public static void main(String[]args) {
	
		Sifremain01();
	
	}
	public static void Sifremain01() {
		RSA rsa = new RSA(new BigInteger("111547"),new BigInteger("34117"), new BigInteger("13"));
	//	System.out.println("Bir metin giriniz : ");
          //    Scanner klavye = new Scanner(System.in);
		
           
                
             
	        sifrelenmis_metin = rsa.sifrele(text);
		System.out.println("Şifrelenmiş Metin:" + sifrelenmis_metin);
		String metin2 = rsa.sifreCoz(sifrelenmis_metin);    
                System.out.println("Şifresi Çözülmüş Metin : " + metin2);

	//	klavye.close();
    }

    
  }

    

