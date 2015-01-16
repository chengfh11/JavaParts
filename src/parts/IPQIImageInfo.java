package junk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;


public class IPQIImageInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//String DATE_FORMAT = "yyyyMMddHHmms";
		//SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		//String timestamp = dateFormat.format(new Date());
		//String path = "C:\\development\\";
		//String learningObjective = "ACT-Math";
		//String output= timestamp+"_"+learningObjective+"_ImageHrefFix.sql";
		
		String basePath = "";
		int charactersToTrim = 0;
		
		if(args[1].equals("remote")){
			basePath = "Z:\\";
			charactersToTrim = 24;
		}
		else{
			basePath = "C:\\development\\apache-tomcat-6.0.26\\apache-tomcat-6.0.26\\webapps\\pc-content\\xml\\";
			charactersToTrim = 101;
		}
		
		
		long start = System.currentTimeMillis();

		List<String> los = new ArrayList<String>();
		los.add(args[0]);
		//los.add("PS02");
		
		try{
			// Get the object of DataInputStream
			List<String> images;


/*			FileWriter writer = new FileWriter(path+output);
			BufferedWriter out = new BufferedWriter(writer);

			out.write("-- $Id: $"+"\n\n");
			out.write("SET NAMES 'UTF8';"+"\n\n");
			out.write("SET SESSION SQL_MODE = 'ANSI';"+"\n\n");
			out.write("-- Begin"+"\n\n");*/

			ImageIcon image = null;
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/qbox_qa2?useUnicode=true&amp;characterEncoding=utf-8";				
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "12345";

			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url,userName,password);
				System.out.println("Connected to the database");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			// Print the content on the console

			//All images
			//images = search("path:*.gif* path:*.bmp*  path:*.jpg* -path:*.svn-base* path:*.png*", false);
			
			//PNG Only
			images = search("-path:*.svn-base* path:*.png*", false);
			
			//GIF Only
			//images = search("-path:*.svn-base* path:*.gif*", false);
			
			//JPG Only
			//images = search("-path:*.svn-base* path:*.jpg*", false);

			String extension = "";
			String name = "";
			String href = "";
			String guid = "";

			int i = 0;
			
			for(String str:images){

				//String s = "C:\\development\\apache-tomcat-6.0.26\\apache-tomcat-6.0.26\\webapps\\pc-content\\trunk\\xml\\ip\\M\\ACT\\"+learningO+"\\images\\";
				//System.out.println(str);
				boolean useIt = false;
				
				for(String learningO:los){
					
					if(learningO.contains("SA")){
						useIt = useIt || str.contains(basePath+"ip\\M\\SAT\\"+learningO+"\\images\\");
					}
					else if(learningO.contains("AC")){
						useIt = useIt || str.contains(basePath+"ip\\M\\ACT\\"+learningO+"\\images\\");
					}
					else if(learningO.contains("PS")){
						useIt = useIt || str.contains(basePath+"ip\\M\\PSA\\"+learningO+"\\images\\");
					}
					
					//System.out.println(useIt);
				}
				
				if(useIt){			
					
					//System.out.println("str: "+str);
					image = new ImageIcon(str);
					int width = image.getIconWidth();
					int height = image.getIconHeight();
					name = str.substring(charactersToTrim);
					//System.out.println("The name of image: " + name);
					extension = name.split("\\.")[1];
					//System.out.println("The extension of image: " + extension);
					if(args[1].equals("remote")){
						href = str.substring(2, str.length()-4);						
						href = "xml"+href;
					}
					else{
						href = str.substring(76, str.length()-4);						
					}					
					href = href.replace('\\', '/');
					//System.out.println("The href of image: " + href);
					guid = name.split("\\.")[0];
					//System.out.println("The guid of image: " + guid);
					String imageQuery = "select * from image where guid = '"+guid+"';";

					
						//System.out.println("The width of image: " + width);					
						//System.out.println("The height of image: " + height);
						
						
						

					if(!(guid.contains("Y01")||guid.contains("Y02")||guid.contains("Y03")||guid.contains("X02"))){
					//if(true){

						try {
							PreparedStatement stmt = conn.prepareStatement(imageQuery);
							ResultSet rs = stmt.executeQuery();
							boolean  emptyRs = true;
							i++;
							
							while(rs.next()){
								emptyRs = false;
								String queryForLyle = "UPDATE \"image\" SET \"width\" = "+width+", \"height\" = "+height+", \"format\" = '"+extension+"', \"updated_at\" = NOW(), \"href\" = '"+href+"' WHERE \"guid\" = '"+guid+"' AND guid like 'M-%';";
								System.out.println(queryForLyle);
								//out.write(queryForLyle+"\n");
								if(guid.contains("C01-X01")||guid.contains("C01-X1")||guid.contains("C01-G")){
									String updateStem = "UPDATE \"independent_practice\" SET \"stem_text\" = NULL, \"stem_image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"') WHERE \"guid\" = '"+guid.substring(0,15)+"';";
									System.out.println(updateStem);
								}
								if(guid.contains("C2-X01")||guid.contains("C02-X1")||guid.contains("C01-X02")||guid.contains("C02-G")||guid.contains("C01-X2")){
									String updateStem = "UPDATE \"independent_practice\" SET \"stimulus_text\" = NULL, \"stimulus_image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"') WHERE \"guid\" = '"+guid.substring(0,15)+"';";
									System.out.println(updateStem);
								}
								if(guid.contains("C10-X01")||guid.contains("C11-X01")||guid.contains("C12-X01")||guid.contains("C13-X01")||guid.contains("C14-X01")||guid.contains("C10-G")||guid.contains("C11-G")||guid.contains("C12-G")||guid.contains("C13-G")||guid.contains("C14-G")){
									String answerOrder="";
									if(guid.contains("C10")){
										answerOrder="1";
									}
									else if(guid.contains("C11")){
										answerOrder="2";
									}
									else if(guid.contains("C12")){
										answerOrder="3";
									}
									else if(guid.contains("C13")){
										answerOrder="4";
									}
									else if(guid.contains("C14")){
										answerOrder="5";
									}
									String orderQuery = "select id from answer where answer_set_id in (select id from answer_set where ip_id in (select id from independent_practice where guid like ('"+guid.substring(0,15)+"'))) and display_order = "+answerOrder+";";
									//System.out.println("guid.substring(0,15)"+guid.substring(0,15));
									PreparedStatement stmt1 = conn.prepareStatement(orderQuery);
									ResultSet rs1 = stmt1.executeQuery();
									int id = -1;
									while(rs1.next()){
										id = rs1.getInt("id");
									}
									if(id!=-1){
										String updateAnswer = "UPDATE \"answer\" SET \"image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"'), \"display_text\" = NULL WHERE id = "+id+";";
										System.out.println(updateAnswer);
									}									
								}
							}
							if(emptyRs){
								String type = "";
								if(guid.contains("C01")){
									type = "stem";
								}
								else if(guid.contains("C02")){
									type = "stimulus";
								} 
								else if(guid.contains("Y01")||guid.contains("Y02")){
									type = "explanation";
								}
								else if(guid.contains("C10")||guid.contains("C11")||guid.contains("C12")||guid.contains("C13")||guid.contains("C14")){
									type = "answer";
								}
								
								String insert = "INSERT INTO \"image\" (\"guid\", \"art_description\", \"href\", \"title\", \"type\", \"height\", \"width\", \"format\", \"created_at\", \"created_by\", \"version\" ) " +
										"VALUES ('"+guid+"', '', '"+href+"','"+guid+"', '"+type+"', "+height+", "+width+", '"+extension+"', NOW(), 1, 0);";
								System.out.println(insert);
								if(guid.contains("C01-X01")||guid.contains("C01-X1")||guid.contains("C01-G")){
									String updateStem = "UPDATE \"independent_practice\" SET \"stem_text\" = NULL, \"stem_image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"') WHERE \"guid\" = '"+guid.substring(0,15)+"';";
									System.out.println(updateStem);
								}
								if(guid.contains("C2-X01")||guid.contains("C02-X1")||guid.contains("C02-G")){
									String updateStem = "UPDATE \"independent_practice\" SET \"stimulus_text\" = NULL, \"stimulus_image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"') WHERE \"guid\" = '"+guid.substring(0,15)+"';";
									System.out.println(updateStem);
								}
								if(guid.contains("C10-X01")||guid.contains("C11-X01")||guid.contains("C12-X01")||guid.contains("C13-X01")||guid.contains("C14-X01")||guid.contains("C10-G")||guid.contains("C11-G")||guid.contains("C12-G")||guid.contains("C13-G")||guid.contains("C14-G")){
									String answerOrder="";
									if(guid.contains("C10")){
										answerOrder="1";
									}
									else if(guid.contains("C11")){
										answerOrder="2";
									}
									else if(guid.contains("C12")){
										answerOrder="3";
									}
									else if(guid.contains("C13")){
										answerOrder="4";
									}
									else if(guid.contains("C14")){
										answerOrder="5";
									}
									String orderQuery = "select id from answer where answer_set_id in (select id from answer_set where ip_id in (select id from independent_practice where guid like ('"+guid.substring(0,15)+"'))) and display_order = "+answerOrder+";";
									PreparedStatement stmt1 = conn.prepareStatement(orderQuery);
									ResultSet rs1 = stmt1.executeQuery();
									int id = -1;
									while(rs1.next()){
										id = rs1.getInt("id");
									}
									if(id!=-1){
										String updateAnswer = "UPDATE \"answer\" SET \"image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '"+guid+"'), \"display_text\" = NULL WHERE id = "+id+";";
										System.out.println(updateAnswer);
									}									
								}
							}
						}
						catch (Exception e) {
							e.printStackTrace();
						}						
					}

				}
			}
			System.out.println("Created "+i+" sql statements.");
		}
		catch (Exception e){
			System.err.println("Error: " + e);
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: "+((end-start)/1000)+" seconds");

	}
	@SuppressWarnings("deprecation")
	public static List<String> search(String queryStr, boolean secondTime) throws Exception {
		String index = "C:\\development\\index";
		String field = "contents";
		String queries = null;
		int hitsPerPage = 10000;

		IndexReader reader = IndexReader.open(FSDirectory.open(new File(index)), true); // only searching, so read-only=true

		Searcher searcher = new IndexSearcher(reader);
		Analyzer analyzer = new KeywordAnalyzer();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));		
		QueryParser parser = new QueryParser(null, field, analyzer);
		parser.setAllowLeadingWildcard(true);
		parser.setLowercaseExpandedTerms(false);

		Query query = parser.parse(queryStr);
		//System.out.println("Searching for: " + query.toString(field));

		List<String> images = doPagingSearch(in, searcher, query, hitsPerPage, secondTime, queries == null);
		reader.close();
		return images;
	}
	public static List<String> doPagingSearch(BufferedReader in, Searcher searcher, Query query, 
			int hitsPerPage, boolean secondTime, boolean interactive) throws IOException {

		TopScoreDocCollector collector = TopScoreDocCollector.create(5 * hitsPerPage, false);
		searcher.search(query, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		int numTotalHits = collector.getTotalHits();
		//System.out.println(numTotalHits + " total matching documents");

		int start = 0;
		int end = Math.min(numTotalHits, hitsPerPage);

		if (end > hits.length) {
			collector = TopScoreDocCollector.create(numTotalHits, false);
			searcher.search(query, collector);
			hits = collector.topDocs().scoreDocs;
		}

		end = Math.min(hits.length, start + hitsPerPage);

		List<String> images = new ArrayList<String>();

		for (int i = start; i < end; i++) {

			Document doc = searcher.doc(hits[i].doc);
			String path = doc.get("path");
			if (path != null) {
				//System.out.println((i+1) + ". " + path);
				if(secondTime){
					path="*"+path;
				}
				images.add(path);
				String title = doc.get("title");
				if (title != null) {
					System.out.println("   Title: " + doc.get("title"));
				}
			} 
			else {
				System.out.println((i+1) + ". " + "No path for this document");
			}
		}
		return images;
	}
}
