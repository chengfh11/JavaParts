package parts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test
{

	public static void main(String[] args)
	{
		System.out.println("Hello im here");

		// accessing another class with main method
		HttpConnection test = new HttpConnection();
		System.out.println(test.printout("going there and back"));

		//accessing basic http get method
		test.httpGet();

		// Print out current time
		System.out.println(new Timestamp(System.currentTimeMillis()));

		// Split string into array
		String urlString = "www.medschoolpulse.com/feed  ,blog.kaplanlsat.com/feed,http://gmat.kaptest.com/feed,http://gre.kaptest.com/feed,http://blog.kaplansatact.com/feed,http://www.residencysecrets.com/feed,http://www.medschoolinsight.com/feed";
		List<String> result = splitArguments(urlString, ",");
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
	private static List<String> splitArguments(String sList, String splitKey)
	{
		List<String> list = new ArrayList<String>();

		for (String str : sList.split(splitKey))
		{
			str = str.trim();
			if (!str.contains("http"))
			{
				str = "http://" + str;
			}
			list.add(str);
		}
		return list;
	}
}