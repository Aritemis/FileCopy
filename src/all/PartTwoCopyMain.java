/**
 *	@author Ariana Fairbanks
 */

package all;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PartTwoCopyMain 
{
	private static Scanner scan;
	private static URL source;
	private static File destination;
	
	public static void main(String[] args) throws MalformedURLException
	{
		scan = new Scanner(System.in);
		source = new URL(scan.next());
		destination = new File(scan.next());
		scan.close();
		
		try 
		{
			copy(source, destination);
		} 
		catch (IOException e) 
		{	e.printStackTrace();	}
	}
	
	private static void copy(URL source, File destination) throws IOException 
	{
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    try 
	    {
	        inputStream = source.openStream();
	        outputStream = new FileOutputStream(destination);
	        byte[] buffer = new byte[1];
	        int length;
	        while ((length = inputStream.read(buffer)) > 0)
	        {
	            outputStream.write(buffer, 0, length);
	        }
	    }
	    finally 
	    {
	        inputStream.close();
	        outputStream.close();
	        System.out.println("Done.");
	    }
	}
}
