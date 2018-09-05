/**
 * 
 */
package com.user;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.crypto.Cipher;





public class Utilitiy
{
	static String server = "ftp.drivehq.com";
	static String user = "blrstore103";
	static String pass = "blrstore103";
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utilitiy.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="Tuesday";
			else if(no==4)
				day="Wednesday";
			else if(no==5)
				day="Thrusday";
			else if(no==6)
				day="Friday";
			else if(no==7)
				day="Saturday";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	public static String MD(File source1) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		String output="";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = new FileInputStream(source1);				
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while( (read = is.read(buffer)) > 0) 
			{
				digest.update(buffer, 0, read);
			}		
			byte[] md5sum = digest.digest();
			//	System.out.print("Digets:"+md5sum);
			
			System.out.println();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			//System.out.println("MD5: " + output);
		}
		catch(IOException e) 
		{
			System.out.println("Unable to process file for MD5"+e);
		}
		return output;
	}
	
	public static boolean Copy(String source,String destination)
	{
		boolean result=false;
		try{
			InputStream inStream = null;
			OutputStream outStream = null;
    	    File afile =new File(source);
    	    File bfile =new File(destination);
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0)
    	    {
 
    	    	outStream.write(buffer, 0, length);
    	    	result =true;
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("File is copied successful!");
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	 return	result;
	}
	
	public static boolean uploadFile(String Path,String source)
			throws MalformedURLException, IOException {
		boolean flag=false;
		try
		{
			
		if (Path != null )
		{
		
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				URL url = new URL(Path);
				URLConnection urlc = url.openConnection();
			
				urlc.setDoOutput(true);
				System.out.println("-----" + urlc);
				bos = new BufferedOutputStream(urlc.getOutputStream());
				bis = new BufferedInputStream(new FileInputStream(source));
				String s = "";
				int i;
				// read byte by byte until end of stream
				while ((i = bis.read()) != -1)
				{
				//	System.out.println("iiiiiiiiii"+i);
					bos.write((byte) (char) i);
				}

			}
			finally
			{
				if (bis != null)
					try {
						bis.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
			}
			
		}
		else {
			System.out.println("Input not available.");
		}
		
		flag=true;
		}
		catch(Exception e)
		{
			System.out.println("OPP's Error is in UploadFile "+e);
		
		}
		
		return flag;
	}
	
	
	
	public static boolean downloadFile(String ip,String user,String pass,String fileName,String fnm)
	{
		boolean flag=false;
		try
		{
			/*File f=new File(root);
			if(!f.exists())
				f.mkdir();*/
			StringBuffer sb = new StringBuffer( "ftp://" );
			sb.append( user );
            sb.append( ':' );
            sb.append( pass );
            sb.append( '@' );
            sb.append( ip );
	        sb.append( '/' );
	        String a="cloud_project/";
	        sb.append( a );
	        sb.append( '/' );
	        sb.append( fnm );
	        System.out.println("in utility file name value is  "+fileName);
	        sb.append( ";type=i" );
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        URL url = new URL( sb.toString() );
	        System.out.println("in download url value is  "+url);
            URLConnection urlc = url.openConnection();
            bis = new BufferedInputStream( urlc.getInputStream());
            bos = new BufferedOutputStream( new FileOutputStream(fileName) );
            int i;
            while ((i = bis.read()) != -1)
            {
               bos.write( i );
               flag=true;
            }
            bis.close();
            bos.close();
        }
		catch(Exception e)
		{
			System.out.println("OPP's Error is in downloadFile "+e);
		}
		return flag;
	}
	public static boolean writeOnFile(String msg,String root)
	{
		System.out.println("msg :"+msg);
		boolean flag=false;
		try
		{
			PrintWriter pw = null;
			File f=new File(root);
			if(!f.exists())
				flag =f.createNewFile();
			pw = new PrintWriter(new FileWriter(f,true));
			pw.println(msg.trim());
			pw.flush();
			pw.close();
			flag=true;
			//System.out.println(msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static String getMD(String URL,String server,String name,String pass,String grpname,String fname)
	{
		String str1="";
		try 
		{ 
			URL url = new URL( URL+"/Verify?server="+server+"&name="+name+"&pass="+pass+"&grpname="+grpname+"&fname="+fname); 
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
			System.out.println("Get MD method is working properlyyy");
			str1 = in.readLine(); 
			in.close(); 
		}
		catch (Exception e)
		{ 
			e.printStackTrace(); 
		} 
		return str1;
	}
	
	///////////Encryption Decryption code

	public static byte[] encrypt(byte[] text,  PrivateKey key) throws Exception
	{
		byte[] cipherText = null;
		try
		{
			// get an RSA cipher object and print the provider
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			
			// encrypt the plaintext using the public key
			cipher.init(Cipher.ENCRYPT_MODE, key );
			cipherText = cipher.doFinal(text);
		}
		catch (Exception e)
		{
			throw e;
		}
		return cipherText;
	}
	
	
	
	public static byte[] decrypt(byte[] text, PublicKey key) throws Exception
	{
		byte[] dectyptedText = null;
		try
		{
			// decrypt the text using the private key
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			try {
				dectyptedText = cipher.doFinal(text);
			} catch (Exception e) {
				System.out.println("Exception ======== "+e);
				e.printStackTrace();
			}
			
			//System.out.println("dectyptedText ----------- "+dectyptedText);
		}
		catch (Exception e)
		{
			throw e;
		}
		return dectyptedText;
	}
	
	
}
