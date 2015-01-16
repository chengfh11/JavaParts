package junk;

import java.util.Comparator;
import java.util.Date;

class DateComparator implements Comparator<Date>
{

	public int compare(Date o1, Date o2)
	{

		if (o1.equals(o2))
		{
			return 0;
		}
		if (o1.before(o2))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}