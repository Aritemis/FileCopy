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
	private static File imageSource;
	private static File imageDestination;
	
	public static void main(String[] args)
	{
		textSource = new File("C:/test/input.txt");
		textDestination = new File("C:/test/output.txt");
		binarySource = new File("C:/test/input.bin");
		binaryDestination = new File("C:/test/output.bin");
		imageSource = new File("C:/test/input.png");
		imageDestination = new File("C:/test/output.png");
		
		try 
		{
			copy(textSource, textDestination);
			copy(binarySource, binaryDestination);
			copy(imageSource, imageDestination);
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
