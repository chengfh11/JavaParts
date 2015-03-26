package parts;

//Static import 
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


class FileRead
{
	public static void main(String args[])
	{
		String filePath = "C:\\development\\apache-tomcat-6.0.26\\apache-tomcat-6.0.26\\webapps\\pc-content\\trunk\\xml\\ip\\R\\SAT\\SA08\\R-SAT-SA08-P009.xml";
		FileRead read = new FileRead();
		read.oldReadFile(filePath);
	}

	public void oldReadFile(String path)
	{
		try
		{
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(path);
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

	/*
	 * java 7 reading file
	 */
	public void jdk7ReadFile(String path) throws IOException
	{
		out.println(new String(Files.readAllBytes(Paths.get("data_old.txt"))));
		out.println(new String(Files.readAllBytes(Paths.get("info.xml"))));
	}
}