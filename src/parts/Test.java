package parts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("Hello im here");

		// Print out current time
		System.out.println(new Timestamp(System.currentTimeMillis()));

		// Split string into array
		String urlString = "www.medschoolpulse.com/feed  ,blog.kaplanlsat.com/feed,http://gmat.kaptest.com/feed,http://gre.kaptest.com/feed,http://blog.kaplansatact.com/feed,http://www.residencysecrets.com/feed,http://www.medschoolinsight.com/feed";
		List<String> result = splitArguments(urlString,",");
		for (String x : result)
		{
			System.out.println(">" + x + "<");
		}
	}

	/**
	 * Split the URL strings in to individual URL
	 * - some url house keeping aswell
	 * 
	 * @param urls
	 * @param splitKey
	 * @return
	 */
	private static List<String> splitArguments(String urls, String splitKey)
	{
		List<String> urlList = new ArrayList<String>();

		for (String url : urls.split(splitKey))
		{
			url = url.trim();
			if (!url.contains("http"))
			{
				url = "http://" + url;
			}
			urlList.add(url);
		}
		return urlList;
	}
}