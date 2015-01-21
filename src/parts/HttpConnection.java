package parts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author fcheng
 * @date Jan 21, 2015
 */
public class HttpConnection
{

	public static void main(String[] args) throws IOException
	{
		HttpConnection conn = new HttpConnection();
		conn.httpGet();
	}

	public String printout(String input)
	{
		return input;
	}

	public void httpGet()
	{
		try
		{
			URL oracle;
			oracle = new URL("http://www.medschoolpulse.com/feed");
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			{
				System.out.println(inputLine);
			}
			in.close();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}