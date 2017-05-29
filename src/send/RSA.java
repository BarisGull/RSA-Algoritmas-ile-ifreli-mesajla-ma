package send;



import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {

	BigInteger modValue;
	BigInteger key;
	BigInteger exp;

	public RSA(BigInteger sayi, BigInteger key, BigInteger exp) {
		this.modValue = sayi;
		this.key = key;
		this.exp = exp;
	}

	public String sifrele(String msg) {

		BigInteger number;
		BigInteger ModPow;
		String sentence="";
		String[] arr = split(msg, 2);
		int val;
		
		for(String s : arr) {
			val = (int)s.charAt(0);
			val <<= 8;
			val += (int)s.charAt(1);
			
			number = BigInteger.valueOf(val);
			ModPow = number.modPow(exp, modValue);
		
			long val2 = ModPow.longValue();
			char[] chars = new char[3];
			chars[2] = (char)(val2 & 0xFF);
			chars[1] = (char)(val2 >> 8 & 0xFF);
			chars[0] = (char)(val2 >> 16 & 0xFF);
			sentence += new String(chars);
		}
		return sentence;
	}
		
	public String sifreCoz(String msg) {

		BigInteger number;
		BigInteger ModPow;
		String character  = "";
		String decSentence   = "";
	
		String[] arr = split(msg, 3);
		int val;
		for(String s : arr) {
			val = (int)s.charAt(0);
			val <<= 8;
			val += (int)s.charAt(1);
			val <<= 8;
			val += (int)s.charAt(2);
			
			
			character = Integer.toString(val);
			number = new BigInteger(character);
			ModPow = number.modPow(key,modValue);
		
			long val2 = ModPow.longValue();
			char[] chars = new char[3];
			chars[1] = (char)(val2 & 0xFF);
			chars[0] = (char)(val2 >> 8 & 0xFF);
			decSentence +=""+chars[0]+""+chars[1];
	}	
	return decSentence;	
	}	
	
	public static String[] split(String s, int length) {
		while(s.length()%length != 0)
			s+=" ";
		String[] metinler = new String[s.length() / length];
		int index =0;
		for (int i = 0; i < s.length(); i += length) {
			metinler[index] = s.substring(i, (i+length));
			index++;
		}
		return metinler;
	}
	}
