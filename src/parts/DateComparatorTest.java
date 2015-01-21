package parts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class DateComparatorTest
{

	private static final String REGEXP_BOUNDARY = "\\b";
	private static final String formatString = "yyyy-MM-dd";

	public static Date getEndDate(Date meetingDate, int durationMinutes)
	{
		Calendar calculatedEndDate = Calendar.getInstance();
		calculatedEndDate.setTime(meetingDate);
		calculatedEndDate.add(Calendar.MINUTE, durationMinutes);
		return calculatedEndDate.getTime();
	}

	private static Date getWeekEndDate()
	{
		Date curr = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(curr);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}

	// previous week start date
	private static Date getWeekStartDate()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(getWeekEndDate());
		cal.add(Calendar.DAY_OF_YEAR, -6);
		return cal.getTime();
	}

	public static Date getDateFromOneMonthBefore()
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(new Date());
		rightNow.add(Calendar.MONTH, -1);
		return rightNow.getTime();
	}

	public static String timeSpent(long timeInMillis)
	{
		String output = "";
		if (getSeconds(timeInMillis) < 10)
		{
			output = getHours(timeInMillis) + ":" + getMinutes(timeInMillis) + ":0" + getSeconds(timeInMillis);
		}
		else
		{
			output = getHours(timeInMillis) + ":" + getMinutes(timeInMillis) + ":" + getSeconds(timeInMillis);
		}
		return output;
	}

	/**
	 * Convert a millisecond duration to minutes.
	 * 
	 * @param timeInMillis Millisecond duration,
	 * @return Minutes duration.
	 */
	public static long getHours(long timeInMillis)
	{
		return getMinutes(timeInMillis) / 60;
		/* long output = timeInMillis % 60; */
	}

	/**
	 * Convert a millisecond duration to minutes.
	 * 
	 * @param timeInMillis Millisecond duration,
	 * @return Minutes duration.
	 */
	public static long getMinutes(long timeInMillis)
	{
		return timeInMillis / (60 * 1000);
		/* long output = timeInMillis % 60; */
	}

	/**
	 * Convert a millisecond duration to seconds.
	 * 
	 * @param timeInMillis Millisecond duration.
	 * @return Seconds duration.
	 */
	public static long getSeconds(long timeInMillis)
	{
		long timeInSecs = timeInMillis / 1000;
		long output = timeInSecs % (60);
		return output;
	}

	static final String MINUTES_LABEL = " minute";
	static final String HOURS_LABEL = " hour";
	static final String PLURAL = "s";
	static final String COMMA = ", ";

	public static String getOnlineTimeHoursMinutes(long elapsedTime)
	{

		elapsedTime /= 1000;
		int seconds = (int) elapsedTime % 60;
		int minutes = (int) ((elapsedTime % 3600) / 60);
		int hours = (int) (elapsedTime / 3600);

		if (hours == 0 && minutes == 0)
		{
			return "none";
		}
		else
		{
			switch (hours)
			{
				case 0:
					return getOnlineMinutes(minutes, hours);
				case 1:
					return hours + HOURS_LABEL + getOnlineMinutes(minutes, hours);
				default:
					return hours + HOURS_LABEL + PLURAL + getOnlineMinutes(minutes, hours);
			}
		}
	}

	@SuppressWarnings(value = { "" })
	public static String getOnlineMinutes(int minutes, int hours)
	{
		String comma = COMMA;
		switch (minutes)
		{
			case 0:
				return "";
			case 1:
				if (hours == 0)
				{
					comma = "";
				}
				return comma + minutes + MINUTES_LABEL;
			default:
				if (hours == 0)
				{
					comma = "";
				}
				return comma + minutes + MINUTES_LABEL + PLURAL;
		}
	}

	public static float truncateDecimalNPlaces(float number, int places)
	{
		return Math.round(number * Math.pow(10, (float) places)) / (float) Math.pow(10, (float) places);
	}

	public static void main(String[] args)
	{

		System.out.println(new Date(1322965334890L));
		long start = System.currentTimeMillis();
		System.out.println(start);
		// singletonTest();
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) + " ms");

		/*
		 * StringBuilder tagsString = new StringBuilder();
		 * //System.out.println(tagsString.substring(0, tagsString.length() - 1));
		 * DecimalFormat oneDecimalPlace = new DecimalFormat("#.#");
		 * System.out.println(truncateDecimalNPlaces(57.1286F, 1));
		 * System.out.println(Float.valueOf(oneDecimalPlace.format(57.17286)));
		 * System.out.println("NOW "+new Date());
		 * System.out.println("Week start date: "+getWeekStartDate());
		 * System.out.println("Week end date: "+getWeekEndDate());
		 * Calendar cal = Calendar.getInstance();
		 * cal.setTime(new Date());
		 * //System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		 * long time1 = cal.getTimeInMillis();
		 * //cal.add(Calendar.MONTH, -1);
		 * //cal.add(Calendar.HOUR, -1);
		 * cal.add(Calendar.MINUTE, -10);
		 * long time2 = cal.getTimeInMillis();
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		 * calendar.add(Calendar.MONTH, -1);
		 * calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		 * calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		 * calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		 * Date firstDayOfLastMonth = calendar.getTime();
		 * System.out.println(firstDayOfLastMonth);
		 * calendar.add(Calendar.MONTH, 1);
		 * calendar.add(Calendar.DAY_OF_MONTH, -1);
		 * calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		 * calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		 * calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		 * Date lastDayOfLastMonth = calendar.getTime();
		 * System.out.println(lastDayOfLastMonth);
		 * //System.out.println(getOnlineTimeHoursMinutes(time1-time2));
		 * Map<String, Long> times = new TreeMap<String, Long>();
		 * times.put("assessmentProgressEmailTrigger",1300780800000L);
		 * times.put("deactivateRewardTrigger",1300788000000L);
		 * times.put("emailSenderTrigger",1300861185500L);
		 * times.put("jmsStartupTrigger",1300859810429L);
		 * times.put("kbsProductsUpdateTrigger",1300168800000L);
		 * times.put("pendingServiceTrigger",1300857270624L);
		 * times.put("remoteRewardTrigger",1300860730158L);
		 * times.put("rosterPayloadTrigger",1300849045475L);
		 * times.put("rosterPurgeTrigger",1300168800000L);
		 * times.put("smartScanFetchTrigger",1300860134752L);
		 * times.put("smartScanSearchTrigger",1300861330611L);
		 * times.put("smartScanSubmitTrigger",1300860134890L);
		 * times.put("smartScanSyncTrigger",1300860900000L);
		 * Iterator<Entry<String, Long>> it = times.entrySet().iterator();
		 * while (it.hasNext()) {
		 * Map.Entry pairs = (Map.Entry)it.next();
		 * System.out.println(pairs.getKey() + " = " + new Date((Long)pairs.getValue()));
		 * }
		 * Boolean flag = false;
		 * flag = flag==null?false:flag;
		 * if(!flag){
		 * System.out.println("Null");
		 * }
		 * Object obj = null;
		 * Boolean bool = (Boolean)obj;
		 * System.out.println("\nDate from long: "+new Date(1307531929592L));
		 * String testType = "AST";
		 * String regex = REGEXP_BOUNDARY+testType+REGEXP_BOUNDARY;
		 * String testTypes = "SAT,PSAT,ACT";
		 * Pattern pattern = Pattern.compile(regex);
		 * Matcher matcher = pattern.matcher(testTypes);
		 * //System.out.println(matcher.find());
		 * while(matcher.find() == true){
		 * int end = matcher.end();
		 * int start = matcher.start();
		 * System.out.println(end);
		 * System.out.println(start);
		 * }
		 * System.out.println("suffix: "+getDaySuffix(13));
		 * String los = "W-SAT-SA06,W-ACT-AC28";
		 * String prods = "";
		 * boolean locked = los.contains("W-SAT-SA06")
		 * ||false
		 * ||(matcher!=null?matcher.find():false);
		 * System.out.println(locked);
		 * //System.out.println(new Date().after(new Date()));
		 * DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 * List<Date> dates = new ArrayList<Date>();
		 * //Collections.sort(null, new DateComparator());
		 * Set<Date> sortedDates = new TreeSet<Date>(new DateComparator());
		 * try
		 * {
		 * Date date1 = df.parse("20/12/2005");
		 * Date date2 = df.parse("20/12/2003");
		 * Date date3 = df.parse("20/12/2004");
		 * Date date4 = df.parse("20/12/2006");
		 * Date date5 = df.parse("20/12/2009");
		 * Date date6 = df.parse("20/12/2001");
		 * Date date7 = df.parse("20/12/2007");
		 * Date date8 = df.parse("20/12/2011");
		 * Date date9 = df.parse("20/12/1999");
		 * Date date10 = df.parse("20/12/1980");
		 * dates.add(date1);
		 * dates.add(date2);
		 * dates.add(date3);
		 * dates.add(date4);
		 * dates.add(date5);
		 * dates.add(date6);
		 * dates.add(date7);
		 * dates.add(date8);
		 * dates.add(date9);
		 * dates.add(date10);
		 * sortedDates.addAll(dates);
		 * for(Date date:sortedDates){
		 * //System.out.println("Today = " + df.format(date));
		 * }
		 * } catch (ParseException e)
		 * {
		 * e.printStackTrace();
		 * }
		 */
	}

	private static void singletonTest()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 2);
		Date twoMonthsLater = cal.getTime();
		cal.add(Calendar.MONTH, -20);
		LinkedHashMap<String, SliderUsageData> usageData = new LinkedHashMap<String, SliderUsageData>();
		SliderUsageData sliderData = null;
		SliderUsageData june18SliderData = new SliderUsageData();
		int i = 0;
		while (cal.getTime().before(twoMonthsLater))
		{
			sliderData = new SliderUsageData();
			sliderData.setDate(getStringFromDate(cal.getTime(), formatString));
			if ("2010-06-18".equals(getStringFromDate(cal.getTime(), formatString)))
			{
				sliderData.setUsage("45");
				june18SliderData = sliderData;
			}
			else
			{
				sliderData.setUsage("0");
			}
			usageData.put(getStringFromDate(cal.getTime(), formatString), sliderData);
			cal.add(Calendar.DATE, 1);
			System.out.println((i++) + ": " + sliderData);
		}
		List<SliderUsageData> dataList = new ArrayList<SliderUsageData>();
		dataList.addAll(usageData.values());
		System.out.println("june18SliderData's index: " + dataList.indexOf(june18SliderData));
	}

	public static String getStringFromDate(Date theDate, String formatString)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern(formatString);
		return dateFormat.format(theDate);
	}

	private static String getDaySuffix(int day)
	{

		String suffix = "th";
		if (day != 11 && day != 12 && day != 13)
		{
			switch (day % 10)
			{
				case 1:
					suffix = "st";
					break;
				case 2:
					suffix = "nd";
					break;
				case 3:
					suffix = "rd";
					break;
			}
		}
		return suffix;
	}
}
