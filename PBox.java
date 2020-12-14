import java.util.Scanner;

class PBox

{

public static void main(String args[])

{

Scanner in = new Scanner(System.in);




String plain_text,encrypted_text,decrypted_text; System.out.print("\nEnter plain text : ");
 
plain_text=in.nextLine();



encrypted_text=encryptText(plain_text);



System.out.print("\n\nEncrypted text:"+encrypted_text);



decrypted_text=decryptText(encrypted_text);









}

public static String encryptText(String plain_text)

{

char[] encrypt_text = new char[plain_text.length()]; int length=plain_text.length(); for(int i=0;i<length;i++){

int n=(i+2)%length;

encrypt_text[n]=plain_text.charAt(i);

}

String str = new String(encrypt_text);

return str;

}

public static String decryptText(String encrypted_text)

{
 

char[] decrypt_text = new char[encrypted_text.length()]; int length=encrypted_text.length(); for(int i=0;i<length;i++){

int n=(i+2)%length;

if(length%2==0)

decrypt_text[n]=encrypted_text.charAt(i);

else{

n=((n+1)==length)?0:(n+1);

decrypt_text[n]=encrypted_text.charAt(i);

}

}

String str = new String(decrypt_text);

return str;

}

}

