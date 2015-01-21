package parts;

import java.util.ArrayList;
import java.util.List;

public class Multithreading implements Runnable
{
	private static final int threads = 7;

	public Multithreading()
	{
		Thread thread = new Thread(this);
		thread.start();
	}

	public static void main(String[] args) throws InterruptedException
	{
		List<Multithreading> workers = new ArrayList<Multithreading>();

		for (int i = 0; i < threads; i++)
		{
			workers.add(new Multithreading());
		}
	}

	@Override
	public synchronized void run()
	{
		System.out.println("the id is: " + Thread.currentThread().getId());

	}
}