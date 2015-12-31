package digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class digest {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// TODO Auto-generated method stub

		
		MessageDigest msgd = MessageDigest.getInstance("MD5");//or SHA-256 etc.
		FileInputStream file = new FileInputStream("test.txt");
		
		byte[] data = new byte[2048];
		
		int read = 0;
		while((read = file.read(data)) != -1)
		{
			msgd.update(data,0,read);
		}
		byte[] msgdbyte = msgd.digest();
		
		//convert the byte to hex format method 
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<msgdbyte.length;i++)
		{
			sb.append(Integer.toString((msgdbyte[i]&0xff)+0x100,16).substring(1));
		}
		
		System.out.println("HEX : " + sb.toString());
	}

}
