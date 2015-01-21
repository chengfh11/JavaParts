package parts;

import java.io.StringWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class ExecutorServiceExample
{
	private static final int MYTHREADS = 30;

	public static void main(String args[]) throws Exception
	{
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		String[] hostList = { "http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com", "http://www.example.co", "https://paypal.com", "http://bing.com/",
				"http://techcrunch.com/", "http://mashable.com/", "http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/", "http://www.wikipedia.org/", "http://en.wikipedia.org/wiki/Main_Page" };

		for (int i = 0; i < hostList.length; i++)
		{

			String url = hostList[i];
			// Runnable worker = new Threading(url);
			// executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated())
		{

		}
		System.out.println("\nFinished all threads");
	}

	public class Threading implements Callable<Document>
	{
		private final String url;

		public Threading(String url)
		{
			this.url = url;
		}

		public Document call() throws Exception
		{
			Document doc = null;
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				StringWriter writer = new StringWriter();
				// Reader reader = HttpInvoker.execute(url);

				doc = builder.parse(new InputSource(reader));
				doc.getDocumentElement().normalize();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				// if there is any issue with any of the thread execution, return other thread results
				return doc;
			}
			return doc;
		}
	}
}
