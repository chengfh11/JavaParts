package parts;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Archer Jan 21, 2015
 */
public class StringManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
