package parts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datetime
{
	public static void main(String[] args)
	{
		// DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String t1 = "2013-01-31";
		String t2 = "01-01-2013";
		Date date = new Date();
		Date start = null;
		Date end = null;
		Date now = null;
		String current = df.format(date);
		try
		{
			start = df.parse(t1);
			end = df.parse(t2);
			now = df.parse(current);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		System.out.println("start >> " + df.format(start));
		System.out.println("end >> " + df.format(end));
		System.out.println("now >> " + df.format(now));

		if (now.after(start) && now.before(end))
		{
			System.out.println("active");
		}
		else if (now.after(end))
		{
			System.out.println("inactive");
		}
		else if (now.before(start))
		{
			System.out.println("pending");
		}
		else
		{
		}
	}
}
