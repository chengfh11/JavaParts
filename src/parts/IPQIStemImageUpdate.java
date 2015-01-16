package junk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class IPQIStemImageUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String DATE_FORMAT = "yyyyMMddHm";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String timestamp = dateFormat.format(new Date());

		String path = "C:\\development\\";
		String output= timestamp+"_StemImageUpdate.sql";
		
		//Switch between stem or answer update
		boolean isStemUpdate = true;

		long start = System.currentTimeMillis();

		try{
			FileWriter writer = new FileWriter(path+output);
			BufferedWriter out = new BufferedWriter(writer);

			out.write("-- $Id: $"+"\n\n");
			out.write("-- Update Stems having image references to use correct markup."+"\n\n");
			out.write("SET NAMES 'UTF8';"+"\n\n");
			out.write("SET SESSION SQL_MODE = 'ANSI';"+"\n\n");
			out.write("-- Begin"+"\n\n");

			try {
				Connection conn = getConnection();
				System.out.println("Connected to the database");
				String answerQuery = "";

				if(isStemUpdate){
					answerQuery = "select * from independent_practice where stem_text like '%<img%';";
				}
				else{
					answerQuery = "select * from answer where display_text like '%<img%';";
				}				

				PreparedStatement stmt = conn.prepareStatement(answerQuery);
				ResultSet rs = stmt.executeQuery();
				String update = "";
				
				while(rs.next()){
					
					String stem = "";
					String display_text = "";
					
					if(isStemUpdate){
						stem = updateStemText(rs.getString("stem_text"));
						if(stem != ""){
							update = "UPDATE \"independent_practice\" SET \"stem_text\" = '"+stem+"' WHERE \"id\" = "+rs.getInt("id")+";";
							out.write(update+"\n");
						}
					}
					else{
						display_text = updateStemText(rs.getString("display_text"));
						if(display_text != ""){
							update = "UPDATE \"answer\" SET \"display_text\" = '"+display_text+"' WHERE \"id\" = "+rs.getInt("id")+";";
							out.write(update+"\n");
						}
					}					
				}				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			out.close();
			System.out.println("Disconnected from database");
		}
		catch (Exception e){
			System.err.println("Error: " + e);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: "+((end-start)/1000)+" seconds");

	}
	public static String updateStemText(String stem){

		int imageId = 1;
		while (stem.contains("<img")){

			int startingIndex = stem.indexOf("<img");
			int endingIndex = (stem.substring(startingIndex)).indexOf(">")+1;
			String toReplace = (stem.substring(startingIndex)).substring(0,endingIndex);		

			System.out.println("String to replace: "+toReplace);
			String guid = toReplace.substring(toReplace.indexOf("id=\"")+4, toReplace.indexOf("\"",toReplace.indexOf("id=\"")+4));
			String subject = guid.substring(0,1);
			String test = guid.substring(2,5);
			String lo = guid.substring(6,10);

			ImageInfo imageInfo = getImageInfo(guid);
			if(imageInfo.getFormat()==null){
				return "";
			}
			String href = "<div id=\"stemImage_"+imageId+"\" type=\"image\"> <object type=\"image\" data=\"/pc-content/xml/ip/"+subject+"/"+test+"/"+lo+"/images/"+guid+"."+imageInfo.getFormat()+"\" width=\""+imageInfo.getWidth()+"\"  height=\""+imageInfo.getHeight()+"\"/> </div>";

			stem=stem.replace(toReplace, href);


			System.out.println("S: "+stem);

			System.out.println("Guid: "+guid);
			System.out.println("Subject: "+subject);
			System.out.println("Test: "+test);
			System.out.println("LO: "+lo);

			imageId++;
		}
		System.out.println("Final String: "+stem);
		return stem;
	}
	public static ImageInfo getImageInfo(String guid){

		ImageInfo info = new ImageInfo();

		try {
			Connection conn = getConnection();
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
		}
		return info;
	}
	public static Connection getConnection(){

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/qbox_qa2?useUnicode=true&amp;characterEncoding=utf-8";				
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "12345";

		try {
			try {
				Class.forName(driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url,userName,password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
