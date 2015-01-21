package parts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ApplyWiseTest
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();

		String str = "writing.runons";
		String str1 = "writing.transitions";
		String str2 = "writing.pronouns";
		String str3 = "writing.comp.amb";
		String str4 = "writing.modifiers";
		String str5 = "writing.vt.pass";
		String str6 = "writing.subjectverb";
		String str7 = "writing.parallel";
		String str8 = "writing.idioms";
		String str9 = "writing.wordiness";
		String str10 = "writing.rc.dict";
		String str11 = "geo.graphs";
		String str12 = "logdata.other";
		String str13 = "geo.triangles";
		String str14 = "alg.inequalities";
		String str15 = "geo.polygons";
		String str16 = "geo.complexfigures";
		String str17 = "alg.avg.per";
		String str18 = "logdata.analysis";
		String str19 = "alg.functions";
		String str20 = "alg.ratios";
		String str21 = "geo.angles";
		String str22 = "alg.equations";
		String str23 = "arith.divisibility";
		String str24 = "alg.probability";
		String str25 = "geo.quadratics";
		String str26 = "logdata.logic";
		String str27 = "geo.coordinateplane";
		String str28 = "logdata.sets";
		String str29 = "arith.exponents";
		String str30 = "rc.function";
		String str31 = "sc.causeeffect";
		String str32 = "sc.contrast";
		String str33 = "rc.vocab";
		String str34 = "rc.inference";
		String str35 = "rc.detail";
		String str36 = "rc.global";
		String str37 = "sc.definition";

		list.add(str);
		list.add(str1);
		list.add(str2);
		list.add(str3);
		list.add(str4);
		list.add(str5);
		list.add(str6);
		list.add(str7);
		list.add(str8);
		list.add(str9);
		list.add(str10);
		list.add(str11);
		list.add(str12);
		list.add(str13);
		list.add(str14);
		list.add(str15);
		list.add(str16);
		list.add(str17);
		list.add(str18);
		list.add(str19);
		list.add(str20);
		list.add(str21);
		list.add(str22);
		list.add(str23);
		list.add(str24);
		list.add(str25);
		list.add(str26);
		list.add(str27);
		list.add(str28);
		list.add(str29);
		list.add(str30);
		list.add(str31);
		list.add(str32);
		list.add(str33);
		list.add(str34);
		list.add(str35);
		list.add(str36);
		list.add(str37);

		for (String string : list)
		{
			String displayCode = "";
			// System.out.println("code: "+string);
			// System.out.println("string.split: " + string.split("\\.").length);
			if (string.split("\\.").length > 0)
			{
				for (String st : string.split("\\."))
				{
					displayCode += st;
					// System.out.println("displayCode: "+displayCode);
				}
			}
			else
			{
				displayCode = string;
			}
			// System.out.println("return "+displayCode);
		}

		try
		{

			String resource = "ShoppingCart.aspx?";
			String prodName = "ApplyWise";
			String promoCode = "SPXX9000";
			String firstName = "Scott";
			String lastName = "Ma Zumoto";
			String address1 = "15 Windemere Dr";
			String address2 = "Suite 400";
			String city = "Kalamazoo";
			// String state ="MI";
			String zipCode = "20020";
			String country = "United States";
			String email = "scott@matsumoto.com";
			String gradYear = "2011";
			String courseAccessID = "123s1s1w";

			System.out.println(URLEncoder.encode(",", "UTF-8"));
			/*
			 * System.out.println(URLEncoder.encode(resource, "UTF-8"));
			 * System.out.println(URLEncoder.encode(prodName, "UTF-8"));
			 * System.out.println(URLEncoder.encode(promoCode, "UTF-8"));
			 * System.out.println(URLEncoder.encode(firstName, "UTF-8"));
			 * System.out.println(URLEncoder.encode(lastName, "UTF-8"));
			 * System.out.println(URLEncoder.encode(address1, "UTF-8"));
			 * System.out.println(URLEncoder.encode(address2, "UTF-8"));
			 * System.out.println(URLEncoder.encode(city, "UTF-8"));
			 * System.out.println(URLEncoder.encode(state, "UTF-8"));
			 * System.out.println(URLEncoder.encode(zipCode, "UTF-8"));
			 * System.out.println(URLEncoder.encode(country, "UTF-8"));
			 * System.out.println(URLEncoder.encode(email, "UTF-8"));
			 * System.out.println(URLEncoder.encode(gradYear, "UTF-8"));
			 * System.out.println(URLEncoder.encode(courseAccessID, "UTF-8"));
			 */

		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager()
		{
			public java.security.cert.X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
			{
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
			{
			}
		} };

		// Install the all-trusting trust manager
		try
		{
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		catch (Exception e)
		{
		}

		//
		// Probably best to put this code in a function somewhere...
		//
		HostnameVerifier hv = new HostnameVerifier()
		{
			public boolean verify(String urlHostName, SSLSession session)
			{
				// System.out.println("Warning: URL Host: "+urlHostName+" vs. "+session.getPeerHost());
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(hv);

		try
		{
			// Construct data
			String data = URLEncoder.encode("FN", "UTF-8") + "=" + URLEncoder.encode("Jose", "UTF-8");
			data += "&" + URLEncoder.encode("LN", "UTF-8") + "=" + URLEncoder.encode("Arzuaga", "UTF-8");

			// Send data
			URL url = new URL("https://stage.applywise.com:8443/dashboard/ShoppingCart.aspx");
			URLConnection conn = url.openConnection();

			/*
			 * System.out.println("URL Path: "+url.getPath());
			 * System.out.println("URL Host: "+url.getHost());
			 * System.out.println("URL: "+url.toString());
			 */

			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// System.out.println(conn.getInputStream().toString().getBytes());

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null)
			{
				// System.out.println(line);
			}
			wr.close();
			rd.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String encodeURL(String url, String key)
	{
		String encoded = "";
		int keyLenght = key.length();
		char[] keyCharArray = key.toCharArray();
		int i = 0;
		for (char c : url.toCharArray())
		{
			int encodedChar = (int) c ^ (int) keyCharArray[i % keyLenght];
			encoded += (char) ((encodedChar & 0x0F) + 97) + "" + (char) ((encodedChar >> 4) + 97);
			i++;
		}

		return encoded;

	}
}
