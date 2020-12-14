import java.security.*;

import java.util.*;

import javax.crypto.*;






public class DES

{

public static void main(String[] argv) {



try{
 



KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
 

SecretKey myDesKey = keygenerator.generateKey(); Cipher desCipher;

Scanner sc=new Scanner(System.in);



// Create the cipher

desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");




//	Initialize the cipher for encryption desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);


System.out.print("Enter Plain Text :");

String str1=sc.nextLine();

//sensitive information

byte[] text = str1.getBytes();



System.out.println("Plain Text : " + new String(text));



// Encrypt the text

byte[] textEncrypted = desCipher.doFinal(text);



System.out.println("Text Encryted : " + textEncrypted);




//	Initialize the same cipher for decryption desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
 


// Decrypt the text

byte[] textDecrypted = desCipher.doFinal(textEncrypted);



System.out.println("Text Decryted : " + new String(textDecrypted));



}catch(NoSuchAlgorithmException e){

e.printStackTrace();

}catch(NoSuchPaddingException e){

e.printStackTrace();

}catch(InvalidKeyException e){

e.printStackTrace();

}catch(IllegalBlockSizeException e){

e.printStackTrace();

}catch(BadPaddingException e){

e.printStackTrace();

}



}

}

