package parts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ktpa.common.security.AESEncryptionUtil;

import org.junit.Test;

/**
 * 
 * @author fcheng
 *
 */
public class LmsLoginXML {
	public static void main(String args[]) {
		testEncryptTestXml();
	}

	@Test
	public static void testEncryptTestXml() {

		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.HOUR_OF_DAY, +1);
		cal.setTime(now);

		String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'EDT'";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String formatedDate = dateFormat.format(cal.getTime());


		String seekie = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">\n"
				+ "    <timestamp>"+formatedDate+"</timestamp>\n"
				+ "    <email>TestingEmptyLunaId1@test.com</email>\n"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>\n"
				+ "    <personId>23245663</personId>\n"
				+ "    <profileId>ptest06202</profileId>\n"
				+ "\n"
				+ "    <Enrollments>\n"
				+ "        <enrollment>\n"
				+ "            <id>382105</id>\n"
				+ "            <courseAccessId>944200213</courseAccessId>\n"
				+ "            <productCode>ACT</productCode>\n"
				+ "        </enrollment>\n"
//				+ "        <enrollment>\n"
//				+ "            <id>382108</id>\n"
//				+ "            <courseAccessId>964900909</courseAccessId>\n"
//				+ "            <productCode>PSATOL</productCode>\n"
//				+ "        </enrollment>\n"		
				+ "        <enrollment>\n"
				+ "            <id>382132</id>\n"
				+ "            <courseAccessId>954200225</courseAccessId>\n"
				+ "            <productCode>SAT</productCode>\n"
				+ "        </enrollment>\n"
//				+ "        <enrollment>\n"
//				+ "            <id>382101</id>\n"
//				+ "            <courseAccessId>944200209</courseAccessId>\n"
//				+ "            <productCode>APSATA2</productCode>\n"
//				+ "        </enrollment>\n"
//				+ "        <enrollment>\n"
//				+ "            <id>382102</id>\n"
//				+ "            <courseAccessId>944200210</courseAccessId>\n"
//				+ "            <productCode>APSAT2M</productCode>\n"
//				+ "        </enrollment>\n"
//				+ "        <enrollment>\n"
//				+ "            <id>382103</id>\n"
//				+ "            <courseAccessId>944200211</courseAccessId>\n"
//				+ "            <productCode>APSATXTU2</productCode>\n"
//				+ "        </enrollment>\n"
				+ "    </Enrollments>\n"
				+ "</kaptestSmartTrackStudent>";

		String encryptedSeekie = AESEncryptionUtil.encryptString(seekie);
		//System.out.println("xml --->>\n"+seekie);
		//System.out.println("Encrypted xml string \n" + encryptedSeekie);
		System.out.println(encryptedSeekie);
		String decryptedSeekie = AESEncryptionUtil.decryptString(encryptedSeekie);
	}

}

