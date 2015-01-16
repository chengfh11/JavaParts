package junk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ktpa.common.security.AESEncryptionUtil;

public class EncryptXML
{
	public static void main(String[] args)
	{
		testEncryptTestXml();
		testEncryptTestParentXml();
	}

	public static void testEncryptTestXml()
	{

		String updateSQL = "UPDATE \"student_service_profile\" "
				+ "\n"
				+ "INNER JOIN \"users\" ON \"users\".\"id\" = \"student_service_profile\".\"student_id\" "
				+ "\n"
				+ "SET \"course_access_id\" = '"
				+ "[course_access_id]"
				+ "', \"username\" = '"
				+ "[username]"
				+ "',\"student_service_profile\".\"modified_on\" = NOW(), \"student_service_profile\".\"modified_by\" = 10235303, \"users\".\"modified_on\" = NOW(), \"users\".\"modified_by\" = 10235303 "
				+ "\n" + "WHERE \"enrollment_id\" = " + "[enrollment_id]" + ";" + "\n";

		// System.out.println(updateSQL);

		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);

		// cal.add(Calendar.HOUR_OF_DAY, 1);

		String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'EST'";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		// System.out.println((cal.getTime()));
		String formatedDate = dateFormat.format(cal.getTime());
		String studentEmailString = "kaptest9475@mailinator.com";
		// String studentEmailString = "9kaplan@kaplan.com";
		String parentEmailString = "502@tomcheng.com";
		String hasNonSmartTrackCourses = "false";
		// String studentPersonId = "1504262557";
		String studentPersonId = "450211";
		String parentPersonId = "502502";
		// String studentProfileId = "1106900121";
		String studentProfileId = "1116702791";
		String parentProfileId = "5025025021";
		String studentEnrollmentId = "1003846268";
		// String studentEnrollmentId = "81229386";
		String studentCourseAccessId = "967754777";
		// String studentCourseAccessId = "81229386";
		String studentProductCode = "SCPALVO";
		// String studentProductCode = "AWAP";
		/*
		 * String seekie =
		 * "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
		 * "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">\n" +
		 * "    <timestamp>"+formatedDate+"</timestamp>\n" +
		 * "    <email>"+studentEmailString+"</email>" +
		 * "    <hasNonSmartTrackCourses>"+hasNonSmartTrackCourses+"</hasNonSmartTrackCourses>\n" +
		 * "    <personId>"+studentPersonId+"</personId>\n" +
		 * "    <profileId>"+studentProfileId+"</profileId>\n" +
		 * "\n" +
		 * "    <Enrollments>\n" +
		 * "        <enrollment>\n" +
		 * "            <id>"+studentEnrollmentId+"</id>\n" +
		 * "            <courseAccessId>"+studentCourseAccessId+"</courseAccessId>\n" +
		 * "            <productCode>"+studentProductCode+"</productCode>\n" +
		 * "        </enrollment>\n" +
		 * "    </Enrollments>\n" +
		 * "</kaptestSmartTrackStudent>";
		 */

		/*
		 * String seekie = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" +
		 * "    <timestamp>2010-08-16T17:09:24EDT</timestamp>" +
		 * "    <email>1111kaplanstudent@mailinator.com</email>" +
		 * "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" +
		 * "    <personId>1504295177</personId>" +
		 * "    <profileId>QA1967311831</profileId>" +
		 * "    <Enrollments>" +
		 * "        <enrollment>" +
		 * "            <id>1003846755</id>" +
		 * "            <courseAccessId>971300594</courseAccessId>" +
		 * "            <productCode>ACTOLB</productCode>" +
		 * "        </enrollment>" +
		 * "    </Enrollments>" +
		 * "</kaptestSmartTrackStudent>";
		 */

		String s1 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "<timestamp>" + formatedDate + "</timestamp>" + "<email>903@tomcheng.com</email>"
				+ "<hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "<personId>1504281359</personId>" + "<profileId>1116701718</profileId>" + "<Enrollments>" + "	<enrollment>"
				+ "		<id>1003847639</id>" + "		<courseAccessId>978900032</courseAccessId>" + "		<productCode>ACT</productCode>" + "	</enrollment>" + "	<enrollment>"
				+ "		<courseAccessId>964900909</courseAccessId>" + "		<productCode>PSATOL</productCode>" + "	</enrollment>" + "	<enrollment>" + "		<id>1003844869</id>"
				+ "		<courseAccessId>963700646</courseAccessId>" + "		<productCode>SATPOP</productCode>" + "	</enrollment>" + "</Enrollments>" + "</kaptestSmartTrackStudent>";

		String s2 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>0914student@mailinator.com</email>"
				+
				// "    <email>jose.arzuaga@mailinator.com</email>" +
				"    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <personId>1504310957</personId>" + "    <profileId>QA1967312457</profileId>" + "    <Enrollments>"
				+ "        <enrollment>" + "            <id>1003848968</id>" + "            <courseAccessId>981000216</courseAccessId>" + "            <productCode>SATPOP</productCode>"
				+ "       </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String s3 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>kaptest9475@mailinator.com</email>"
				+
				// "    <email>kaptest@yahoo.com</email>" +
				"    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1116702791</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1003846268</id>" + "            <courseAccessId>967754777</courseAccessId>" + "            <productCode>SCPALVO</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String student09232010 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate
				+ "</timestamp>"
				+
				// "    <email>09232010student1@mailinator.com</email>" +
				"    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <personId>1504315557</personId>" + "    <profileId>QA1967312552</profileId>" + "    <Enrollments>"
				+ "        <enrollment>" + "            <id>1003849865</id>" + "            <courseAccessId>981900333</courseAccessId>" + "            <productCode>SCPALVO</productCode>"
				+ "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String seekie = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate
				+ "</timestamp>"
				+ "    <email>40nigelstudent@mailinator.com</email>"
				+
				// "    <email>jrarzuaga@hotmail.com</email>" +
				"    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1116702558</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1003845853</id>" + "            <courseAccessId>966063498</courseAccessId>" + "            <productCode>SATCLVO</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String newStudent = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>11112010student@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>QA1967313431</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <id>1018209804</id>" + "            <courseAccessId>993300381</courseAccessId>"
				+ "            <productCode>ACTOLB</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String brian = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>byoung-student201101071@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>QA1967313912</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <id>1018230656</id>" + "            <courseAccessId>997800259</courseAccessId>"
				+ "            <productCode>SATCLVO</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String progressEmail = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "   <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>20110112student1@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1151100709</profileId>" + "    <Enrollments>"
				+ "        <enrollment>" + "            <id>1018232258</id>" + "            <courseAccessId>997800887</courseAccessId>" + "            <productCode>SATPOP</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <courseAccessId>997800874</courseAccessId>" + "            <productCode>SAT</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <courseAccessId>997800873</courseAccessId>" + "            <productCode>ACT</productCode>" + "        </enrollment>" + "    </Enrollments>"
				+ "</kaptestSmartTrackStudent>";

		String yo = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>jose.arzuaga@mailinator.com</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1151300845</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <courseAccessId>999401333</courseAccessId>" + "            <productCode>ACT</productCode>" + "        </enrollment>" + "    </Enrollments>"
				+ "</kaptestSmartTrackStudent>";

		String liveOnline = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>pc7student@mailinator.com</email>    " + "	 <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <personId>1504310197</personId>"
				+ "    <profileId>1134300899</profileId>" + "    <Enrollments>" + "        <enrollment>" + "            <id>1003848870</id>" + "            <courseAccessId>978901610</courseAccessId>"
				+ "            <productCode>ACTCLVO</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String tutoring = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>tutoringStudent1@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1151500055</profileId>" + "    <Enrollments>"
				+ "        <enrollment>" + "            <id>1018265711</id>" + "            <courseAccessId>1006200104</courseAccessId>" + "            <productCode>APACTB</productCode>"
				+ "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String satTutoring = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>tutoringStudent1@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1151500055123554</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <id>10182657144564351</id>" + "            <courseAccessId>10062asdf4564a00104</courseAccessId>"
				+ "            <productCode>APSAT2</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String premTutoring = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>tutoringStudent1@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>11515000551111</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <id>121314151617181910</id>" + "            <courseAccessId>a</courseAccessId>"
				+ "            <productCode>APAPM</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String flashCardsBundle = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\"> " + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "	<email>no-flashcards@mailinator.com</email>" + "	<hasNonSmartTrackCourses>true</hasNonSmartTrackCourses> " + "    <personId>1523300531112011</personId>"
				+ "    <profileId>1185300372112011</profileId>" + "    <Enrollments>" + "        <enrollment>" + "            <id>10241966311124111</id>"
				+ "            <courseAccessId>103290032011124qwerty</courseAccessId>" + "            <productCode>SATPOP</productCode>" + "        </enrollment>" + "    </Enrollments>"
				+ "</kaptestSmartTrackStudent>";

		String megaBundle = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\"> " + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "	<email>no-flashcards@mailinator.com</email>" + "	<hasNonSmartTrackCourses>true</hasNonSmartTrackCourses> " + "    <personId>1523300531112011</personId>"
				+ "    <profileId>1185300372112011</profileId>" + "    <Enrollments>" + "        <enrollment>" + "            <id>10241966311124111</id>"
				+ "            <courseAccessId>103290032011124qwerty</courseAccessId>" + "            <productCode>SATPOP</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <id>121314151617181sdfa911</id>" + "            <courseAccessId>b</courseAccessId>" + "            <productCode>DFCAPWH</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>12131415161718191122</id>" + "            <courseAccessId>asdfdddd</courseAccessId>" + "            <productCode>DFCAPHG</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>121314151617181911</id>" + "            <courseAccessId>b</courseAccessId>"
				+ "            <productCode>APAPM</productCode>" + "        </enrollment>" + "        <enrollment>" + "            <id>121314151617181910</id>"
				+ "            <courseAccessId>a</courseAccessId>" + "            <productCode>APSAT2M</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <courseAccessId>10367002461</courseAccessId>" + "            <productCode>SCPALVO</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <id>1003848870111</id>" + "            <courseAccessId>978901610ssss</courseAccessId>" + "            <productCode>ACTCLVO</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>1003848870111122</id>" + "            <courseAccessId>978901610sdf</courseAccessId>" + "            <productCode>ACT</productCode>"
				+ "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String flashCardsStandAlone = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\"> " + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "	 <email>act.flashcards.student@mailinator.com</email>" + "	<hasNonSmartTrackCourses>false</hasNonSmartTrackCourses> " + "    <profileId>1188900073</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <courseAccessId>1036700104</courseAccessId>" + "            <productCode>ACTFRCD</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String cpa = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>cpa.student.jose@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1188900167</profileId>" + "    <Enrollments>"
				+ "        <enrollment>" + "            <courseAccessId>1036700246</courseAccessId>" + "            <productCode>SCPALVO</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String satOnly = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>sat.only.student@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1188900167123</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <courseAccessId>1036700246444</courseAccessId>" + "            <productCode>SATX</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String psatLvo = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>psatlvo.student@mailinator.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>11889002361321111</profileId>"
				+ "    <Enrollments>" + "        <enrollment>" + "            <id>10367003011231111</id>" + "            <courseAccessId>10123136700301111</courseAccessId>"
				+ "            <productCode>PSATLVO</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String ccss = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>pilot@kaplan.com</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1025622889</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1025622889</id>" + "            <courseAccessId>1036700301111</courseAccessId>" + "            <productCode>CCSS7ELA</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String precol1787 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>"
				+ "    <email>phuc_test2012@yahoo.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "	<personId>2100000880</personId>"
				+ "    <profileId>1199500029</profileId>" + "    <Enrollments>" + "        <enrollment>" + "            <id>2100001120</id>"
				+ "            <courseAccessId>1053500057</courseAccessId>" + "            <productCode>SATPOP</productCode>" + "        </enrollment>" + "    </Enrollments>"
				+ "</kaptestSmartTrackStudent>";

		String precol1787_2 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>2013-04-01T20:20:43EST</timestamp>"
				+ "    <email>06july2012_hst@yahoo.com</email>" + "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <personId>21000088</personId>"
				+ "    <profileId>12000000</profileId>" + "    <Enrollments>" + "        <enrollment>" + "            <id>10400000</id>" + "            <courseAccessId>10540000</courseAccessId>"
				+ "            <productCode>SAT</productCode>" + "            <entryDate>2012-03-30</entryDate>" + "        </enrollment>" + "        <enrollment>" + "            <id>21000016</id>"
				+ "            <courseAccessId>10400000</courseAccessId>" + "            <productCode>SATPOP</productCode>" + "        </enrollment>" + "    </Enrollments>"
				+ "</kaptestSmartTrackStudent>";

		String encyrpted = " Nidymn2I1z1d9cGdBaimmM5DDY826y7Nw9WwdFr4wvPTALaiDtj89rET1fJlX9zNYOKzfRa0zkd9 KeyGt2R7OrlZhg/vED4gxFXBJsASLdiBLKvdu5vXwzSh6luNRalSBGsXdKx0W+piSMq3+CFA3djq fQwSZzs2la0GXiLA+2Mw6SRyBYoNz0nNHKDE/WogkckAs6r1XosIn2cgX7HzGWjUTHTbf4bxjsH7 YucUOBP/LeZuPp2mlyiCpmanIgiCHMGeH2hTp6HLB0dOuaW+mvSuDkIDxW/Wp1RVhCAzkuYBjghS z1/HCdBSLl+lMgoCKVVf0/xrq+ikPKoSfGWFerU641C2qosTnyM+oaB0GLLJbMUgNvazoLBjwVli IjjgHpCLlyFqfIFt2XoyEpf1mavViLSo2GXkCKNtb5IwdD5/4wZfz0ZpxSbbVvHc8m1qHWPxSjGG JgoRsSc3TKK9mSvsE5SWzFoil10NI1ou5EMlb8a/YiFATnCwJIM0fnxY4TPX6usHPAZneQVyXacu eeV6jg681YWWokG4aqTwHoSIfRscbTar6BC0h2hJyoAXA3oayU7kE/yFdyqjEnEru/nac/JRqciY dA4l9mrrLnWKJfKg8lUcN/qrJtPk4Z99RipwKuxClaKuYx578ZyRcR8l/wxuanHcjwT/kQ7TPxcr KQkb1n15Ni9kYJQ/8dngktRPN4rgXDexJSk23FqTRb2IAG59QREKifV8wNiHdJj5iWXS/1Rb5zJP GuDdWF4Xkyv5mg2NKVkLTvb8pWj73XHTOdLprKRzo0nuCB+GRAxYjgONKh9Ct2sSSQUPPe+wxblm 9xRgWFxjwGahY0bEqtNueMYXs1JCEUk/o65zyyU1yPm1q1TK+XK7OexmwW6z4xSLhqEb+G3AYBQv cjvJ9D2Oqe6OR1FbT6iU392zoQuSpH7irKyBC6wG7kF5SSUphFpQeiTffrK1yI1SMx0oZghlA5w3 StWs21NYm2Tul9AT8jSiEGCfohqLfj2M4aiVBtFcYYLw9NmETs3bV2ksi3yoPgK0ydqnU4VhP6aV pULQIOB08SShcnwFKsD6mqUebYDeQqLqoT4raoX5obwaiEfqsYg0GK4qx1dHzUQkKF4YUBa1IZbL QjVeSkkfnHMnANy1wmOj9ygueTgxVIz5hS+Y0Bcpm6W5DPDGtnlTbjBKgxPEcql6uhgQKjSnq4zP";

		System.out.println(formatedDate);
		String jose16 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>douglas@ediy.cr</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>123456789101112</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>999999999</id>" + "            <courseAccessId>abcdefghijklmno999</courseAccessId>" + "            <productCode>SCPALVO</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>9999999999</id>" + "            <courseAccessId>abcdefghijklmno9999</courseAccessId>" + "            <productCode>DFCAPHG</productCode>"
				+ "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String standAlone = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>jose.18@olpt.com</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>2222222221</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>222555555511111111</id>" + "            <courseAccessId>444433333</courseAccessId>" + "            <productCode>OLPT6SAT</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>222555555551111111</id>" + "            <courseAccessId>444443333</courseAccessId>" + "            <productCode>OLPT6ACT</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>222555555555111111</id>" + "            <courseAccessId>444444333</courseAccessId>"
				+ "            <productCode>OLPT10SAT</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String taiACT = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>jose.18@olpt.com</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>2222222221</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1111111111111111</id>" + "            <courseAccessId>11111111</courseAccessId>" + "            <productCode>SATPOP</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>2111111111111111</id>" + "            <courseAccessId>21111111</courseAccessId>" + "            <productCode>SATPOP</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>2211111111111111</id>" + "            <courseAccessId>22111111</courseAccessId>"
				+ "            <productCode>SAT</productCode>" + "        </enrollment>" + "        <enrollment>" + "            <id>222111111111111111</id>"
				+ "            <courseAccessId>33322222</courseAccessId>" + "            <productCode>SAT</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <id>222231111111111111</id>" + "            <courseAccessId>33333322</courseAccessId>" + "            <productCode>ACTOLB</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>222241111111111111</id>" + "            <courseAccessId>33333332</courseAccessId>" + "            <productCode>ACTOLB</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>222511111111111111</id>" + "            <courseAccessId>333233333</courseAccessId>"
				+ "            <productCode>ACTCLVO</productCode>" + "        </enrollment>" + "        <enrollment>" + "            <id>222551111111111111</id>"
				+ "            <courseAccessId>333333333</courseAccessId>" + "            <productCode>ACTCLVO</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <id>222555111111111111</id>" + "            <courseAccessId>433333333</courseAccessId>" + "            <productCode>PSATOL</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>222555511111111111</id>" + "            <courseAccessId>433333333</courseAccessId>" + "            <productCode>PSATOL</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>222555551111111111</id>" + "            <courseAccessId>443333333</courseAccessId>"
				+ "            <productCode>SATCLVO</productCode>" + "        </enrollment>" + "        <enrollment>" + "            <id>222555555111111111</id>"
				+ "            <courseAccessId>444333333</courseAccessId>" + "            <productCode>SATCLVO</productCode>" + "        </enrollment>" + "        <enrollment>"
				+ "            <id>222555555511111111</id>" + "            <courseAccessId>444433333</courseAccessId>" + "            <productCode>OLPT6SAT</productCode>" + "        </enrollment>"
				+ "        <enrollment>" + "            <id>222555555551111111</id>" + "            <courseAccessId>444443333</courseAccessId>" + "            <productCode>OLPT6ACT</productCode>"
				+ "        </enrollment>" + "        <enrollment>" + "            <id>222555555555111111</id>" + "            <courseAccessId>444444333</courseAccessId>"
				+ "            <productCode>OLPT10SAT</productCode>" + "        </enrollment>" + "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String jose18 = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>jose.20@1.com</email>"
				+ "    <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1234567891011</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1234567891011</id>" + "            <courseAccessId>abcdefgh</courseAccessId>" + "            <productCode>PSATOS</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String qa3tests = "<kaptestSmartTrackStudent xmlns=\"kaptest/services/kaptestSmartTrack\">" + "    <timestamp>" + formatedDate + "</timestamp>" + "    <email>sat3776@1.com</email>    "
				+ "	 <hasNonSmartTrackCourses>false</hasNonSmartTrackCourses>" + "    <profileId>1205317551</profileId>" + "    <Enrollments>" + "        <enrollment>"
				+ "            <id>1003848870</id>" + "            <courseAccessId>1058400627</courseAccessId>" + "            <productCode>ACTPOP</productCode>" + "        </enrollment>"
				+ "    </Enrollments>" + "</kaptestSmartTrackStudent>";

		String encryptedSeekie = AESEncryptionUtil.encryptString(qa3tests);
		// String encryptedProd =
		// "Nidyjmn2I1z1d9cGdBaimmM5DDY826y7Nw9WwdFr4wvPTALaiDtj89rET1fJlX9zNYOKzfRa0zkd9KeyGt2R7OrlZhg/vED4gxFXBJsASLdiBLKvdu5vXwzSh6luNRalSBGsXdKx0W+piSMq3+CFA3djqfQwSZzs2la0GXiLA+2Mw6SRyBYoNz0nNHKDE/Wogmusz28WEmEKg78uLHXuDVxWfr/U23ha7c0CY7KmeVXcop/KOn27Wto/aSVgc2fgXQmDPCQYNRYuNRW4Rk8diRfArc9gO3UkogZBAN1U8XAMA1/2k32XZmZKQsLuLpGk0DHZFWyvRqbXKi0QO4ZpHCGbjMXPybhO+mmAhqoedEmobwhkYkZRlrtcXnIgd03sEDXhQqd/DmU28WecyCz5gKA5Q1MrMBWfNNXOb4Or6C+foIPXU78NHvOxBlQH8D5GoADKxrGhbGHV2wYrtc0gRdaN/fmy4CzTJL09jGy6XA9Wb0VOaKYFhLup7EKyrxW73rU4JnxWn+quV2Q9VKnoUFKcxwzziT3u/dI4rEmijlrocPGal025ouUI5bMF8tJALWbYrUZ/a6aMlBOu+EutsG7p74CykmoyZ8qMMLI5NLFD533+ND2vW5/s88f2l8suIpZMrziZxrK8Xt0UbYEZqqY9WtsqBTRU4pClYjYWfbdoPaRZQluvqOlykBZEUKCohtKjNbPjR0xtIAeA1eLNS72Q0kgmMcs1Y6Seiyp4GH1UbMRN+fAc8QhTa1VdodK1K68ghOaek7055OTfcXk2ZqpiUtD1ElHno2gJ93ab905DTbpfMHrwDrOS9QebJYLsSRkGhjpyblVTEu4+SmgGEq4cX5vJGZDFWTBPJZun8TYYplUPSxIhNOdcfyewZMpjtzeDuZNlO8OasKDXJQbyFFYqCxTGx4FWVuXegsFkhE1cLTxWYSbaS5ngsEu6Iw746r4tixgPBNTGnuKwh+Z0r/m/nInE19RGdl3ze5lAGu0veVVMGTd8B/KxfqnePGJJFbayROSWC7aXvDh3zDi27HM0T76HoMhsTucFWwYBqlTyV04AEhDDTF3IGbWTIJq5WEjlkxd0r1CaiHBF0+MnyDy9aWCpA1dkcNzl3Xk+UzvonW58THWcR6iKLHDU7EBIWThNAVunf5qW2XCVd+EK0Llx0cNpFxKBg7eOpFQjI4JkbdsaC6bzB+wrlPbsPzui5VeT4gyBk5F55WCAORdjjkhCQFdpQLd9+Y7m8LnqdAv68vPw5bO3K286xMnqJNxyqu1U8prbc7Qqo99pOJSnwZSp1wOgsjaFm7oiHrreGObNwBvnqXUuzqxFSlCL8T8IFsqnw9cWa4r5FCAUFGcAbImdAAd8x7OpYTFiEYWeOu2WbgK8pz6vLobwGnGGzyBCKwfJS6KAvNIt4NnWwKT7mKc8DbSenHXLqFtBoz+BXxlQ4Or+i764JkQLPHemHRtXkNTDxBouw4wqGzJR3623HozeZ+NUhQwLIxHL3W95Wh4i6D0WEXx1pKN6SEA6aNuW8KufRlTGETf5gZ7bsvuT5JjPiCAV7f0QXdDuThG7kzlBPx6eS++Gbj0LZHw/BrUz+N5rtLEsB7+UyWZL7V9q6E4qLcuKtJTEd1dC7zwjCQBypqVxgKTk0FHj3kSlDqihXU6OF8wCs2dfnCGukWKczZJaNWfowGj0EgbeWYbKZD2Ux6dJ04D0j2IzAKtoEzh8lzEes73EDZqLwYR0U2pfpnA==";
		String encryptedProd = "BGbvvDzt6YfH/M29UKI95h8LIhkkda4Je5Zz8rQZSt+4FsDMYTh4ELNk/CyqJ1zSn7i9llSgHIAeR1TtGu9eAdH0OJsz2h8kdvElEXE7sML0aT1Cx8IX5F/SExqZCVVRGKr4bseEkLc/JWALhflEIyVYc3yFJY6MI9Y2FCF2P5bJ2JTkobJcXnSJn2NB6mDOjar/g7nqteZQ4J+U+yuFZpm6qK3zmizvw2dG57XoMzbelU9u05FjDOv96RoBG+mGuPoi3+ZxEWHX5XER6eeJFDyqIpbEuQk4m4EFIml4i1khYWZs7FEGED6rPSBx4elEEuVWMATkZh2FuSnZDoOmNGaI1Hz5Jjj1F1yt6043m0XEpmjKpLNNVs2Azn+VZZ3s+qHbicxcYWbGvZQtqhz8jVk3lDWvgsb+MhjuHoQkI0Qy9QWsghfqthzQOGD6cFlhkdiBlhCK8/Fm/1se2GrI4hn0kWKmU/n0FnHZU6W/BKbXdynxHJ62k5OFcBV4X3q4BzWJ+Duxtblnq7CzQrcGJgspgbcBQ7YzIWYaT+2Vndovny9j/LPj1hlS5OQ9pCTvac9u6atjl4bAonTdUa+TwVbonHVffpXniyiz7phNm2SPgCvJ8Iy0joPQaQfaOIBftSJcxzh4PWMvNrnNiSKksBNYlyhFef8ccFmR0apxllJ/loF08vWTwOuW79YrTdoFkpCDHf/C4HWj7IrkvvjigZ1sw7XWwlA1GnGWvbIn2by/juOOovGYRahUUwi+F/zMzE9Y8zHUIpwmt6ZTVfPI9WFwG9uZfCliXHC27mmNwDHUqodTk7m07KNCJRf2uy12PPiOn+CuAKHvw/Hgoy2cEYNONuxl+YqvEvcJMFXVe2Q=";

		System.out.println("Valid Key?" + AESEncryptionUtil.isValidKeyName("KTPA_Default"));

		// System.out.println(AESEncryptionUtil.decryptString(encyrpted));
		// BrowserLaunch.openURL("http://localhost:8082/smarttrack/kaptest/login.spr?param="+encryptedSeekie);
		System.out.println("Encrypted xml string with null person id\n" + encryptedSeekie);

		String decryptedSeekie = AESEncryptionUtil.decryptString(encryptedProd);

		System.out.println("\n\nDecrypted xml string with request timeout \n\n" + decryptedSeekie);

	}

	public static void testEncryptTestParentXml()
	{
		Date now = new Date();
		String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'EDT'";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		// System.out.println(dateFormat.format(now));
		String formatedDate = dateFormat.format(now);

		String seekie = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + "<kaptestSmartTrackParent xmlns=\"kaptest/services/kaptestSmartTrack\">\n" + "    <timestamp>"
				+ formatedDate + "</timestamp>\n" + "    <email>kaplan@kaplan.com</email>" + "    <personId>003</personId>\n" + "    <profileId>003</profileId>\n" + "\n" + "    <Persons>\n"
				+ "        <person>\n" + "            <id>001</id>\n" + "        </person>\n" + "    </Persons>\n" + "</kaptestSmartTrackParent>";

		String encryptedSeekie = AESEncryptionUtil.encryptString(seekie);

		// System.out.println("Encrypted xml string with for parent\n"+encryptedSeekie);

		String decryptedSeekie = AESEncryptionUtil.decryptString(encryptedSeekie);

		// System.out.println("\n\nDecrypted xml string with request timeout \n\n"+decryptedSeekie);

	}

}
