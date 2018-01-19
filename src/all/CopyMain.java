/**
 *	@author Ariana Fairbanks
 */

package all;

import java.io.*;

public class CopyMain 
{
	private static File textSource;
	private static File textDestination;
	private static File binarySource;
	private static File binaryDestination;
	
	public static void main(String[] args)
	{
		System.out.println("Start");
		textSource = new File("C:/test/input.txt");
		textDestination = new File("C:/test/output.txt");
		binarySource = new File("C:/test/input.bin");
		binaryDestination = new File("C:/test/output.bin");
		
		try 
		{
			copy(textSource, textDestination);
			copy(binarySource, binaryDestination);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void copy(File source, File dest) throws IOException 
	{
	    InputStream is = null;
	    OutputStream os = null;
	    try 
	    {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0)
	        {
	            os.write(buffer, 0, length);
	        }
	    }
	    finally 
	    {
	        is.close();
	        os.close();
	    }
	}
}
