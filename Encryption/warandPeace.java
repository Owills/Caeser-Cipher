import java.util.*;
import java.io.*;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  
public class warandPeace{
    public static void main() throws Exception{
        File newFile = new File("original.txt");
        FileReader reading = new FileReader(newFile);
        BufferedReader br = new BufferedReader(reading);
        String str = "";
        str += br.readLine();
        
        newFile = new File("copy.txt");
        reading = new FileReader(newFile);
        br = new BufferedReader(reading);
        String str1 = "";
        str1 += br.readLine();
        
        System.out.println(toHexString(getSHA(str)));  

        System.out.println(toHexString(getSHA(str1)));
    }    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
    
        
}
