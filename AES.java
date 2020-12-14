import java.io.*;

import java.security.*;

import java.util.*;

import javax.crypto.*;






public class AES

{

private static SecretKeySpec secretKey;

private static byte[] key;



public static void setKey(String myKey)

{

MessageDigest sha = null;

try {

key = myKey.getBytes("UTF-8");

sha = MessageDigest.getInstance("SHA-1");

key = sha.digest(key);

key = Arrays.copyOf(key, 16);

secretKey = new SecretKeySpec(key, "AES");

}

catch (NoSuchAlgorithmException e)

{
 
e.printStackTrace();

}

catch (UnsupportedEncodingException e)

{

e.printStackTrace();

}

}



public static String encrypt(String strToEncrypt, String secret)

{

try {

setKey(secret);

Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); cipher.init(Cipher.ENCRYPT_MODE, secretKey); return
Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

}

catch (Exception e)

{

System.out.println("Error while encrypting: " + e.toString());

}

return null;

}

public static String decrypt(String strToDecrypt, String secret)
 
{

try  {

setKey(secret);

Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); cipher.init(Cipher.DECRYPT_MODE, secretKey); return new
String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

}

catch (Exception e)

{

System.out.println("Error while decrypting: " + e.toString());

}    return null;

}



public static void main(String[] args)

{

final String secretKey = "ruju";

Scanner sc=new Scanner(System.in);

System.out.print("Enter Plain Text :");

String originalString = sc.nextLine();

String encryptedString = AES.encrypt(originalString, secretKey) ; String decryptedString = AES.decrypt(encryptedString, secretKey) ; System.out.println("\n\nPlain Text :"+originalString); System.out.println("Encrepted Text :"+encryptedString);
 
System.out.println("Decrypted Text :"+decryptedString);

}

}


