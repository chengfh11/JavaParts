package parts;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


public class IPQIRenameAnswerImages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int charactersToTrim = 107;
		String DATE_FORMAT = "yyyyMMddHHmm";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String timestamp = dateFormat.format(new Date());

		String path = "C:\\development\\";
		String output= timestamp+"ImageHrefFix.sql";

		long start = System.currentTimeMillis();

		try{
			// Get the object of DataInputStream
			List<String> images;


			FileWriter writer = new FileWriter(path+output);
			BufferedWriter out = new BufferedWriter(writer);

			out.write("-- $Id: $"+"\n\n");
			out.write("-- PCPD-1628"+"\n\n");
			out.write("SET NAMES 'UTF8';"+"\n\n");
			out.write("SET SESSION SQL_MODE = 'ANSI';"+"\n\n");
			out.write("-- Begin"+"\n\n");

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

			images = search("path:*-A?.gif*  path:*-A?.jpg* -path:*.svn-base* path:*-A?.png* -path:*M-SAT* -path:*M-PSA*", false); 
			String extension = "";
			String name = "";
			String href = "";
			String guid = "";

			for(String str:images){

				String filePath = str.substring(0,107);
				//System.out.println(str);

				String prefix = str.substring(107,123);
				//System.out.println(prefix);



				String sufix = str.substring(123,125);
				//System.out.println(sufix);

				String format = str.substring(125);
				//System.out.println(format);

				if(sufix.equals("A1")){
					sufix = "C10-G";
				}
				else if(sufix.equals("A2")){
					sufix = "C11-G";
				}
				else if(sufix.equals("A3")){
					sufix = "C12-G";
				}
				else if(sufix.equals("A4")){
					sufix = "C13-G";
				}
				else if(sufix.equals("A5")){
					sufix = "C14-G";
				}

				String newFile = filePath+prefix+sufix+format;

				//System.out.println(newFile);

				File file = new File(str);
				File file2 = new File(newFile);
				try{
					boolean success = file.renameTo(file2);
					//boolean success = false;
					if (!success) {
						System.out.println("File: "+newFile+" was not renamed");
					}
					else{
						file.delete();
					}					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}

			}


		}
		catch (Exception e){
			System.err.println("Error: " + e);
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
