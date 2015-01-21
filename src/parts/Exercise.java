package parts;

import org.apache.commons.lang.StringUtils;

public class Exercise
{
	public static void main(String[] args)
	{
		System.out.println("Hello im here");

		System.out.println();

		new Exercise().sleepIn(false, false);
		new Exercise().sleepIn(true, false);
		new Exercise().sleepIn(false, true);
		new Exercise().sleepIn(true, true);

		String sessionId = "test";
		if (StringUtils.isEmpty(sessionId))
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(2);
		}
	}

	/*
	 * The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation.
	 * We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
	 */
	public boolean sleepIn(boolean x, boolean y)
	{
		if (!x || y)
		{
			return true;
		}
		return false;
	}
}