package parts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegexTest {

	public static void main (String [] args){
		String regex = "<img .*/>";
		
		String s1 = "'What is the value of 4 minus <img alt=\"\" src=\"/lib/image/placeholder/F1.jpg\" id=\"M-PSA-PS07-P003-C01-X01\" />  of  <img alt=\"\" src=\"/lib/image/placeholder/F1.jpg\" id=\"M-PSA-PS07-P003-C01-X02\" /> ?'";
		
		String s = "'If the area of &#x0394;<i>XYZ</i> is&#160;<img id=\"M-SAT-SA34-P006-C01-X01\" src=\"/lib/image/placeholder/W10.jpg\" alt=\"\" />, what is the length of&#160;<span class=\"qbox-no-wrap\" style=\"white-space: nowrap;\"><img id=\"M-SAT-SA34-P006-C01-X02\" src=\"/lib/image/placeholder/W10.jpg\" alt=\"\" /> ?</span>'";
		int imageId = 1;
		
		while (s.contains("<img")){
			
			int startingIndex = s.indexOf("<img");
			int endingIndex = (s.substring(startingIndex)).indexOf(">")+1;
			String toReplace = (s.substring(startingIndex)).substring(0,endingIndex);		
				 
			System.out.println("String to replace: "+toReplace);
			String guid = toReplace.substring(toReplace.indexOf("id=\"")+4, toReplace.indexOf("\"",toReplace.indexOf("id=\"")+4));
			String subject = guid.substring(0,1);
			String test = guid.substring(2,5);
			String lo = guid.substring(6,10);
			
			ImageInfo imageInfo = getImageInfo(guid);
			String href = "<div id=\"ansimageIndex"+imageId+"\" type=\"image\"> <object type=\"image\" data=\"/pc-content/xml/ip/"+subject+"/"+test+"/"+lo+"/images/"+guid+"."+imageInfo.getFormat()+"\" width=\""+imageInfo.getWidth()+"\"  height=\""+imageInfo.getHeight()+"\"/> </div>";
			
			s=s.replace(toReplace, href);
		
			
			System.out.println("S: "+s);
			
			System.out.println("Guid: "+guid);
			System.out.println("Subject: "+subject);
			System.out.println("Test: "+test);
			System.out.println("LO: "+lo);
			
			imageId++;
		}
		System.out.println("Final String: "+s);
		
		
	}
	public static ImageInfo getImageInfo(String guid){
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/qbox_qa2?useUnicode=true&amp;characterEncoding=utf-8";				
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "12345";
		ImageInfo info = new ImageInfo();
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to the database");
							
			String answerQuery = "select height, width, format from image where guid = '"+guid+"';";
			
			PreparedStatement stmt = conn.prepareStatement(answerQuery);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				info.setFormat(rs.getString("format"));
				info.setWidth(rs.getInt("width"));
				info.setHeight(rs.getInt("height"));
			}
			return info;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return info;
	}
}
