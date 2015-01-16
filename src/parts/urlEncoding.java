package junk;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;


public class urlEncoding
{
	public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException
	{
		
		String urlStr = "http://localhost:8080/smarttrack/k12_admin/j_spring_security_check?j_username=dctest6@test.com&j_password=" + URLEncoder.encode("kaplan!@#", "ISO-8859-1");
		
		URI uri = new URI(urlStr);
		System.out.println(urlStr);
	}
}
