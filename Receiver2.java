import java.net.DatagramSocket;

import java.net.DatagramPacket;

import java.net.InetAddress;

import java.io.IOException;

import java.util.*;

import java.math.BigInteger;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;



class Receiver2

{

static HashMap<String,String> user_data = new HashMap<String,String>(); public static void main(String args[]) throws IOException {


user_data.put("Ruju","182c4b89a27c52474a0a532d5519f5e1"); user_data.put("Nikita","d265e24340d83487e7740d67927e4003");
 


DatagramSocket server = new DatagramSocket(1234); byte[] message = new byte[65536];

DatagramPacket packet = new DatagramPacket(message,message.length); server.receive(packet);

InetAddress ip=packet.getAddress();

int port=packet.getPort();

String[] str=(convertToString(message)).split(",");

String username=str[0];

String password=str[1];

password=decryptPassword(password);

System.out.print("\nUsername : "+username+"\nPassword : "+password);

message=null;

message=(check(password,username)).getBytes(); packet=new DatagramPacket(message,message.length,ip,port); server.send(packet);

}



//authoriziing function

public static String check(String password,String username){ if((getMessagedigest(password)).equals((String)user_data.get(username))){

return "success";

}

return "failure";

}
 
//converting bytes to string

public static String convertToString(byte[] a)

{

if (a == null)

return null;

String s = "";

int i = 0;

while (a[i] != 0)

{

s=s+(char)a[i];

i++;

}

return s;

}

//decrypting password

public static String decryptPassword(String password){ char[] tokens = password.toCharArray(); String decrypted_text="";

for(char c:tokens){

decrypted_text=decrypted_text+((char)((int)c-3))+"";

}

return decrypted_text;

}
 



public static String getMessagedigest(String message)
 
{

try {

MessageDigest md = MessageDigest.getInstance("MD5"); byte[] messageDigest = md.digest(message.getBytes()); BigInteger no = new BigInteger(1, messageDigest); String hashtext = no.toString(16);

while (hashtext.length() < 32) {

hashtext = "0" + hashtext;

}

return hashtext;

}

catch (NoSuchAlgorithmException e) {

throw new RuntimeException(e);

}

}

}

