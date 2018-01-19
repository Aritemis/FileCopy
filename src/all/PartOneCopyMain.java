/**
 *	@author Ariana Fairbanks
 */

package all;

import java.io.*;
import java.util.Scanner;

public class PartOneCopyMain 
{
	private static Scanner scan;
	private static File source;
	private static File destination;
	
	public static void main(String[] args)
	{
		scan = new Scanner(System.in);
		source = new File(scan.next());
		destination = new File(scan.next());
		scan.close();
		
		try 
		{
			copy(source, destination);
		} 
		catch (IOException e) 
		{	e.printStackTrace();	}
	}
	
	private static void copy(File source, File destination) throws IOException 
	{
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    try 
	    {
	        inputStream = new FileInputStream(source);
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
