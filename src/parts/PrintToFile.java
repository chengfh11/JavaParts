/**
 * 
 */
package parts;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author fcheng
 * @date Jan 29, 2015
 */
public class PrintToFile
{
	public static void main(String[] args)
	{
		String str = "stesteatdfkja askdjfakjf jfaklsfj;df ";
		// print stuff to file
		PrintWriter output;
		try
		{
			output = new PrintWriter("/Users/archer/Downloads/test.html");
			output.println(str);
			output.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
