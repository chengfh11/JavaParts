package junk;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class FileRead
{
	public static void main(String args[])
	{
		try
		{
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("C:\\development\\apache-tomcat-6.0.26\\apache-tomcat-6.0.26\\webapps\\pc-content\\trunk\\xml\\ip\\R\\SAT\\SA08\\R-SAT-SA08-P009.xml");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();
		}
		catch (Exception e)
		{// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}