package parts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

public class IPQIImageLocator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		String path = "C:\\development\\";
		String input = "guids.txt";
		String output = "out.csv";
		int charactersToTrim = 81;

		long start = System.currentTimeMillis();

		try
		{
			FileInputStream fstream = new FileInputStream(path + input);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			List<String> images;

			FileWriter writer = new FileWriter(path + output);
			BufferedWriter out = new BufferedWriter(writer);

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				// Print the content on the console
				strLine = strLine.trim();
				images = search("path:*" + strLine + "* -path:*.pdf* -path:*.doc* -path:*.svn-base*", false);

				// If there are no matches we search again with a substring of the image's guid
				if (images.size() == 0)
				{
					strLine = strLine.substring(0, 19);
					images = search("path:*" + strLine + "* -path:*.pdf* -path:*.doc* -path:*.svn-base* ", true);
				}

				String toWrite = strLine;
				System.out.println(strLine);
				for (String str : images)
				{
					str = str.substring(charactersToTrim);
					toWrite += "," + str;
					System.out.println("\t" + str);
				}
				out.write(toWrite + "\n");
			}
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + ((end - start) / 1000) + " seconds");

	}
	@SuppressWarnings("deprecation")
	public static List<String> search(String queryStr, boolean secondTime) throws Exception
	{
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
		// System.out.println("Searching for: " + query.toString(field));

		List<String> images = doPagingSearch(in, searcher, query, hitsPerPage, secondTime, queries == null);
		reader.close();
		return images;
	}

	public static List<String> doPagingSearch(BufferedReader in, Searcher searcher, Query query, int hitsPerPage, boolean secondTime, boolean interactive) throws IOException
	{

		TopScoreDocCollector collector = TopScoreDocCollector.create(5 * hitsPerPage, false);
		searcher.search(query, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		int numTotalHits = collector.getTotalHits();
		// System.out.println(numTotalHits + " total matching documents");

		int start = 0;
		int end = Math.min(numTotalHits, hitsPerPage);

		if (end > hits.length)
		{
			collector = TopScoreDocCollector.create(numTotalHits, false);
			searcher.search(query, collector);
			hits = collector.topDocs().scoreDocs;
		}

		end = Math.min(hits.length, start + hitsPerPage);

		List<String> images = new ArrayList<String>();

		for (int i = start; i < end; i++)
		{

			Document doc = searcher.doc(hits[i].doc);
			String path = doc.get("path");
			if (path != null)
			{
				// System.out.println((i+1) + ". " + path);
				if (secondTime)
				{
					path = "*" + path;
				}
				images.add(path);
				String title = doc.get("title");
				if (title != null)
				{
					System.out.println("   Title: " + doc.get("title"));
				}
			}
			else
			{
				System.out.println((i + 1) + ". " + "No path for this document");
			}
		}
		return images;
	}
}
