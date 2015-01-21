package parts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample
{
	private static final int MYTHREADS = 30;

	public static void main(String args[]) throws Exception
	{
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		List<Future<String>> futureList = new ArrayList<Future<String>>();

		String[] hostList = { "http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com", "http://www.example.co", "https://paypal.com", "http://bing.com/",
				"http://techcrunch.com/", "http://mashable.com/", "http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/", "http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/", "http://www.wikipedia.org/", "http://en.wikipedia.org/wiki/Main_Page" };

		// Create instance of outter class, optional if the inner classs is static
		// ExecutorServiceExample outer = new ExecutorServiceExample();

		for (String url : hostList)
		{
			Future<String> future = executor.submit(new Threading(url));
			futureList.add(future);
		}
		executor.shutdown();

		for (Future<String> x : futureList)
		{
			// Note: .get() method return the object itself, this case string
			System.out.println(">" + x.get() + "<");
		}

		System.out.println("\nFinished all threads");

	}

	public static class Threading implements Callable<String>
	{
		private final String url;

		private Threading(String url)
		{
			this.url = url;
		}

		public String call() throws Exception
		{
			String time = new Timestamp(System.currentTimeMillis()).toString();
			return time;
		}
	}
}