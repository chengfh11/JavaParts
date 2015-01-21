package parts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXML
{
	public static void main(String[] args) throws Exception
	{
		String temp = "";
		PrintWriter writer = new PrintWriter("/Users/archer/Desktop/Q1Result.xml");
		try
		{
			// Open the file that is the first
			FileInputStream fstream = new FileInputStream("/Users/archer/Desktop/Q1.json");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// System.out.println(strLine);
				temp = temp + strLine;
			}
			// Close the input stream
			in.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}

		JSONObject json = new JSONObject(temp);
		String question = json.getJSONObject("question").getJSONObject("components").getJSONObject("stem-1").getString("data");

		question = question.replace("<p>", "");
		question = question.replace("</p>", "");
		question = question.replace("<em>", "<emphasis>");
		question = question.replace("<>", "</emphasis>");
		question = question.replace("<i>", "<emphasis emphasis-type=\"italic\">");
		question = question.replace("</i>", "</emphasis>");
		question = question.replace("<strong>", "<emphasis emphasis-type=\"bold\">");
		question = question.replace("</strong>", "</emphasis>");

		System.out.println(question.toString());

		String xml = XML.toString(json);

		xml = xml + "</gradItems>";

		// System.out.print(xml);
		writer.println("<gradItems>");
		writer.println(xml);
		writer.close();
	}

}
