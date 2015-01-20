package parts;

import java.sql.Timestamp;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("Hello im here");

		// Print out current time
		System.out.println(new Timestamp(System.currentTimeMillis()));

		// Split string into array
		String url = "://www.medschoolpulse.com/feed   ,blog.kaplanlsat.com/feed,http://gmat.kaptest.com/feed,http://gre.kaptest.com/feed,http://blog.kaplansatact.com/feed,http://www.residencysecrets.com/feed,http://www.medschoolinsight.com/feed";
		String[] feedArray = url.split(",");

		for (String x : feedArray)
		{
			x = x.trim();
			if (!x.contains("http"))
			{
				x = "http://" + x;
			}
			System.out.println(" > " + x.trim() + "<");

		}
	}
}