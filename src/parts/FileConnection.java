package junk;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileConnection {
	
	public static void main(String[] args) {
		

    	InputStream in = null;
		try {
			
			
			 //modified code
			 URL url = new URL("http://qa3.smarttrack.kaplankids.com/pc-content/xml/ip/k8/MK/MK_L023_A10.xml");
			 URLConnection urlConnection = url.openConnection();
			 urlConnection.setConnectTimeout(10000);
			 urlConnection.setReadTimeout(10000);
			 in = new BufferedInputStream(urlConnection.getInputStream());

			 BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("windows-1252")));
				String line;
				StringBuilder sb = new StringBuilder();

				while((line=br.readLine())!= null){
				    sb.append(line);
				}
				String independecePracticeXmlString = sb.toString();
				independecePracticeXmlString = replaceSpecialChars(independecePracticeXmlString);
			
        System.out.println("out put:>>> "+independecePracticeXmlString);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
    public static String replaceSpecialChars(String text) {
        String result = text;
        if (text != null) {
            Set<String> specialChars = FileConnection.getSpecialChars();
            for(String key : specialChars) {
                if (!key.equals("?")) {
                    String value = FileConnection.replaceSpecialChar(key);
                    if (value != null) {
                        if (key.equals("&")) {
                            result = replaceAmp(result);
                        } else if (key.equals("<")) {
                            result = result.replaceAll("<[^/?\\w+>]", value);
                        } else if (key.equals(">")) {
                            result = result.replaceAll("[^</?\\w+]>", value);
                        } else {
                            result = result.replaceAll("\\" + key, value);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Below code are used to replace special chars from the ipqi xml
     * A Hashpmap is created to hold all the special chars
     * 
     */
    private static final Map<String, String> specialChars = new HashMap<String, String>();
    static {
    	// specialChars.put("&", "&#38;");
        specialChars.put("&minus;", "&#8211;");
        specialChars.put("&times;", "&#215;");
        specialChars.put("�", "&#247;");
        specialChars.put("�", "&#8800;");
        //specialChars.put(">", "&#62;");
        // specialChars.put("<", "&#60;");
        specialChars.put("�", "&#8805;");
        specialChars.put("�", "&#8804;");
        specialChars.put("�", "&#162;");
        specialChars.put("�", "&#176;");
        specialChars.put("%", "&#37;");
        specialChars.put("�", "&#177;");
        specialChars.put("�", "&#8776;");
        specialChars.put("�", "&#34;");
        specialChars.put("�", "&#34;");
        // specialChars.put("\"", "&#34;");
        specialChars.put("�", "&#39;");
        specialChars.put("�", "&#39;");
        // specialChars.put("\'", "&#39;");
        specialChars.put("�", "&#960;");
        specialChars.put("�", "&#225;");
        specialChars.put("&aacute;", "&#225;");
        specialChars.put("�", "&#193;");
        specialChars.put("&Aacute;", "&#193;");
        specialChars.put("�", "&#233;");
        specialChars.put("&eacute;", "&#233;");
        specialChars.put("�", "&#201;");
        specialChars.put("&Eacute;", "&#201;");
        specialChars.put("�", "&#237;");
        specialChars.put("&iacute;", "&#237;");
        specialChars.put("�", "&#205;");
        specialChars.put("&Iacute;", "&#205;");
        specialChars.put("�", "&#243;");
        specialChars.put("&oacute;", "&#243;");
        specialChars.put("�", "&#211;");
        specialChars.put("&Oacute;", "&#211;");
        specialChars.put("�", "&#250;");
        specialChars.put("&uacute;", "&#250;");
        specialChars.put("�", "&#218;");
        specialChars.put("&Uacute;", "&#218;");
        // specialChars.put("?", "&#253;");
        // specialChars.put("?", "&#221;");
        specialChars.put("�", "&#241;");
        specialChars.put("&ntilde;", "&#241;");
        specialChars.put("�", "&#209;");
        specialChars.put("&Ntilde;", "&#209;");
        specialChars.put("�", "&#252;");
        specialChars.put("�", "&#220;");
        specialChars.put("�", "&#8482;");
        specialChars.put("�", "&#174;");
        specialChars.put("�", "&#169;");
        specialChars.put("�", "&#8230;");
    }
    
    public static String replaceSpecialChar(String s) {
        return specialChars.get(s);
    }

    public static Set<String> getSpecialChars() {
        return specialChars.keySet();
    }

    /**
     * Replace the Amp replace with "&#38"
     * @param text
     * @return
     */
    public static String replaceAmp(String text) {
        if (text != null) {
            String code = "&#38;";
            Pattern pattern = Pattern.compile("\\&([^#\\d+;|^\\S+;])");
            Matcher matcher = pattern.matcher(text);
            if (text.length() > 1) {
                while(matcher.find()) {
                    String group = matcher.group();
                    String groupOne = matcher.group(1);
                    text = text.replaceAll(group, code + groupOne);
                }
            } else {
                text = text.replace("&", code);
            }
        }
        return text;
    }
}
