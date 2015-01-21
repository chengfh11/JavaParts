package parts;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class Utils {

	private static SimpleDateFormat simpleDateFormat = new
	SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	public static Date stringToDate(String strFecha) throws ParseException
	{
		return simpleDateFormat.parse(strFecha);
	}

	public static XMLGregorianCalendar
	dateToXMLGregorianCalendar(String strFecha) throws ParseException,
	DatatypeConfigurationException
	{
		Date fecha = stringToDate(strFecha);

		return dateToXMLGregorianCalendar(fecha);
	}

	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date
			fecha) throws ParseException,
			DatatypeConfigurationException
			{
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(fecha);

		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			}

	public static void main(String[] args) throws IOException, ParseException, DatatypeConfigurationException {

		Object isCorporatePartner = null;
		boolean isCorporate = (Boolean)isCorporatePartner;
		System.out.println(isCorporate);
		
		
		
		/*		Date fecha = Utils.stringToDate("2011-02-28T06:43:21.0-05:00");
		System.out.println("The date:"+fecha);
		System.out.println(fecha.getTime());

		XMLGregorianCalendar calendar = Utils.dateToXMLGregorianCalendar(fecha);
		System.out.println("Calendar: "+calendar);
		System.out.println(calendar.toGregorianCalendar().getTime().getTime());

		java.sql.Timestamp timestamp = new
		java.sql.Timestamp(calendar.normalize()
				.toGregorianCalendar().getTimeInMillis());
		System.out.println(timestamp + " - " + timestamp.getTime());*/

	}


	public void setTimezone(Calendar source, XMLGregorianCalendar target) {
		if (source.getTimeZone() != null) {
			int rawOffset = source.getTimeZone().getRawOffset();
			if (rawOffset != 0) {

				target.setTimezone(Math.round(rawOffset / (60 * 1000)));
			}
		}


	}
}


